package Q50_59;
import java.util.*;
import java.io.*;

public class Q57 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int city = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int bus = Integer.parseInt(st.nextToken());
		
		//그래프 생성
		ArrayList<Node>[] arr = new ArrayList[city+1];
		for(int i = 1; i<= city; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < bus; i++) {
			st = new StringTokenizer(in.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b,value));
		}
		
		//최소비용 배열 생성
		int[] distance = new int[city+1];
		for(int i =1; i<=city; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		distance[start] = 0;
		
		//탐색을 위한 방문배열, 우선순위큐 생성
		boolean[] visit = new boolean[city+1];
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(start, 0));
		
		//탐색시작
		while(!que.isEmpty()) {
			Node now = que.poll();
			visit[now.node] = true;
			if(visit[end]) break; //목적지까지의 최단거리만 구하면 되므로 목적지가 구해지는 시점에서 반복문 중지
			
			for(Node i : arr[now.node]) {
				if(distance[i.node]>distance[now.node]+ i.value) {
					distance[i.node]= distance[now.node]+i.value;
					que.add(new Node(i.node, distance[i.node]));
				}
				
			}
		}
		
		System.out.print(distance[end]);

	}

}

class Node implements Comparable<Node>{
	int node, value;
	public Node(int node, int value) {
		this.node = node;
		this.value = value;
	}
	
	public int compareTo(Node n) {
		return this.value > n.value ? 1:-1;
	}
}
