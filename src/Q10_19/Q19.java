package Q10_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr, 0, n-1);
		for(int i= 0; i <n; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static void quickSort(int[] arr, int S, int E) {
		if(S<E) {
			int pivot = partition(arr, S, E);
			quickSort(arr, S, pivot -1);
			quickSort(arr, pivot+1, E);
			}
		}
	
	public static int partition(int[] arr, int S, int E) {
		if(S+1==E) {
			if(arr[S]>arr[E]) swap(arr,S,E);
			return E;
		}
		int pivot = arr[S];
		int i = S+1, j=E;
		while(i<=j) {
			while(pivot<arr[j] && j>0) {
				j--;
			}
			while(pivot>arr[i] && i<arr.length-1) {
				i++;
			}
			if(i<=j) {
				swap(arr, i++, j--);
			}
		}
		arr[S] = arr[j];
		arr[j] = pivot;
		return j;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
		
		
//		for(int i = n-1; i>0; i--) {
//			int pivot = arr[i];
//			int start = 0;
//			int end = i-1;
//			while(start !=end) {
//				boolean s=false;
//				boolean e=false;
//				
//				if(pivot>arr[start]) {
//					start ++;
//					s=true;
//				}
//				if(pivot<arr[end]) {
//					end --;
//					e =true;
//				}
//				if(s==false && e==false) {
//					int value = arr[end];
//					arr[end] = arr[start];
//					arr[start] = value;
//					start++;
//					end--;
//				}
//				
//			}
//			if(arr[start] > pivot) {
//				int value = pivot;
//				for(int j = i; j>start; j--) {
//					arr[j] = arr[j-1];
//				}
//				arr[start] = pivot;
//			}else {
//				int value = pivot;
//				for(int j = i; j>start+1; j--) {
//					arr[j] = arr[j-1];
//				}
//				arr[start+1] = pivot;
//			}
//		}
