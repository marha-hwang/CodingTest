package Q90_Q100;
import java.util.*;
import java.io.*;
public class Q93 {

	public static void main(String[] args) throws Exception{
		//점화식 D[N][L][R] - N번째 순열에서 왼발이 L 오른발이 R 위치에 있을 때 최솟값
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		/* 
		 * 점화식 D[N][L][R]의 정의 - N번째 수를 밟았고 발의 위치가 L,R일 때 경우들어가는 힘의 최솟값
		 * 그럼 D[N-1]까지의 배열이 모두 채워져있다고 가정하고 D[N]배열을 모두 채운다면
		 * 
		 * 
		 */
		
		//각 위치에서 이동하기 위한 힘
		int[][] move = {{0,2,2,2,2},{2,1,3,4,3},{2,3,1,3,4},{2,4,3,1,3},{2,3,4,3,1}};
		
		//배열 초기화
		int[][][] D = new int[100001][5][5];
		for(int[][] a: D) {
			for(int[] b: a) {
				Arrays.fill(b, 40000000);
			}
		}
		D[0][0][0] = 0;
		
		//배열 채우기
		int su = Integer.parseInt(st.nextToken());
		int n = 1;
		while(su != 0) {
				//현재 발판을 누를 때, n번째 su를누름
				for(int i = 0; i<=4; i++) {
					for(int j = 0; j<=4; j++) {
						if(su == j) continue;
						//왼발을 옮김
						D[n][su][j] = Math.min(D[n-1][i][j] + move[i][su], D[n][su][j]);
						}
				}
				for(int i = 0; i<=4; i++) {
					for(int j = 0; j<=4; j++) {
						if(su == i) continue;
						//오른발을 옮김
						D[n][i][su] = Math.min(D[n-1][i][j] + move[j][su], D[n][i][su]);
						}
				}
				su = Integer.parseInt(st.nextToken());
				n++;
		}
		
		int result = 40000000;
		for(int i = 0; i<=4; i++) {
			for(int j = 0; j<=4; j++) {
				result = Math.min(D[n-1][i][j], result);
			}
		}
		
		System.out.print(result);
	}

}





