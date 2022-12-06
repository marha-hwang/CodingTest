package Q60_69;
import java.util.*;
import java.io.*;

public class Q68 {

	static ArrayList<Integer>[] arr;
	static int result = 0;
	static int delete;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		arr = new ArrayList[node];
		for(int i = 0; i<node; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		int p = 0;
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<node; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n == -1) p = i;
			else if(n != -1)arr[n].add(i);
		}
		
		delete = Integer.parseInt(in.readLine());

		DFS(p);
		
		System.out.print(result);
	}
	
	public static void DFS(int p) {
		int leaf = 0;
		
		for(int i: arr[p]) {
			if(i != delete) {
				DFS(i);
				leaf++;
			}
		}
		
		if(leaf == 0) {
			result ++;
		}
		
		
		//형제노드가 없으면 result 증가로직 추가
//		if(p == delete && brother == 1) {
//			result ++;
//			return;
//		}
//		else if(p == delete ) {
//			return;
//		} else if(arr[p].size() == 0){
//			result ++;
//			return;
//		} else {
//			for(int i: arr[p]) {
//				DFS(i, arr[p].size());
//			}
//		}
		
	}

}
