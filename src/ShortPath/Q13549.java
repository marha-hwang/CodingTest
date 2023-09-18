package ShortPath;

import java.io.*;
import java.util.*;

public class Q13549 {

static long[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		distance = new long[100000+1];
		Arrays.fill(distance, 1000000);
		
		dijkstra(n);
		
		System.out.print(distance[k]);

	}
	
	static void dijkstra(int n) {
		//큐 생성및 초기화
		PriorityQueue<Node1> que = new PriorityQueue<Node1>();
		que.add(new Node1(n, 0));
		distance[n] = 0;
		
		//큐 빌때 까지 반복
		while(!que.isEmpty()) {
			Node1 now = que.poll();
			int id = now.id;
			long cost = now.cost;
			
			//+,-,* 3가지에 대해 큐에 넣는 작업 반복
			for(int i = 0; i<3; i++ ) {
				Node1 next = null;
				if(i == 0)  next = new Node1(id+1, cost + 1);
				else if(i == 1)  next = new Node1(id-1, cost + 1);
				else next = new Node1(id*2, cost);
				
				if(next.id > 100000 || next.id < 0 || next.cost >= distance[next.id]) continue;
				que.add(next);
				distance[next.id] = next.cost;
					
			}
		
		}
		
	}

}

class Node1 implements Comparable<Node1>{
	int id;
	long cost;
	
	public Node1(int id, long cost) {
		this.id = id;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node1 o) {
		return this.cost > o.cost ? 1:-1;
	}
}

