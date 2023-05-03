package BrouteForce;
import java.util.*;
import java.io.*;
public class Q17626 {
	static int n;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//주어진 수 n을 만들기 위해 n이 넘지 않는 제곱수를 만든다
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		DFS(0, 0);
		System.out.print(result);
	}
	
	public static void DFS(int depth, int now) {
		int sqrt = (int)Math.sqrt(n-now);
		//종료조건
		if(now >= n || depth == 4) {
			if(now == n) {
				result = Math.min(depth, result);
			}
			else return;
		}
		
		//재귀조건
		for(int i=1; i<=sqrt; i++) {
			if(depth+1 < result) DFS(depth+1, now + i*i);
		}
	}
	
}
