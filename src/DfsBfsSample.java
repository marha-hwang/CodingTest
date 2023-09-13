import java.util.*;
import java.io.*;

public class DfsBfsSample {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws IOException {
		//ArrayList로 입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int edgeCnt = Integer.parseInt(in.readLine());
		
		arr = new ArrayList[n+1];
		for(int i = 0; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<edgeCnt; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		visit = new boolean[n+1];
		System.out.println(BFS(1));
		Arrays.fill(visit, false);
		
		result = -1;
		DFS(1);
		System.out.println(result);
		
	}
	
	public static int BFS(int start) {
		int result = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		visit[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i = 0; i< arr[now].size(); i ++) {
				int next = arr[now].get(i);
				
				if(visit[next] == false) {
					que.add(next);
					result += 1;
					visit[next] = true;
				}
			}
		}
		
		return result;
	}
	
	public static void DFS(int start) {
		//미래 상황에 대한 종료조건
		if(visit[start]) return;
		
		visit[start] = true;
		result += 1;
		
		for(int i = 0; i< arr[start].size(); i++) {
			int next = arr[start].get(i);
			
			//현재 상황에 대한 종료조건
			if(visit[next]) continue;	
			
			DFS(next);
		}
	}

}
