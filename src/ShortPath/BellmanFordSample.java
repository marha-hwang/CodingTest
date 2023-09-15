import java.io.*;
import java.util.*;

public class BellmanFordSample {

	public static void main(String[] args) throws IOException {
		//간선 1개만 사용 하는 최단거리부터 확실하게 하면, 간선을 n-1 사용가능 할 때최단거리를 알 수 있다.  
		//이러한 과정을 1~(n-1)까지 반복하면(일자 그래프인 경우 간선은 최대 n-1개면 모두 연결된다.)
		//한번 반복시 간선1개를 통한 모든 노드까지의 최단거리를 구할 수 있다.
		//n-1번 반복시 간선 n-1개를 통한 모든 노드까지의 최단거리를 구할 수 있다.
		
		//*구현 주의사항 : 초기값을 Integer.MAX_VALUE를 설정 할 때, 음수인 거리가 포함되어 있기 때문에
		//	시작노드가 Integer.MAX_VALUE인지 체크하지 않으면 (Integer.MAX_VALUE - 간선비용)이 기록되어 버린다.

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int  n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] D = new long[n+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		
		Edge[] arr = new Edge[m];
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
		
			arr[i] = new Edge(s,e,cost);
		}
		
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<m; j++) {
				Edge now = arr[j];
				if(D[now.s] == Integer.MAX_VALUE || D[now.e] <= D[now.s] + now.cost) continue;
				D[now.e] = D[now.s] + now.cost;
			}
		}
		
		for(int j = 0; j<m; j++) {
			Edge now = arr[j];
			if(D[now.s] == Integer.MAX_VALUE || D[now.e] <= D[now.s] + now.cost) continue;
			System.out.print(-1);
			return;
		}
		
		for(int i=2; i<=n; i++) {
			if(D[i] == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(D[i]);
		}
		
		
	}
}

class Edge{
	int s,e,cost;
	
	public Edge(int s, int e, int cost) {
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
}
