package Q20_29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sort(arr, 0, n-1);
		
		for(int i= 0; i<n; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void sort(int[] arr, int s, int e) {
		if(e-s>=1) {
			int m= s+(e-s)/2;
			sort(arr, s, m);
			sort(arr,m+1, e);
			
			int point1 = s;
			int point2 = m+1;
			int[] tmp = new int[e+1];
			int index = 0;
			while(point1 <= m && point2 <= e) {
				if(arr[point1]>arr[point2]) {
					tmp[index] = arr[point2];
					index++; point2 ++;
				}else {
					tmp[index] = arr[point1];
					index++; point2++;
				}
			}
			if(point1<=m) {
				while(point1 <= m) {
					tmp[index] = arr[point1];
					index++; point1++;
				}
			}
			if(point2<=e) {
				while(point2 <= e) {
				tmp[index] = arr[point2];
				index++; point2++;
				}
			}
			int j = 0;
			for(int i = s; i<=e; i++) {
				arr[i] = tmp[j];
				j++;
			}
		}
	}

}
