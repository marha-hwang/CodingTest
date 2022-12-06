package Q10_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Regression {
		public static void main(String[] args) throws Exception {
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
				System.out.print(arr[i]+" ");
			}
		}


	public static void quickSort(int[] arr, int s, int e) {
		if(s<e) {
			if(s+1 == e) {
				if(arr[s] > arr[e]) {
					int tmp = arr[s];
					arr[s] = arr[e];
					arr[e] = tmp;
					return;
				}
			}
			int pivot = arr[s];
			int index1 = s+1;
			int index2 = e;
			while(index1<index2) {
				while(arr[index1]<pivot) {
					index1++;
				}
				while(arr[index2]>pivot) {
					index2--;
				}
				if(index1<index2) {
					int tmp = arr[index1];
					arr[index1] = arr[index2];
					arr[index2] = tmp;
					index1++; index2--;
				}
				
			}
			int tmp = arr[index1-1];
			arr[index1-1] = arr[s];
			arr[s] = tmp;
			
			quickSort(arr, s, index1-2);
			quickSort(arr, index1, e);
		}
	}
}

