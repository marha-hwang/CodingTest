package Play;
import java.util.*;
import java.io.*;

public class Q10003 {
	public static void main(String[] args) throws IOException {
		//문제 : (i-L+1)번째부터 i번째까지 가장 작은 값을 찾기, 모든 i에 대해서, 0보다 작으면 신경쓰지 않음
		//간단히 : L만큼의 모든 구간에서 가장 작은 수 찾기
		//계획하기
		//- 가장 간단한 방법은 한 구간을 확인할 때 완전 탐색하기
		//- 시간 복잡도를 줄일 수 있는 방법은? 
		//특정 한 구간에서 답을 찾았다고 가정할 때, 다음 구간과의 차이는?
		//앞의 하나가 제외되고 뒤의 하나가 추가된다.
		//뒤의 숫자는 최솟값을 기록해놓으면 문제없음
		//하지만 앞의 숫자가 최솟값인 경우 다음 최솟값을 구해야 함
		//문제 : 다음 최솟값을 구하는 방법은? 우선순위 큐를 사용하여 작으면 우선순위가 높음
		//현재 최솟값으로 i번째, 값을 저장해놓고, i번째를 제거하는 경우 우선순위 큐에서 하나를 뽑음
		//만약 뽑은 요소가 i번째 이하면 하나를 더 뽑고 i이상이면 최솟값으로 저장
		
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[n];
		answer[0] = input[0];
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		answer[0] = input[0];
		que.add(new Node(0, input[0]));
		//L까지 최솟값을 저장, 우선순위 큐에 값을 동시에 삽입
		for(int i = 1; i<l; i++) {
			Node now = new Node(i, input[i]);
			que.add(now);
			answer[i] = que.peek().n;
		}
		
		int s = 0;
		int e = l-1;
		while(e+1 < n) {
			e++;
			s++;
			que.add(new Node(e, input[e]));
			
			//node의 i가 s와 같거나 클때까지 큐를 뽑기
			while(que.peek().i < s) {
				que.poll();
			}
			//큐를 peek()하여 정답배열에 저장	
			answer[e] = que.peek().n;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		for(int i = 0; i<n; i++) {
			bw.write(answer[i] + " ");   //버퍼에 있는 값 전부 출력 
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();
	}
}


class Node implements Comparable<Node>{
	int i,n;
	public Node(int i, int n) {
		this.i = i;
		this.n = n;
	}
	@Override
	public int compareTo(Node o) {
		return this.n > o.n ? 1:-1;
	}
}
















