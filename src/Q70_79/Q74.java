package Q70_79;
import java.util.*;
import java.io.*;
public class Q74 {

	static ArrayList<Integer>[] arr;
	static int[] pnode;
	static int[] depth;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		//그래프 생성
		arr = new ArrayList[N + 1];
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
		
		//부모노드와 깊이를 저장할 배열 초기화하기
		pnode = new int[N+1];
		depth = new int[N+1];
		
		//BFS탐색을 수행하여 배열 수정
		visit = new boolean[N+1];
		BFS(1);
		
		//최소공통조상찾기
		int q = Integer.parseInt(in.readLine());
		for(int i = 0; i< q; i++) {
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
			for(int i: arr[now]) {
				if(!visit[i]) {
					que.add(i);
					visit[i] = true;
					pnode[i] = now;
					depth[i] = depth[now] + 1;
				}
			}
		}
		
	}
	
	public static int LCA(int a, int b) {
		//두 노드의 깊이 맟추기
		while(depth[a] != depth[b]) {
			if(depth[a] > depth[b]) {
				a = pnode[a];
			}else {
				b = pnode[b];
			}
		}
		
		//두 노드의 공통 조상 구하기
			//깊이를 1칸씩 감소시켜 가면서 부모노드를 비교하는 것을 반복
		while(a != b) {
			a = pnode[a];
			b = pnode[b];
		}
		
		return a;
		
	}
	
}








