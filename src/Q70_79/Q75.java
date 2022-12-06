package Q70_79;
import java.util.*;
import java.io.*;

public class Q75 {

	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int[][] pnode;
	static int[] depth;
	static int k;
	
	public static void main(String[] args) throws Exception{
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		//그래프 생성
		arr = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		//k의 값 구하기, 2의k제곱은 노드개수 보다 작아야함
		k = 0;
		int muti = 1;
		while(muti < N) {
			muti *=2;
			if(muti < N) k++;
		}
		
		//DFS알고리즘 수행하여 depth,pnode배열 초기화
		depth = new int[N+1];
		pnode = new int[k+1][N+1];
		visit = new boolean[N+1];
		BFS(1);
		
		//구한 k값을 이용하여 배열 채워넣기
		//점화식 이용 pnode[k][n] = pnode[k-1][pnode[k-1][n]]
		for(int i = 1; i<=k; i++) {		
			for(int j = 1; j<= N; j++) {
					pnode[i][j] = pnode[i-1][pnode[i-1][j]];
			}
		}
		
		
		//주어진 질의 만큼 반복하여 공통노드 구하기
		int q = Integer.parseInt(in.readLine());
		for(int i = 0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(LCA(a, b));
		}

	}
	
	public static void BFS(int n) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(n);
		visit[n] = true;
		depth[n] = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : arr[now]) {
				if(!visit[i]) {
					que.add(i);
					visit[i] = true;
					depth[i] = depth[now] + 1;
					pnode[0][i] = now;
				}
			}
		}		
	}
	
	public static int LCA(int a, int b) {
		
		//a와 b중 무엇이 더 깊은지에 따라 코드를 중복 작성하는 것을 피하기 위한 코드
		if(depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
	
		//만약 깊이차이가 3이라면 2번 움직이고 1번을 더 움직인다.
		//깊이차이 구하기
		int d = depth[a] - depth[b];
		//만약 남은 깊이차이가 2이상이라면 2의 k제곱만큼 더 움직이기
		while(depth[a] != depth[b]) {
			//2의 k제곱만큼 움직이기 위한 k구하기
			int k = 0;
			int tmp = 1;
			while(tmp <= d) {
				tmp *= 2;
				if(tmp<=d) k++;
			}
			a = pnode[k][a];
			d = depth[a] - depth[b];
		}
		
		//두 노드의 공통부모를 찾음
		//k의 최댓값부터 시작하여 부모노드 찾기
		for(int i = k; i>=0; i--) {
			if(pnode[i][a] != pnode[i][b]) {
				a = pnode[i][a];
				b = pnode[i][b];
			}
		}
		
		int LCA = a;
		//만약 부모노드까지 4번의 이동을 하는 경우
		//k=2일때 4만큼 이동하여 현재노드가 바뀌지 않음 k=1만큼이동하여 현재노드 2만큼이동
		//k=0만큼 이동하여 현재노드 1만큼이동, 총 3번의 이동만 했기 때문에 a와 b는 일치하지 않음
		//따라서 아래와 같은 조건에 따라 이동해야함
		if(a != b) {
			LCA = pnode[0][LCA];
		}
		
		
		return LCA;
	}
}







