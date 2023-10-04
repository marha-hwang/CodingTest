package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int rL = arr[0];
		int rR = arr[n-1];
		int rMin = Integer.MAX_VALUE;
		for(int i = 0; i<n-1; i++) {
			int l = i+1;
			int r = n-1;
			while(l+1 < r) {
				int mid = (l+r)/2;
				if(arr[i] + arr[mid] <= 0)  l = mid;
				else if(arr[i] + arr[mid] > 0) r = mid;
			}
			int min = Integer.MAX_VALUE;
			int pick;
			if(Math.abs(arr[i] + arr[l]) <= Math.abs(arr[i] + arr[r])) {
				min = Math.abs(arr[i] + arr[l]);
				pick = l;
			}
			else {
				min = Math.abs(arr[i] + arr[r]);
				pick = r;
			}
			
			if(min < rMin) {
				rMin = min;
				rL = arr[i];
				rR = arr[pick];
			}
		}
		
		System.out.print(rL + " " + rR);

	}

}

