package Q80_89;
import java.util.*;
import java.io.*;

public class Q89 {
	/*
	 * 도출과정 복기
	 * 완전탐색을 한다면 시간초과가 발생하기 때문에 점화식을 세워야 겠다.
	 * 점화식 D[N]을 N까지의 연속합중 최댓값이라고 할 때
	 * 만약 2~5까지의 연속합이 10으로 최대이고 6~7까지의 연속합이 5이고 8번의 값이 10이라면 최댓값은 15로 수정되어야 한다.
	 * 하지만 위에서 세운 점화식을 통해서는 위와 같은 결과를 도출해 낼 수 없다. D[5]=D[6]=D[7]로 현재 값이 포함되는 연속합을 구할 수 없기 때문이다.
	 * 따라서 N까지의 최댓값을 구하기 위해서는 기존 최댓값과 N을 포함한 최댓값중 더 큰 값이 선택되도록 점화식을 다시 정의해야 한다.
	 * 다시 D[N]을 N을 포함하는 최댓값이라고 한다. 그리고 이미 저장된 최댓값과 비교하여 더 크다면 최댓값을 변경한다.
	 * 
	 * 느낀점 
	 * 위에서 도달한 도출 과정은 이미 생각해본 것이다. 하지만 처음에 구한 점화식에 문제가 있었기 때문에 더 깊게 생각하지 못하고 다른 방법을 계속 찾았다.
	 * 하지만 더 깊게 생각했어야만 풀 수 있는 문제였다.
	 * 문제해결은 문제점을 명확히 정의 하는 것으로 부터 시작한다, 앞으로는 아닌 것 같은 방법도 왜 아닌지 이를 해결할 방법이 없는지 확실히 해나가면서 풀어야겠다.
	 * */

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//점화식 배열 채우기
		// 1~k에서 k를 포함하는 연속합의 최댓값
		int[] DL = new int[N];
		int[] DR = new int[N];
		
		
		//0~N까지 N을 포함하는 최댓값을 기록하는 것, 0~N까지 가장 큰 연속합은 max에 기록함
		DL[0] = arr[0]; 
		int max = DL[0];
		for(int i = 1; i<N; i++) {
			DL[i] = Math.max(DL[i-1] + arr[i], arr[i]);
			//한개도 제거하지 않았을 때 최댓값
			//만약 D[5] 까지 구했고, 6~8까지의 합이 정답이라면
			//D[6]에서는 최댓값을 구할 수 없지만 D[8]에서는 최댓값을 구할 수 있다.
			max = Math.max(max, DL[i]);
		}
		
		DR[N-1] = arr[N-1];
		for(int i = N-2; i>=0; i--) {
			DR[i] = Math.max(DR[i+1] + arr[i], arr[i]);
		}
		
		// 한개를 제거할 때 최댓값
		for(int i = 1; i<N-1; i++) {
			max = Math.max(max, DL[i-1] + DR[i+1]);
		}
		
		
		System.out.print(max);
	}
}
