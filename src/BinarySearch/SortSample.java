package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortSample {
	static int[] quickArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//n개의 수가 주어졌을때 오름차순으로 정렬하는 문제
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		int[] result;
		result = bubbleSort(arr.clone());
		Arrays.stream(result).forEach((i) ->{
			System.out.print(i);
		});
		
		result = selectionSort(arr.clone());
		System.out.println();
		Arrays.stream(result).forEach((i) ->{
			System.out.print(i);
		});
		
		result = insertionSort(arr.clone());
		System.out.println();
		Arrays.stream(result).forEach((i) ->{
			System.out.print(i);
		});
		
		quickArr = arr.clone();
		quickSort(0, quickArr.length-1);
		System.out.println();
		Arrays.stream(quickArr).forEach((i) ->{
			System.out.print(i);
		});
		
		result = mergeSort(arr.clone());
		System.out.println();
		Arrays.stream(result).forEach((i) ->{
			System.out.print(i);
		});
		
		result = radixSort(arr.clone());
		System.out.println();
		Arrays.stream(result).forEach((i) ->{
			System.out.print(i);
		});
		
	}
	
	
	static int[] bubbleSort(int[] arr) {
		for(int i = arr.length-1; i>0; i--) {
			for(int j = 0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	static int[] selectionSort(int[] arr) {
		for(int i = 0; i<arr.length-1; i++) {
			int min = i;
			for(int j = i; j<arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	static int[] insertionSort(int[] arr) {
		for(int i = 1; i<arr.length; i++) {
			for(int j = i-1; j>=0; j--) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
				else break;
			}
		}
		
		return arr;
	}
	
	static void quickSort(int s, int e) {
		//s,e포인터가 서로를 넘어가는 경우를 어떻게 해결해야 할지 도저히 생각이 안났음
		//그래서 이경우 저경우 맴도는 생각을 하다가 4시간 이상을 고민했음
		//결과적으로 s,e포인터가 서로를 넘지않도록 상황을 제한하여 문제를 해결하였음
		//앞으로 이런 복잡한 상황이 발생하면 무조건 구현하는 것보다, 
		//이런 머리 아픈 상황이 나오지 않도록 제한된 상황을 만들 수 없을까? 먼저 고민해보기!!!!!
		
		if(s>=e) return;
		
		int pivot = s;
		int end = e;
		s++;
		while(true) {
			//s 포인터와 e포인터가 서로를 넘어가지 않도록
			while(s+1 <= e && quickArr[s] < quickArr[pivot]) s++;
			while(e-1 >= s && quickArr[e] > quickArr[pivot]) e--;
			
			if(s<e) {
				int temp = quickArr[s];
				quickArr[s] = quickArr[e];
				quickArr[e] = temp;
			}
			
			if(s == e) {
				if(quickArr[s] > quickArr[pivot]) {
					int temp = quickArr[s-1];
					quickArr[s-1] = quickArr[pivot];
					quickArr[pivot] = temp;
					s--;
				}
				else if(quickArr[s] < quickArr[pivot]) {
					int temp = quickArr[s];
					quickArr[s] = quickArr[pivot];
					quickArr[pivot] = temp;
				}
				break;
			}
		}
		
		quickSort(pivot, s-1);
		quickSort(s+1, end);
		
	}
	
	static int[] mergeSort(int[] arr) {
		return arr;
	}

	static int[] radixSort(int[] arr) {
		return arr;
	}
}
