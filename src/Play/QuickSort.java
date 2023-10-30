package Play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//n개의 수가 주어졌을때 오름차순으로 정렬하는 문제
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr);
		quickSort(0, n-1);
		
		for(int i = 0; i<n; i++) {
			System.out.println(arr[i]);
		}

	}
	
	static void quickSort(int s, int e) {
		if(s>=e) return;
		
		int pivot = s;
		int end = e;
		s++;
		while(true) {
			//s 포인터와 e포인터가 서로를 넘어가지 않도록
			while(s+1 <= e && arr[s] < arr[pivot]) s++;
			while(e-1 >= s && arr[e] > arr[pivot]) e--;
			
			if(s<e) {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
			}
			
			if(s == e) {
				if(arr[s] > arr[pivot]) {
					int temp = arr[s-1];
					arr[s-1] = arr[pivot];
					arr[pivot] = temp;
					s--;
				}
				else if(arr[s] < arr[pivot]) {
					int temp = arr[s];
					arr[s] = arr[pivot];
					arr[pivot] = temp;
				}
				break;
			}
		}
		
		quickSort(pivot, s-1);
		quickSort(s+1, end);
		
	}

}









