package ShortPath;

import java.util.*;
import java.io.*;

public class DijkstraSample {
	static ArrayList<Integer>[] arr;
	static int[] distance;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		//입력받기  도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n, m, k, x;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i=0; i<= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[s].add(e);
		}
		
		
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visit = new boolean[n+1];
		dijkstra(x);
		
		boolean flag = false;
		for(int i = 1; i<=n; i++) {
			if(distance[i] == k) {
				System.out.println(i);
				flag = true;
			}
		}
		if(flag == false) System.out.println(-1);

}
	
	//다익스트라 함수
	public static void dijkstra(int start) {
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!que.isEmpty()){
			Node now = que.poll();
			int node = now.node;
			int dist = now.distance;
			
			if(visit[node]) continue;
			
			visit[node] = true;
			
			for(int i = 0; i<arr[node].size(); i++) {
				int next = arr[node].get(i);
				if(distance[next]<=dist+1 ) continue;
				que.add(new Node(next, dist+1));
				
				distance[next] = dist+1;
			}
		}
		
		
	}

}

class Node implements Comparable<Node>{
	int node;
	int distance;
	
	public Node(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		return this.distance > o.distance ? 1:-1;
	}
}

