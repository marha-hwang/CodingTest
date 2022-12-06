package Q20_29;

import java.io.*;
import java.util.*;


public class Q26 {
	
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[node+1];
		queue = new LinkedList<Integer>();
		visit = new boolean[node + 1];
		
		for(int i=1; i<=node; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(in.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=1; i<=node; i++) { // 작은 노드부터 탐색을 하기 위해서 오름차순으로 각 ArrayList를 정렬
			Collections.sort(arr[i]);
		}
		
		DFS(start);
		for(int i=1; i<=node; i++) {
			if(visit[i]==false) {
				DFS(i);
			}
		}
		
		visit = new boolean[node+1];
		System.out.println();
		
		BFS(start);
		for(int i=1; i<=node; i++) {
			if(visit[i]==false) {
				BFS(i);
			}
		}
	}
	
	public static void DFS(int i) {
		if(visit[i]) {
			return;
		}
		visit[i] = true;
		System.out.print(i +" ");
		
		for(int j: arr[i]) {
			if(visit[j] == false) {
				DFS(j);
			}
		}
	}
	
	public static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visit[i] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n + " ");
			for(int j: arr[n]) {
				if(visit[j] == false) {
					queue.add(j);
					visit[j] = true; //j번노드와의 edge가 여러개 존재하면 j번노드가 poll()될 때까지 j가 여러번 
									 // 큐에 삽입될 수 있기 때문에 큐에 추가됨과 동시에 바로 방문배열에 저장을 해야한다.
				}
			}
		}
	}
}











