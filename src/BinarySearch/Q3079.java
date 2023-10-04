package BinarySearch;

import java.util.*;
import java.io.*;

public class Q3079 {
	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken()); //심사대
		m = Integer.parseInt(st.nextToken()); //학생

		arr= new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		long l = 1;
		long r = Long.MAX_VALUE-1;
		while(l+1<r) {
			long mid = (l+r)/2;
			if(check(mid)) r = mid;
			else l = mid;
		}
		
		if(check(l)) System.out.print(l);
		else System.out.print(r);
	}
	
	static boolean check(long mid) {
		boolean result = false;
		long count = 0;
		for(int i = 0; i<n; i++) {
			count += mid/arr[i];
			if(count >= m) break;
		}
		if(count >= m) result = true;
		
		return result;
	}

}

