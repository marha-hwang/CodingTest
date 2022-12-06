package Q50_59;
import java.util.*;
import java.io.*;

public class Q54 {

	//건물을 순서대로지을 때 건물을 짓는데 걸리는 최소시간 구하기
	//우선 건물을 짓는 순서는 위상정렬을 통해 구현하기
	//이제 정렬된 건물의 시간을 더하면 되는데
	//문제 : 기본 위상정렬은 건물의 분기를 고려하지 않고 다른 분기의 시간도 더하기 때문에 추가로직 필요
	//해답 : 배열을 하나 만들고 건물노드가 큐에 담길때 (현재건물을 짓는데 걸리는 최소 시간 + 다음 건물만 짓는데 걸리는 시간) 배열에 저장
	//반례 : 여러개의 노드들이 다른 한 노드의 선행노드가 될 때 해당노드의 시간은 (이전노드들의 시간중 최대시간 + 해당 노드의 시간) 이 되어야 한다.
	//해답 : 해당노드 이전까지의 최대시간을 담기 위한 배열을 만들고, 이전노드에서 노드의 탐색이 진행될 때 배열에 담긴값과 비교하여 최대시간으로 갱신하면 된다.
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] time = new int[n+1]; 
		int[] enter = new int[n+1];
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			while(t != -1) {
				arr[t].add(i);
				enter[i] ++;
				t = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<=n; i++) {
			if(enter[i] == 0) {
				que.add(i);
			}
		}
		
		int[] max = new int[n+1];
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i: arr[now]) {
				enter[i]--;
				if(max[i] < time[now]) {
					max[i] = time[now];
				}
				if(enter[i] == 0) {
					que.add(i);
					time[i] = max[i] + time[i];
				}
			}
		}
		
		for(int i = 1; i<=n; i++) {
			System.out.println(time[i]);
		}
	}

}
