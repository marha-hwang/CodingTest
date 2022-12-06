package Q20_29;
import java.util.*;
import java.io.*;

public class Q25 {
	
	static ArrayList<Integer>[] arr;
	static boolean[] visit ;
	static boolean flag = false;
	 
	public static void main(String[] args) throws Exception{
		
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int people = Integer.parseInt(st.nextToken());
		int relation = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[people];
		visit = new boolean[people];
		
		for(int i=0; i<people; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<relation; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i=0; i<people; i++) {
			if(visit[i] == false) {
				DFS(i, 1);
			}
			if(flag) {
				break;
			}
		}
		
		if(flag) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
	
	public static void DFS(int n, int depth) {
		if(depth == 5 || flag) {
			flag = true;
			return; 
		}
		
		if(visit[n]) {
			return;
		}
		visit[n] = true;
		for(int i: arr[n]) {
			if(visit[i] == false) {
				DFS(i, depth+1);
			}
		}
	}
}
