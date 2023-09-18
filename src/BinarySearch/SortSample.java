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
		if(s>=e) return;
		
		if(s+1 == e) {
			if(quickArr[s] > quickArr[e]) {
				int temp = quickArr[s];
				quickArr[s] = quickArr[e];
				quickArr[e] = temp;
			}
			return;
		}
		
		int pivot = s;
		s = s+1;
		
		while(s<e) {
			while(s<quickArr.length && quickArr[s] < quickArr[pivot]) s++;
			while(e>=0 && quickArr[e] > quickArr[pivot]) e--;
			
			if(s<e) {
				int temp = quickArr[s];
				quickArr[s] = quickArr[e];
				quickArr[e] = temp;
				
				s++;
				e--;
			}
		}
		
		int temp = quickArr[s-1];
		quickArr[s-1] = quickArr[pivot];
		quickArr[pivot] = temp;
		
		quickSort(pivot, s-2);
		quickSort(s, e);	
	}
	
	static int[] mergeSort(int[] arr) {
		return arr;
	}

	static int[] radixSort(int[] arr) {
		return arr;
	}
}
