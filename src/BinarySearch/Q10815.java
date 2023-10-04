package BinarySearch;

import java.util.*;
import java.io.*;

public class Q10815 {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<m; i++) {
			int now = Integer.parseInt(st.nextToken());
			boolean result = binarySearch(now);
			
			if(result) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}

	}

	static boolean binarySearch(int now) {
		boolean result = false;
		
		int l = 0;
		int r = n-1;
		while(l+1 < r) {
			int mid = (l+r)/2;
			if(arr[mid] > now) r = mid;
			else if(arr[mid] < now) l = mid;
			else {
				result = true;
				break;
			}
		}
		
		if(arr[l] == now || arr[r] == now) result = true;
		
		return result;
		
	}
}

