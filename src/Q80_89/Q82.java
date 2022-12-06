package Q80_89;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Q82 {

	public static void main(String[] args) throws Exception{
		//n개의 'a'와 m개의 'z'로만 이루어진 문자열 여러개를 사전식으로 나열
		//n과 m이 주어질때 k번째 문자열 구하기
		
		//자유생각 
		/*뭔가 조합으로 풀어야 할 듯
		 * 규칙을 찾아내야 할 듯
		 * 점화식 az[n][m] = az[n-1][m] + az[n][m-1] - 문자열의 개수를 구하는 것 까지는 가능
		 * 문자열을 첫째자리부터 채워나가기
		 * 배열 az[n][m-1] 과 az[n-1][m] 중 어디로 이동할 것인지 결정
		 * 왜? 이동하는 방향으로 a,z중에서 문자 하나가 줄어듬, 줄어든다는 것은 현재자리에 줄어든 문자가 온다는 것을 의미
		 * 이동하는 방법은? k와 az[n-1][m]을 비교하여 k가 더 큰 경우에는 오른쪽으로 이동후 현재 문자에 z추가
		 * 오른쪽으로 이동하는 경우에는 k = k-az[n-1][m]으로 값 수정하기
		 * 종료조건 - k가 1인 경우, az[0][0]이 되도록 하는 문자를 추가
		 */
		
		// 오답원인 - a,z각 100개씩 입력시 가능한 문자열의 수가 long범위를 초과함
		// 해결 - k의 최대값은 10억이고, k보다 az배열의 값이 크면 k를 수정하지 않기 때문에 long자료형을 넘으면 배열의 값을 Long.MaxValue로 설정 
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		//배열 초기화 - 배열에는 a,z의 각 개수마다 몇개의 문자열이 존재하는지
		long[][] az = new long[N+1][M+1];
		for(int i = 0; i<=N; i++) {
			az[i][0] = 1;
		}
		for(int i = 0; i<=M; i++) {
			az[0][i] = 1;
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				//long자료형 overflow에 대비
				if(az[i-1][j] + az[i][j-1] < 0) az[i][j] = Long.MAX_VALUE;
				else az[i][j] = az[i-1][j] + az[i][j-1];
			}
		}
		
		//사전의 문자열 개수보다 많으면 바로 종료
		if(az[N][M] < K) {
			System.out.print(-1);
			return;
		}
		
		//배열을 통해 문자열의 첫째 자리부터 정하기	
		int z = 0;
		int a = 0;
		while(M != 0 && N != 0) {
			//문자열 하나 정하기
			if(K > az[N-1][M] && az[N-1][M] > 0) {
				//정답배열에 추가
				System.out.print("z");
				z++;
				//M,K값 수정
				K -= az[N-1][M];
				M -= 1;
				
			}else if( K <= az[N-1][M]) {
				//정답배열에 추가
				System.out.print("a");
				a++;
				//N값 수정
				N -= 1;
			}
		}
		
		//연속으로 나오는 a또는 z처리하기
		if(a != az.length-1) {
			for(int i = 0; i < az.length-1 - a; i++) { 
					System.out.print("a");
			}
		}else if(z != az[0].length -1) {
			for(int i = 0; i < az[0].length -1 -z; i++) { 
				System.out.print("z");
			}
		}
		
	}

}










