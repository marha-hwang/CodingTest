package Q50_59;
import java.util.*;
import java.io.*;

public class Q56 {

	static ArrayList<Data>[] arr;
	static boolean[] visit; //최단거리임이 확정된 노드
	static int[] minarr;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		visit = new boolean[node +1];
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		//거리배열 초기화
		minarr = new int[node+1];
		for(int i = 0; i<=node; i++) {
			minarr[i] = Integer.MAX_VALUE;
		}
		minarr[start] = 0;
		
		//그래프 구현
		arr = new ArrayList[node+1];
		for(int i = 1; i<=node; i++) {
			arr[i] = new ArrayList<Data>();
		}
		
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Data(b, value));
		}
		
		//최소거리가 가장작은 노드를 선택
		PriorityQueue<Data> que = new PriorityQueue<Data>();
		que.add(new Data(start, minarr[start]));
		
		//선택된 노드와 연결된 노드를 탐색
		while(!que.isEmpty()) {
			Data now = que.poll();
			if(visit[now.node]) continue;
			visit[now.node] = true;
			for(Data i: arr[now.node]) {
				if(minarr[now.node]+ i.value< minarr[i.node]) {
					minarr[i.node]= minarr[now.node] + i.value;
					que.add(new Data(i.node,minarr[i.node]));
				}
			}
		}
		
		for(int i =1; i<=node; i++) {
			if(visit[i]) {
				System.out.println(minarr[i]);
			}else System.out.println("INF");
		}
	}
	
}

class Data implements Comparable<Data>{
	int node, value;
	
	public Data(int node, int value) {
		this.node = node;
		this.value = value;
	}
	
	public int compareTo(Data e) {
		return this.value > e.value ? 1:-1;
	}
}

















