package Q20_29;
import java.util.*;
import java.io.*;

public class Q28 {

	static ArrayList<Edge>[] arr;
	static boolean[] visit;
	static int[] distance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//노드 숫자 받아오기 
		int nc = Integer.parseInt(st.nextToken());
		
		//배열 객체 생성
		arr = new ArrayList[nc+1];
		visit = new boolean[nc+1];
		distance = new int[nc+1];
		
		//for ArrayList 생성
		for(int i=1; i<=nc; i++) {
			arr[i] = new ArrayList<Edge>();
		}
		
		
		//for 그래프 생성
		for(int i = 1; i<=nc; i++) {
			st = new StringTokenizer(in.readLine());
			int now = Integer.parseInt(st.nextToken());
			//for 노드가 여러개있으니까 여러번 반복 -1이 나올 때 까지
			while(true) {
				//노드 번호와 길이 가져오기
				int node = Integer.parseInt(st.nextToken());
				if(node != -1) {
					int length = Integer.parseInt(st.nextToken());
					
					//edge클래스를 생성후 arraylist에 삽입
					arr[now].add(new Edge(node,length));  //객체 참조 관련 문제 가능성-변수이름없이 바로 new를 통해 객체생성
				} else break;
			}			
		}
		
		BFS(1);
		int max = 1;
		for(int i=2; i<= nc; i++) {
			if(distance[max]< distance[i]) {
				max = i;
			}
		}
		distance = new int[nc +1 ];
		visit = new boolean[nc+1];
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[nc]);
	}
	
	static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visit[index] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(Edge i: arr[node]) {
				int e = i.node;
				int length = i.length;
				if(!visit[e]) {
					queue.add(e);
					visit[e] = true;
					distance[e] = distance[node]+length;
				}
			}
		}
	}
}

//static클래스 내부에 static가 붙지 않은 이너클래스를 생성하는 경우 컴파일 오류
//엣지길이와 연결된 노드를 담을 데이터 클래스 생성
class Edge{
	int node, length;
	Edge(int node, int length){
		this.length = length;
		this.node = node;
	}
}
	
	
	
	
	
	
	
