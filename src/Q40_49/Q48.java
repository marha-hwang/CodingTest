package Q40_49;
import java.util.*;
import java.io.*;

public class Q48 {

	// 문제의 핵심 - 주어진 그래프가 이분 그래프인지 확인
	// 이분그래프가 뭘까? 인접한 노드가 같은집합이 되지 않도록 하는 그래프
	// 노드의 집합은 어떻게 만들까? 탐색이 진행될때마다 0,1을 번갈아 가며 부여한다.
	// 1,2를 저장하기 위해서는? 배열을 추가로 만들어 저장한다.
	// 이분그래프가 되기 위한 조건은? 노드의 관계에서 사이클이 생기지 않도록 한다.
	// 아래 질문에서 답이 잘 생각이 나지 않으면 간단한 샘플을 만들어서 확인하기
	// 사이클이 생기는지 확인하는 방법은? 연결된 노드를 확인할때 자신과 동일한 집합에 속한 노드가 존재하면 사이클이 발생한다.
	
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int[] check;
	static boolean IsEven;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int k=0; k<n; k++) {
			st = new StringTokenizer(in.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[node+1];
			visit = new boolean[node+1];
			
			for(int i=1; i<=node; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<edge; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a].add(b);
				arr[b].add(a);
			}
			check = new int[node+1];
			IsEven = true;
			
			for(int i = 1; i<=node; i++) {
				if(!visit[i]) {
					DFS(i);
				}
			}
			if(IsEven ) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	public static void DFS(int n) {
		if(visit[n]) {
			return;
		}
		
		visit[n] = true;
		for(int i: arr[n]) {
			if(!visit[i]) {
				check[i] = (check[n]+1) %2;
				DFS(i);
			} else if(check[n] == check[i]) {
				IsEven = false;
			}
		}
		
		
	}
}













