package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnionFindSample {
	//유니온-파인드를 사용하는 이유? 두 노드가 같은 그래프에 속해 있는지 확인하기 위해 사용한다.
	//유니온-파인드를 사용하지 않는다면? 두 노드가 같은 그래프에 속해 있는지 확인하기 위해 매번 그래프 탐색을 진행해야 한다.
	//알고리즘의 원리는? union연산을 통해 노드를 합치고, find연산을 통해 노드의 연결관계를 확인한다.
	//union연산의 원리는? 각 노드의 루트 노드를 저장하는 배열을 만들어 루트 노드를 저장한다.
	//find연산의 원리는? 루트노드가 저장된 배열을 통해 루트 노드를 반환한다.
	
	//루트노드가 같으면 같은 그래프에 속함
	//루트 노드인지 확인하는 법 : 루트노드 저장 배열에서 루트 노드와 해당 노드가 동일한 경우
	//루트 노드를 저장하는 법 : 그래프를 합쳐나가면서 부모노드를 자식 노드의 루트로 저장한다.
	//위와 같은 경우의 문제점 : 일자형 그래프인 경우 find연산의 연산횟수가 많아진다.
	//루트노드와 다른 노드가 가까워질수록 연산횟수가 줄어들음
	//#######실제 그래프와 연결관계를 나타내는 그림을 구분지어 상상하기#######
	//만약 그래프에서 사이클이 존재하는 경우 문제가 있을까? 문제 없음 
	// --> 만약 사이클이 존재하는 경우 루트노드가 같은 두 집합을 합치게 되는데 루트 노드가 같으면 배열에 변화가 일어나지 않기 때문이다.
	
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//union연산
			if(type == 0) {
				union(a,b);
			}
			//find연산
			else if(type == 1) {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}

	static void union(int x, int y) {
		parent[find(y)]= find(x);
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		//경로 단축을 위해 find와 동시에 루트노드를 수정함
		//따라서 find함수가 호출된 노드를 포함한 해당 노드의 모든 부모는 현재 루트노드 아래 위치하게 됨
		parent[x] = find(parent[x]);
		return parent[x];
	}
}












