package Q40_49;
import java.util.*;
import java.io.*;

public class Q47 {

	
	// 모든 노드로 BFS탐색을 진행한다는 아이디어를 떠올리기 힘들었던 문제
	// 아이디어를 떠올리기 위한과정
	// 문제의 핵심 - 특정노드로 향하는 노드의 개수 구하기
	// 1번 노드로 향하는 노드의 개수는 어떻게 구할까?
	// 답이 안나와 좀더 구체적인 질문
	// 3번노드에서 2번노드를 지나가는지는 어떻게 알수 있을까?
	// 3번에서 그래프 탐색을 시작하여 2번노드를 방문한 경우는 3번이 2번을 지나감
	//결론 - 그렇다면 모든노드에서 탐색을 진행하여 지나가는 노드를 카운트 해주면됨
	
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int[] count;
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
		}
		
		visit = new boolean[n+1];
		count = new int[n+1];
		for(int i=1; i<=n; i++) {
			visit = new boolean[n+1];
			BFS(i);
		}
		for(int i=1; i<=n; i++) {
			if(count[i]==max) {
				System.out.println(i);
			}
		}
		
	}
	
	public static void BFS(int node) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(node);
		visit[node] = true;
		
		while(!que.isEmpty()) {
			int pop = que.poll();
			for(int i : arr[pop]) {
				if(!visit[i]) {
					que.add(i);
					visit[i] = true;
					count[i] +=1;
					if(count[i]>max) max=count[i];
				}
			}
		}
		
	}

}
