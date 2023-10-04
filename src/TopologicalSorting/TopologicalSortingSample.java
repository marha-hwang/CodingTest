package TopologicalSorting;

import java.io.*;
import java.util.*;

public class TopologicalSortingSample {

	//BFS알고리즘을 기반으로 하여 진입차수를 관리하는 배열을 추가하고
	//BFS탐색시 다음방문노드를 바로 큐에 넣는 것이 아니라
	//다음노드 진입차수를 감소시킨 후 만약 0이라면 더 이상 선행노드가 없는 것이기 때문에
	//진입차수가 0이되는 경우 큐에 삽입한다.
	//BFS와 차이점? 노드를 큐에 넣는 시점, 진입차수 관리
	
	//예제 : 1번부터 N까지 모든 과목에 대해 각 과목을 이수하려면 최소 몇 학기가 걸리는지 계산
	static int n,m;
	static ArrayList<Integer>[] arr;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken()); //과목수
		m = Integer.parseInt(st.nextToken()); //선수조건의 수
		
		arr = new ArrayList[n+1];
		indegree = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[s].add(e);
			indegree[e]++;
		}
		
		int[] result = topologicalSorting();
		for(int i = 1; i<=n; i++) System.out.print(result[i] + " ");
		
	}
	
	static int[] topologicalSorting() {
		int[] result = new int[n+1];
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1; i<=n; i++) {
			if(indegree[i] == 0) {
				que.add(i);
				result[i] = 1;
			}
		}
		
		while(!que.isEmpty()) {
			int s = que.poll();
			for(int i = 0; i<arr[s].size(); i++) {
				int e = arr[s].get(i);
				indegree[e]--;
				if(indegree[e] == 0) {
					que.add(e);
					result[e] = result[s]+1;
				}
			}
			
		}
		return result;
	}

}
