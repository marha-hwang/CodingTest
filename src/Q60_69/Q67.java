package Q60_69;
import java.util.*;
import java.io.*;

public class Q67 {

	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int[] pnode;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i = 1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		visit = new boolean[n+1];
		pnode = new int[n+1];
		
		//BFS(1);
		DFS(1);
		
		for(int i = 2; i<=n; i++) {
			System.out.println(pnode[i]);
		}
		

	}
	
	public static void BFS(int s) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);
		visit[s] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i: arr[now]) {
				if(!visit[i]) {
					que.add(i);
					visit[i] = true;
					pnode[i] = now;
				}
			}
		}
	}
	
	public static void DFS(int s){
		if(visit[s]) {
			return;
		}else {
			visit[s] = true;
			for(int i: arr[s]) {
				//if(!visit[i]) {
					DFS(i);
					pnode[i] = s;
				//}
			}
		}
	}

}









