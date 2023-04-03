package BrouteForce;
import java.util.*;
import java.io.*;

public class Q18511 {
	static int n;
	static int arr[];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//n저장
		n = Integer.parseInt(st.nextToken());
		//집합저장
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		arr = new int[m];
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//DFS함수 실행
		for(int i=0; i<m; i++) {
			DFS(arr[i]);
		}
		
		System.out.print(result);
	}

	public static void DFS(int sum) {
		//n과 비교하여 n보다 크면 result = sum
		if(sum > n)return;
		else if(result < sum) result = sum;
		
		//재귀함수 실행
		for(int i = 0; i<arr.length; i++) {
			DFS(sum*10+arr[i]);
		}
		
	}
}
