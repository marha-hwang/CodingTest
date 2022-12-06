package Q70_79;
import java.util.*;
import java.io.*;
public class Q76 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//N제곱의 이항정리에서 K제곱인 항의 계수를 찾기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		//모든 조합의 경우를 저장할 배열 만들기
		int [][] D = new int[N+1][K+1];
		
		//배열 채워넣기 선택개수가 0인 경우만 미리 채워넣음
		for(int i = 0; i<=N; i++) {
			D[i][0] = 1;
		}
		
		//점화식을 이용하여 배열 모두 채우기
		for(int i = 1; i<=K; i++) {
			for(int j = i; j<=N; j++) {
				D[j][i] = (D[j-1][i] + D[j-1][i-1]);
			}
		}
		
		//D[N][K] 의 값을 출력
		System.out.print(D[N][K]);
	}

}
