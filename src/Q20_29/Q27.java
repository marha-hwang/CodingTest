package Q20_29;
import java.util.*;
import java.io.*;

public class Q27 {

	static int[][] arr;
	static int n,m;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1][m+1]; //좌표연산을 상상하기 쉽도록 1,1부터 구현	
		arr = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			String line = st.nextToken();
			for(int j = 1; j<=m; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j-1,j)); // 문자열안에서 주어진 범위에 해당하는 문자를 추출하기 위해
																	 // substring 사용
			}
		}
		
		BFS(1,1);
		System.out.println(arr[n][m]);
	}
	
	public static void BFS(int a, int b) {
			Queue<int[]> queue = new LinkedList<int[]>(); // 큐안에 배열을 사용가능
			int[][] base = {{-1,0}, {0,-1}, {1,0}, {0,1}};// 현재 좌표의 상하좌우를 확인하기 위한 배열
			
			int[] point = {a,b};
			queue.add(point);
			visit[a][b] = true;
			
			while(!queue.isEmpty()) {
				
				point = queue.poll();

				for(int i=0; i<4; i++) {					
					int x = point[0] + base[i][0];  //상하좌우에 해당하는 좌표를 구성
					int y = point[1] + base[i][1];
					
					if(x>0 && y>0 && x<=n &&y<=m) { //좌표가 인덱스를 초과하지 않도록 조건입력
						if( visit[x][y] == false && arr[x][y] == 1) {
							queue.add(new int[] {x,y});
							visit[x][y] = true;
							arr[x][y] = arr[point[0]][point[1]] + 1; //깊이를 표시
						}
					}				
					 
					if(x== n&& y==m) { return; }					 
				}
			}
		}
		
	}














