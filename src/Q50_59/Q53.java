package Q50_59;
import java.util.*;
import java.io.*;

public class Q53 {

	static ArrayList<Integer>[] arr;
	static int[] enter;
	static Queue<Integer> que = new LinkedList<Integer>();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[node+1];		
		for(int i = 1; i<=node; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
		}
		
		enter = new int[node+1];
		for(int i = 1; i<=node; i++) {
			for(int j = 0; j<arr[i].size(); j++) {
				enter[arr[i].get(j)] ++;
			}
		}
		
		for(int i = 1; i<=node; i++) {
			if(enter[i] == 0) {
				que.add(i);
			}
		}
		
		
		//일반 위상정렬을 통한 탐색
		while(!que.isEmpty()) {
			int now = que.poll();
			System.out.print(now +" ");
			for(int next : arr[now]) {
				enter[next] --;
				if(enter[next] == 0) {
					que.add(next);
				}
			}
		}
		
	}
}
