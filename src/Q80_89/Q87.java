package Q80_89;
import java.util.*;
import java.io.*;

public class Q87 {
		//문제 - 1. 가로 2 세로 5 크기의 직사각형을 (1,2) (2,1) 타일로 채우는 경우의 수 
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] D = new int[N+1];
		
		D[0] = 1;
		D[1] = 1;
		
		for(int i = 2; i<=N; i++) {
			D[i] = D[i-2]%10007 + D[i-1]%10007;
		}
		
		System.out.print(D[N]%10007);
	}

}
