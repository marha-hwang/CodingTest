package BinarySearch;

import java.util.*;
import java.io.*;
public class Q2512 {
	static int[] arr;
	static int n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(in.readLine());
		
		int sum = 0;
		int max = 0;
		
		//상한선이 필요한지 확인
		for(int i = 0; i<n; i++) {
			sum += arr[i];
			if(arr[i] > max) max = arr[i];
		}
		
		if(sum <= m) {
			System.out.print(max);
			return;
		}
		
		//상한선이 필요 한경우 1~100000까지 이분 탐색으로 상한선 찾기
		int l = 1;
		int r = 100000;
		while(l+1 < r) {
			int mid = (l+r)/2;
			if(check(mid) == true) l = mid;
			else r = mid;
		}
		
		if(check(r)) System.out.print(r);
		else System.out.print(l);
	}
	
	static boolean check(int mid) {
		boolean result = false;
		
		int sum = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i] > mid) sum += mid;
			else sum += arr[i];
		}
		
		if(sum <= m) result = true; 
		
		return result;
	}
}








