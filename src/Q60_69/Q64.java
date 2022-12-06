package Q60_69;
import java.io.*;
import java.util.*;
public class Q64 {

	// 탐색할 엣지의 개수는 (노드개수-1) 만큼이다
	static int[] pnode;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int con = Integer.parseInt(st.nextToken());
		
		Edge[] arr = new Edge[con];
		pnode = new int[node+1];
		for(int i = 1; i<=node; i++) {
			pnode[i] = i;
		}
		
		for(int i = 0; i<con; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[i] = new Edge(a,b,value);
		}
		
		Arrays.sort(arr);
		
		int count = 0; //사용한 엣지의 수
		int sum = 0; // 사용한 엣지의 가중치합
		for(int i = 0; i<con; i++) {
			if(count == node-1) break;
			if(find(arr[i].a) != find(arr[i].b)) {
				union(arr[i].a,arr[i].b);
				count +=1;
				sum += arr[i].value;
			}
		}
		
		System.out.print(sum);

	}
	
	public static int find(int a) {
		if(pnode[a] == a) {
			return a;
		}else {
			int result = find(pnode[a]);
			pnode[a] = result;
			return result;
		}
	}
	
	public static void union(int a, int b) {
		pnode[find(b)] = pnode[find(a)];  
	}

}

class Edge implements Comparable<Edge>{
	int a, b, value;
	public Edge(int a, int b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}
	
	public int compareTo(Edge o) {
		return this.value > o.value ? 1:-1;
	}
}
