package Q20_29;
import java.util.*;
import java.io.*;

public class Q23 {
	static boolean[] visit;
	static ArrayList<Integer>[] nodeArr;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		visit = new boolean[node+1];
		nodeArr = new ArrayList[node+1];	
		
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(in.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			if(nodeArr[a] == null){//arraylist가 생성되지 않았으면
				nodeArr[a] = new ArrayList<Integer>();
			}
			if(nodeArr[b] == null ) {
				nodeArr[b] = new ArrayList<Integer>();
			}
			nodeArr[a].add(b);
			nodeArr[b].add(a);
			
		}
		
		int count = 0;
		for(int i = 1; i<= node; i++) {
			if(visit[i] == false) {
				count ++;
				DFS(i);
			}
		}
		
		System.out.println(count);
		
		
		
	}
	
	public static void DFS(int i) {
		if(visit[i]) {
			return;
		}
		visit[i] = true;
		for(int j: nodeArr[i]) {
			if(visit[j] == false){
				DFS(j);
			}
		}
	}
				
}
















