package Implementation;

import java.util.*;
import java.io.*;
public class Q1244 {
	static int[]arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new int[n+2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		arr[0] = -1;
		arr[n+1] = -2;
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(in.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) man(num);
			else woman(num);
		}
		
		for(int i = 1; i<=n; i++) {
			System.out.print(arr[i] + " ");
			if(i%20 == 0) System.out.println();
		}
		
	}

	static void man(int num) {
		int now  = num;
		while(now <= n) {
			arr[now] = arr[now] == 1 ? 0:1;
			now+=num;
		}
	}
	
	static void woman(int num) {
		int l = num;
		int r = num;
		while(arr[l-1] == arr[r+1]) {
			l--;
			r++;
		}
		for(int i=l; i<=r; i++) {
			arr[i] = arr[i] == 1 ? 0:1;
		}
	}
}














