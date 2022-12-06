package Q40_49;
import java.util.*;
import java.io.*;

public class Q46 {
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int[] distance;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		visit = new boolean[n+1];
		distance = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		
		//BFS구현코드, 최단거리를 찾는 문제는 BFS탐색이 접합하다.
		BFS(x);	
		for(int i = 1; i<=n; i++) {
			if(distance[i] == k) {
				System.out.println(i);
			}
		}	
	}	
	
	public static void BFS(int x) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(x);
		visit[x] = true;
		distance[x] = 0;
		int ndistance = 1;
		while(!que.isEmpty()) {
			int nowNode = que.poll();
			for(int i:graph[nowNode]) {
				if(visit[i] == false) {
					que.add(i);
					visit[i] = true;
					distance[i] = ndistance;
				}
			}
			ndistance ++;
		}
	}
}		
		//DFS를 구현코드, 해당 문제는 트리가 아니기 때문에 최단거리 탐색에 적합한 방법이 아니다.
//		DFS(x, 0);
//		for(int i=1; i<=n; i++) {
//				System.out.println(i);
//			}
//		
//	}
//	
//	public static void DFS(int x, int ndistance) {
//		if(visit[x]) {
//			return;
//		}
//		distance[x] = ndistance;
//		visit[x] = true;
//		for(int i:graph[x]) {
//			if(!visit[i]) {  
//				DFS(i, ndistance+1);
//			}
//		}
//	}

