package BinarySearch;

import java.io.*;
import java.util.*;

public class SortSample {
	static int[] quickArr;
	static int[] mergeArr;
	
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
		quickSort(0, n-1);
		System.out.println();
		Arrays.stream(quickArr).forEach((i) ->{
			System.out.print(i);
		});
		
		mergeArr = arr.clone();
		mergeSort(0, n-1);
		System.out.println();
		Arrays.stream(mergeArr).forEach((i) ->{
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
	
	static void mergeSort(int s, int e) {
		//s==e인 경우 종료
		if(s == e) return;
		
		//s~e인덱스를 절반으로 나누어 재귀 호출
		int mid = (s+e)/2;
		mergeSort(s, mid);
		mergeSort(mid+1, e);
		
		//임시 배열을 만들어 수를 정렬하고 원본배열에 복사
		int[] temp = new int[e-s+1];
		int p1 = s;
		int p2 = mid+1;
		int i = 0;
		
		while(p1 <= mid && p2<=e) {
			if(mergeArr[p1] < mergeArr[p2]) {
				temp[i] = mergeArr[p1];
				p1 ++;
			}
			else {
				temp[i] = mergeArr[p2];
				p2 ++;
			}
			i++;
		}
		
		//남은 요소 다 털어버리기
		while(p1 <= mid) {
			temp[i] = mergeArr[p1];
			p1++;
			i++;
		}
		
		while(p2 <= e) {
			temp[i] = mergeArr[p2];
			p2++;
			i++;
		}
		
		//원본 배열에 복사하기
		for(int k = 0; k<temp.length; k++) {
			mergeArr[s+k] = temp[k];
		}
		
	}

	static int[] radixSort(int[] arr) {		
		//0~9까지 담을 큐 생성
		Queue<Integer>[] queArr = new Queue[19];
		for(int i = 0; i<19; i++) {
			queArr[i] = new LinkedList<Integer>();
		}
		
		//가장 큰 숫자의 자릿수 만큼 반복 - 10000000
		for(int i = 1; i<=8; i++) {
			//배열 전체를 순회하면서 알맞은 큐에 삽입
			//음수에 대한 처리를 하지 않아서 계속 인덱스 초과 오류가 떴음
			for(int j = 0; j<arr.length; j++) {
				int k = (int) ((arr[j] / Math.pow(10, i-1)) % 10);
				queArr[9+k].add(arr[j]);
			}
			
			//0을 담은 queue부터 배열에 담기
			int p = 0;
			for(int j = 0; j<19; j++) {
				while(!queArr[j].isEmpty()) {
					arr[p] = queArr[j].poll(); 
					p++;
				}
			}
					
		}
		return arr;
	}
}
