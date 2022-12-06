package Q20_29;
import java.util.*;
import java.io.*;


public class Q20 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(arr, 0, n-1);
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void sort(int[] arr, int s, int e) {
		if(e-s<1) {
			return;
		}
		int m= s+(e-s)/2;
		int[] tmp = new int[e+1];
		sort(arr,s,m);
		sort(arr,m+1,e);
		for(int i= s; i<=e; i++) {
			tmp[i] = arr[i];
		}
		int index1 = s;
		int index2 = m+1;
		int k = s;
		while(index1<=m &&index2<=e) {
			if(tmp[index1] >tmp[index2]) {
				arr[k] = tmp[index2];
				k++;
				index2++;
			}else {
				arr[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1<=m) {
			arr[k] = tmp[index1];
			k++;
			index1++;
		}
		while(index2<=e) {
			arr[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
