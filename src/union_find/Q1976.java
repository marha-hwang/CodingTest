package union_find;

import java.util.*;
import java.io.*;

public class Q1976 {

	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int city = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int plan = Integer.parseInt(st.nextToken());
		
		arr = new int[city+1];
		for(int i = 1; i<=city; i++) {
			arr[i] = i;
		}
		
		for(int i = 1; i<=city; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j<i; j++) {
				int con = Integer.parseInt(st.nextToken());
				if(con == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(in.readLine());
		int c = find(Integer.parseInt(st.nextToken()));
		boolean result = true;
		
		for(int i = 1; i<plan; i++) {
			if(c != find(Integer.parseInt(st.nextToken()))) {
				result = false;
			}
		}
		
		if(result) System.out.print("YES");
		else System.out.print("NO");

	}
	
	public static void union(int a, int b) {
		int ca = find(a);
		int cb = find(b);
		if(ca != cb) {
			arr[cb] = ca;
		}
	}
	
	public static int find(int n) {
		if(arr[n] == n) {
			return n;
		}
		else {
			int result = find(arr[n]);
			arr[n] = result;
			return result;
		}
	}

}
