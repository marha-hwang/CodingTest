package Q80_89;
import java.util.*;
import java.io.*;

public class Q86 {

	public static void main(String[] args) throws Exception{
		// 문제 - 1. 이진수 N자리에서 이친수의 개수 구하기
		//	 	2. 첫째자리가 0이아니고 1이 연속으로 나오지 않는 이진수 개수 구하기
		// 점화식 - N번째 자리에 0이 온다면 N-1 자리에 0과1모두 올 수있다. N번째 자리에 1이 온다면 N-1번째 자리에는 0만 올 수있다.
		// 위의 점화식을 구하기 위해서는 N번째자리에 0과 1이 각각 몇개 오는지 알아야 하기 때문에 D[N][0], D[N][1]과 같이 표현한다.
		// N자리의 이친수 개수 = ( D[N][0] = D[N][0] + D[N][1] ) + (( D[N][1] = D[N][0] )
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		long[][] D = new long[N+1][2];
	
		if(N>0)D[1][1] = 1;
		for(int i = 2; i<=N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		System.out.print(D[N][0] + D[N][1]);
	}

}
