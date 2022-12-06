package Q80_89;
import java.util.*;
import java.io.*;

public class Q85 {

	public static void main(String[] args) throws Exception{
		/*
		 * 문제 - N일 동안 상담을 하여 얻을 수 있는 최대 수익 구하기
		 * 입력 - N일만큼의 상담개수 상담 에는 상담 소요일과 수익정보가 포함된다. 
		 * 사고과정
		 * 1. 1일째부터 최대수익을 구하기 위해서는 1일째 상담을 수행한 경우와 안한경우 두가지 경우중 최대값을 선택해야 한다.
		 * 2. 따라서 D[k] = Math.max(k일에 버는 수익 + D[k+ (k일 상담이 걸리는 시간), D[k+1]) 점화식이 도출된다.
		 * 3. 점화식을 이용하여 마지막 날 부터 답을 구함으로써 1일째부터 최대수익을 구할 수 있게된다.
		 * 
		 * 어려웠던이유
		 * 1. 점화식을 사용해야 되는지 확신하지 못했다.
		 * 2. 점화식을 도출해내는 것이 어려웠다.
		 * 3. 점화식의 의미(작은문제)를 정하는 것이 어려웠다.
		 * 4. 너무 복잡하게 생각을 했다.
		 * 문제를 명확하게 인지하고 필요한 생각들을 확장시켜 나가야 하는데 확장이 되지 않아 필요해 보이는 것들을 어떻게 해결할지 무작정
		 * 떠올리게 되었다. 이때문에 떠오르는 생각들을 문제와 연결시키기 점점 어려워졌고 무작정 하는 생각들이 모여 복잡하게 생각을 하게 되었다.
		 * 보완할 점
		 * 문제를 명확하게 인지하고 생각을 확장시켜 나가기, 문제를 여러가지 방식으로 표현해보기
		 * 큰 문제(1일째 부터 최대수익구하기)를 명확하게 인지하고 작은문제(2~N일까지 최대수익)은 모두 정해져 있는상태를 이용하여 큰 문제를 구하는 법 생각하기 
		 * 점화식은 큰 문제와 작은 문제를 도출해내는 방식이 동일하다. 또한 제일 작은 문제의 답은 이미 구해져 있어야 한다는 점 이용
		 * 큰문제를 구하기 위한 작은답이 모두 존재 할 때 큰 문제의 답을 구할 수 있는 방법이 존재할까? 라는 질문 던지기
		 * 
		 */
		
		//점화식을 이용한 풀이
		//k일부터 벌수 있는 최대수익 D[k] = Math.max(k일에 버는 수익 + D[k+ (k일 상담이 걸리는 시간), D[k+1])
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//입력저장
		int N = Integer.parseInt(in.readLine());
		int[] T = new int[N+2]; //걸리는 일 수
		int[] P = new int[N+2]; // 수익
		int[] D = new int[N+2]; //k일부터 벌 수 있는 최대 수익
		
		StringTokenizer st;
		for(int i = 1; i<= N; i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N; i>=1; i--) {
			//k일째 일을 진행한 경우와 진행하지 않은경우중 더 많은 수익을 얻는 경우가 k일 부터 최대 수익
			if(i + T[i] > N + 1) D[i] = D[i+1];
			else D[i] = Math.max(D[i+1], P[i] + D[i+T[i]]);
			
		}
		System.out.print(D[1]);
		
		//DFS를 이용한 풀이
	}

}

// //DFS탐색을 이용한 풀이법
//public class Q85 {
//	/*
//	 * DP를 사용하기 위해서는 작은문제에서 나온답을 가지고 큰 문제를 풀 수 있어야 한다. 
//	 * 하지만 어번 문제와 같은 경우는 작은 문제에서 확실한
//	 * 답이 존재하지 않아 DP풀이법을 사용할 수 없었다.
//	 */
//	
//	static ArrayList<Integer>[] arr;
//	static ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
//	public static void main(String[] args) throws Exception{
//		/*DFS를 통해 선택 될 수 있는 모든 상담의 조합을 구한다.
//		이때 조합을 구하는 것이기 때문에 방문 배열은 필요가 없다.
//		DFS를 통해 구한 모든 조합을 확인하여 최대 수익을 낼 수 있는 조합을 답으로 출력한다*/
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(in.readLine());
//		
//		StringTokenizer st;
//		Consulting[] consulting = new Consulting[N+1];
//		//data클래스 형태로 기간, 수익을 저장한다.
//		for(int i = 1; i<=N; i++) {
//			st = new StringTokenizer(in.readLine());
//			int period = Integer.parseInt(st.nextToken());
//			int money = Integer.parseInt(st.nextToken());
//			consulting[i] = new Consulting(period, money);
//		}
//		
//		arr = new ArrayList[N+1];
//		//그래프 생성 1은 2~N 으로 3은 4~N으로 연결되는 단방향 그래프 생성
//		for(int i = 1; i<=N; i++) {
//			arr[i] = new ArrayList<Integer>();
//			for(int j = i+1; j<=N; j++) {
//				arr[i].add(j);
//			}
//		}
//		
//		
//		//DFS를 통해 모든 조합구하기
//		for(int i = 1; i<=N; i++) {
//			ArrayList<Integer> days = new ArrayList<Integer>(); 
//			DFS(i, days);
//		} 
//		
//		int result = 0;
//		//구한 조합에서 최대 수익을 내는 조합 구하기
//		for(ArrayList<Integer> a: c) {
//			int moneysum = 0;
//			//해당 조합에서 걸리는 시간과 총 수익 계산하기
//			for(int b=0; b<a.size(); b++) {
//				//현재상담과 다음상담이 겹치는 경우 종료
//				if(b+1 < a.size() && a.get(b)+consulting[a.get(b)].period > a.get(b+1)) break;
//				//퇴사일을 넘는 경우
//				if(a.get(b)+consulting[a.get(b)].period > N+1) break;
//				moneysum += consulting[a.get(b)].money;
//			}
//			
//			if(result < moneysum) result = moneysum;
//		}
//		
//		System.out.print(result);
//		
//
//	}
//	
//	
//	static public void DFS(int n, ArrayList<Integer> days) {
//		//days 에 방문 날짜 추가
//		days.add(n);
//		//해당조합추가하기
//		c.add(days);
//		//종료조건 - 주어진 마지막 날짜까지 방문시 종료
//		if(arr[n].size() == 0) {
//			return;
//		}
//		
//		for(int i: arr[n]) {
//			DFS(i, (ArrayList<Integer>) days.clone());
//		}
//	}
//}
//
//class Consulting{
//	int period, money;
//	public Consulting(int period, int money) {
//		this.period = period;
//		this.money = money;
//	}
//}
