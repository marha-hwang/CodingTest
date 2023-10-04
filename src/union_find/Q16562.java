package union_find;

import java.util.*;
import java.io.*;
public class Q16562 {
	static int[] parent,cost;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		//입력받기 n,m,k 학생수, 관계수, 가진 돈
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		//친구비 배열
		cost = new int[n+1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		//union연산수행
		parent = new int[n+1];
		for(int i =1; i<=n; i++) {
			parent[i] = i;
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 1; i<=n; i++) {
				set.add(find(i));
		}
		set.stream().forEach((Integer i) -> {
				result += cost[i];
			});		
		if(result > k) System.out.print("Oh no");
		else System.out.print(result);
		}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(cost[rootA] <= cost[rootB]) {
			parent[rootB] = rootA;
		}
		else parent[rootA] = parent[rootB];
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
}














