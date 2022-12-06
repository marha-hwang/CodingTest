package Q30_39;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q35 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int[][] A = new int[N][2];
		for(int i = 0; i<N; i++) {
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}
//구현자체는 쉽지만 종료가 더 빠른 회의순으로 배치해야 한다는 아이디어가 떠올리기 힘들었던 문제
		//아래의 두가지 정렬방식은 같은 코드이다, 오름차순으로 정렬
//		Arrays.sort(A, new Comparator<int[]>() {
//			public int compare(int[] S, int[] E) {
//				if(S[1] == E[1]) {
//					return S[0] -E[0];
//				}
//				return S[1] - E[1];
//			}
//		});
		
		Arrays.sort(A, ((o1,o2)->{
			if(o1[1] == o2[1]) {
				return o1[0] > o2[0]?1:-1;
			}
			return o1[1] > o2[1]? 1:-1;
			}
		));
		
		
		int count = 0;
		int end = -1;
		for(int i=0; i<N; i++) {
			if(A[i][0]>= end) {
			end =A[i][1];
			count++;
			}
		}
		System.out.println(count);
	}
	

}
