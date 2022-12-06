package Q80_89;
import java.util.*;
import java.io.*;

public class Q84 {

	public static void main(String[] args) throws Exception{
		/*
		 * 10의 경우 10 - 9 - 3 - 1로 3번의 연산을 통해 1을 만들 수 있다.
		 * */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		//DP배열 생성 N까지
		int[] DP = new int[N+1];
		
		//DP[1]입력
		DP[1] = 0;
		
		//반복문을 이용하여 DP배열 채우기
		for(int i = 2; i<=N; i++) {
			int tmp = Integer.MAX_VALUE;
			//k까지 필요한 연산의 수를 구하기
			if(i % 2 == 0) {		
				tmp = Math.min(tmp, 1+ DP[i/2]);
			}
			
			if(i % 3 == 0) {
				tmp = Math.min(tmp, 1+ DP[i/3]);
			}
			
			if(i-1 >= 1) {
				tmp = Math.min(tmp, 1+ DP[i-1]);
			}
			
			//배열에 최솟값 넣기
			DP[i] = tmp;
		}
		
		//값 출력
		System.out.print(DP[N]);
	}

}
