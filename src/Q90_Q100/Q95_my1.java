package Q90_Q100;
import java.util.*;
import java.io.*;
public class Q95_my1 {

	
		static int [][] W;
		static int[][] D;
		static int start;
		static int N;
		
		public static void main(String[] args) throws Exception{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			W = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 1; j<=N; j++) {
					int d = Integer.parseInt(st.nextToken());
					if(d != 0)W[i][j] = d;
					else W[i][j] = 100000000;
				}
			}
			//메모제이션 사용
			D = new int[N+1][1<<N+1];
			
			System.out.print(DFS(1, 1));
			
		}
		
		public static int DFS(int c, int v) {
			//방문한 도시 저장
			v |= 1<<c;
			
			//종료조건 - 모든 도시를 방문했을 때
			if((1<<N+1)-1 == v) {
				//마지막 도시에서 시작도시까지 거리를 return
				return D[c][v] = W[c][start];
			}
			
			int min = 1000000000;
			//재귀조건 - 방문하지 않은 도시가 존재할 경우 모든 도시 재귀
			for(int i = 1; i<=N; i++) {
				//방문하지 않은 도시이고, 도로가 존재하는 경우 재귀 실행
				int now = 1<<i & v;
				if(now < 1 && W[c][i] != 100000000) {
					if(D[i][v] == 0) min = Math.min(DFS(i, v) + W[c][i] ,min);
					else min = Math.min(D[i][v] + W[c][i] ,min);
				}
			}
			//리턴 값
			D[c][v] = min;
			return D[c][v];
		
		

	}

}
