package Q60_69;
import java.util.*;
import java.io.*;


// 정확하지 않은 코드 다시 풀어볼문제
// 도시를 구분할 때 잘못된 구분을 함
public class Q65 {
	static int[][] standard = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[] pnode;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[y][x];
		int city = 0;
		
		
		//맵을 도시를 구분하여 저장하기
		for(int i = 0; i<y; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<x; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a != 0) {
					for(int k = 0; k<standard.length; k++) {
						if(j+standard[k][0] >= 0 && j+standard[k][0] < x
							&& i+standard[k][1] >=0 && i+standard[k][1] <y){
								if(map[i+standard[k][1]][j+standard[k][0]] != 0) {
									map[i][j] = map[i+standard[k][1]][j+standard[k][0]];
									break;
								}
							}
					}
					
					if(map[i][j] == 0) {
						city ++;
						map[i][j] = city;
					}
				}
			}
		}
		
		
		for(int i = 0; i<y; i++) {
			for(int j = 0; j<x; j++) {
				int nowcity = map[i][j];
				if(nowcity != 0) {
					for(int k = 0; k<standard.length; k++) {
						if(j+standard[k][0] >= 0 && j+standard[k][0] < x
							&& i+standard[k][1] >=0 && i+standard[k][1] <y){
								if(map[i+standard[k][1]][j+standard[k][0]] !=0 &&
										map[i+standard[k][1]][j+standard[k][0]] != nowcity) {
									for(int l = 0; l<y; l++) {
										for(int m = 0; m<x; m++) {
											if(map[l][m] == map[i+standard[k][1]][j+standard[k][0]]) {
												map[l][m] = nowcity;
											}
										}
									}
									break;
								}
							}
					}
				}
			}
		}
		
		PriorityQueue<Road> que = new PriorityQueue<Road>();
		//생성할 수 있는 엣지를 모두 생성하기
		//가로방향
		for(int i = 0; i<y; i++) {
			int start = 0;
			int end = 0;
			int value = 0;
			for(int j = 0; j<x; j++) {
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
				}
			}
		}
		//세로방향
		for(int j = 0; j<x; j++) {
			int start = 0;
			int end = 0;
			int value = 0;
			for(int i = 0; i<y; i++) {
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
				} 
			}
		}
		
		
		//생성한 엣지를 가지고 최단거리 찾기
		pnode = new int[city+1];
		for(int i = 1; i<=city; i++) {
			pnode[i] = i;
		}
		
		int edgesu = 0;
		int roadsum = 0;
		while(!que.isEmpty()) {
			if(edgesu == city-1) {
				break;
			}
			Road now = que.poll();
			if(find(now.s)!= find(now.e)) {
				union(now.s, now.e);
				edgesu++;
				roadsum += now.value;
			}
		}
		
		boolean all = true;
		if(edgesu < city-2) all = false; 
		
		for(int i = 0; i<y; i++) {
			for(int j = 0; j<x; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		if(all) System.out.print(roadsum);
		else System.out.print(-1);

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
