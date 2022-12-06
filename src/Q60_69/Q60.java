package Q60_69;
import java.io.*;
import java.util.*;
/*벨만 포드 알고리즘을 약간 변형하여 풀은 문제
1차 구현은 쉽게 하였으나 채점결과 계속 오답처리 되었음,
반례찾기가 상당히 힘들었던 문제
반례를 찾은 테스트케이스
3 0 2 4
0 1 9999
1 2 9999
1 1 9999
0 2 0
10000 10000 10000
오답 : 20000 정답 : Gee

틀린이유 : 벨만포드 알고리즘에서 사이클 확인은 거리배열에서 수정되는 노드가 하나라도 있으면 사이클의 존재를 확인할 수 있다.
		하지만 특정노드와 사이클의 연결여부는 단순히 특정노드의 거리배열값이 수정되는 것을 확인함으로써 되지 않는다.
		특정노드의 선행노드에서의 사이클이 누적된 결과로 특정노드의 거리배열이 수정될 수 있기 때문이다.
		위의 테스트케이스에서 1번 노드는 자기 자신과 사이클 관계가 되어있다. 따라서 1번노드의 사이클이 누적되어
		2번 노드에 전달되면 2번노드의 값이 수정되기 때문에 계속 오답처리가 되었다.
해결 : 만약 선행노드가 사이클이라면 후행노드를 사이클로 체크하는 코드로 수정했다.
개선방안 : 1. 사용하는 알고리즘에 대한 확실한 이해를 바탕으로 문제 풀이를 진행해야 한다.
		(특정노드가 사이클인지 확인해야지 -> 특정노드까지의 거리가 수정되는지만 확인하면 되겠네)와 같은 사고로 문제를 풀었기 때문에 틀렸다.
		2. 이미 비슷한 코드를 짜봤더라도 내가 지금 짜고있는 코드가 이 상황에서 무슨 역활을 하는지 항상 질문하고 반례를 찾으면서 코드를 짜야한다.

*/


public class Q60 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int nedge = Integer.parseInt(st.nextToken());
		
		Edge[] arr = new Edge[nedge];
		for(int i= 0; i<nedge; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[i] = new Edge(a,b,value);
		}
		
		int[] money = new int[node];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<node; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<nedge; i++) {
			arr[i].value = -(money[arr[i].end] - arr[i].value);
		}
		
		long[] distance = new long[node];
		for(int i =0; i<node; i++) {
			distance[i] = Long.MAX_VALUE;
		}
		distance[start] = -money[start];
		
		for(int j = 0; j<node; j++) {
			for(int i = 0; i<nedge; i++) {
				if(distance[arr[i].start] != Long.MAX_VALUE 
						&& distance[arr[i].end] > distance[arr[i].start] + arr[i].value)
					distance[arr[i].end] = distance[arr[i].start] + arr[i].value; 
			}
		}
		
		boolean cycle[] = new boolean[node];
		for(int j = 0; j<nedge; j++) {
				for(int i = 0; i<nedge; i++) {
					if(distance[arr[i].start] != Long.MAX_VALUE 
							&& distance[arr[i].end] > distance[arr[i].start] + arr[i].value) {
						cycle[arr[i].end] = true;
					}
					if(cycle[arr[i].start]) cycle[arr[i].end] = true; 
						
				}
		}
		
		if(distance[end] == Long.MAX_VALUE) System.out.print("gg");
		else if(cycle[end]) System.out.print("Gee");
		else System.out.print(-distance[end]);

	}

}
//64번문제에 Edge클래스가 존재하여 생기는 오류
class Edge{
	int start, end, value;
	public Edge(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
}
