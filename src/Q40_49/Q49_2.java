package Q40_49;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 기본적인 BFS알고리즘을 이용하기 위해 필요한 것을 우선 정리후 필요한 로직을 추가하면서 구현
// 경우의 수를 확인하기 위해 base배열을 사용함 - 정보를 가진 데이터(현재 각 물통에 채워진 물의 양)는 base배열의 값으로 접근가능해야 함
// 방문을 체크하기 위한 방문 배열을 다차원 배열로 구성가능


public class Q49_2 {
	static boolean[][][] visit;
	static boolean[] answer;
	static int[] amount;
	static int[][] base = {{0,1},{0,2},{1,0},{1,2},{2,0},{2,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		visit = new boolean[a+1][b+1][c+1];
		answer = new boolean[c+1];
		amount = new int[]{a,b,c};
		BFS(0, 0, c);
		
		for(int i=0; i<=c; i++) {
			if(answer[i] == true) {
				System.out.print(i + " ");
			}
		}

	}
	
	public static void BFS(int a, int b, int c) {
		Queue<Liter> que = new LinkedList<Liter>();
		
		que.add(new Liter(a,b,c));
		visit[a][b][c] = true;
		
		while(!que.isEmpty()) {
			Liter liter = que.poll();
			if(liter.a == 0) {
				answer[liter.c] = true; 
			}
			for(int i = 0; i<6; i++) {
				//다음 물의양 설정하기
				int[] now = {liter.a, liter.b, liter.c};
				now[base[i][1]] = now[base[i][1]] + now[base[i][0]];
				now[base[i][0]] = 0;
				if(now[base[i][1]] > amount[base[i][1]] ){
					now[base[i][0]]	= now[base[i][1]] - amount[base[i][1]];
					now[base[i][1]] = amount[base[i][1]];
				}
				
				if(visit[now[0]][now[1]][now[2]] == false) {				
					//다음 a,b,c의 값을 큐에 추가
					que.add(new Liter(now[0], now[1], now[2]));
					visit[now[0]][now[1]][now[2]] = true;
				}
			}
		}
		
		
	}

}

class Liter{
	int a;
	int b;
	int c;
	public Liter(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
