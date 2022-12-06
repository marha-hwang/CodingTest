package Q60_69;
import java.io.*;
import java.util.*;

public class Q65_answer {

	static int[][] standard = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] map;
	static int n,m;
	
	static int snum;
	static boolean[][] visit;
	static int[] pnode;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		//맵정보 입력
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		snum = 1;
		//bfs탐색을 이용하여 섬들을 분리하기
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] != 0 && visit[i][j] != true) {
					BFS(i,j);
					snum++;
				}
			}
		}
		
		PriorityQueue<Road> que = new PriorityQueue<Road>();
		//생성할 수 있는 엣지를 모두 생성하기
		//가로방향
		for(int i = 0; i<n; i++) {
			int start = 0;
			int end = 0;
			int value = 0;
			for(int j = 0; j<m; j++) {
				if(map[i][j] != 0 && start == 0 && end == 0) {
					start = map[i][j];
				}else if(map[i][j] == 0 && start !=0) {
					value++;
				} else if(map[i][j] != 0 && map[i][j] != start) {
					end = map[i][j];
					// edge추가
					if(value >1) que.add(new Road(start, end, value));
					start = end;
					end = 0;
					value = 0;
				} else if(map[i][j] != 0 && map[i][j] == start) {
					value = 0;
				}
			}
		}
		//세로방향
		for(int j = 0; j<m; j++) {
			int start = 0;
			int end = 0;
			int value = 0;
			for(int i = 0; i<n; i++) {
				if(map[i][j] != 0 && start == 0 && end == 0) {
					start = map[i][j];
				}else if(map[i][j] == 0 && start !=0) {
					value++;
				} else if(map[i][j] != 0 && map[i][j] != start) {
					end = map[i][j];
					// edge추가
					if(value >1) que.add(new Road(start, end, value));
					start = end;
					end = 0;
					value = 0;
				}  else if(map[i][j] != 0 && map[i][j] == start) {
					value = 0;
				}
			}
		}
		
		//생성한 엣지를 가지고 최단거리 찾기
		pnode = new int[snum];
		for(int i = 1; i<snum; i++) {
			pnode[i] = i;
		}
		
		int edgesu = 0;
		int roadsum = 0;
		while(!que.isEmpty()) {
			if(edgesu == snum-2) {
				break;
			}
			Road now = que.poll();
			if(find(now.s)!= find(now.e)) {
				union(now.s, now.e);
				edgesu++;
				roadsum += now.value;
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		boolean all = true;
		if(edgesu < snum-2) all = false; 
		if(all) System.out.print(roadsum);
		else System.out.print(-1);
	
		
	}
	
	
	//도시를 구분하기 위한 2차원배열 BFS탐색
	static void BFS(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		
		int[] start = {i,j};
		que.add(start);
		visit[i][j] = true;
		map[i][j] = snum;
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			int row = now[0];
			int col = now[1];
			for(int k = 0; k<4; k++) {
				int tempr = standard[k][0];
				int tempc = standard[k][1];
								
				if(row + tempr >= 0 && row+tempr < n && col + tempc >=0 && col +tempc < m) {
					if(visit[row + tempr][col + tempc] == false && map[row+tempr][col+tempc] !=0) {
						map[row+tempr][col+tempc] = snum;
						visit[row+tempr][col+tempc] = true;
						int[] temp = {row+tempr, col+tempc};
						que.add(temp);
					} 
				} 
			}
		}
	}
	
	static int find(int a) {
		if(pnode[a] == a) {
			return a;
		}else {
			int result = find(pnode[a]);
			pnode[a] = result;
			return result;
		}
	}
	
	static void union(int a, int b) {
		if(find(a) != find(b)) {
			pnode[find(b)] = find(a); 
		}
	}

}

class Road implements Comparable<Road>{
	int s, e, value;
	public Road(int s, int e, int value) {
		this.s = s;
		this.e = e;
		this.value = value;
	}
	@Override
	public int compareTo(Road o) {
		return this.value > o.value ? 1:-1;
	}
}
