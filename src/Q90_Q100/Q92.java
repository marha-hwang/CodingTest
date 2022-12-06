package Q90_Q100;
import java.util.*;
import java.io.*;

public class Q92 {
	//점화식 D[N][L][R]의 정의 N개의 건물이 존재 할 때 왼쪽에서 a개 오른쪽에서 b개 보이게 하는 경우의 수
	// D[N][L][R]를 제외한 나머지는 모두 구해져 있다고 가정
	// 제일 큰 건물 하나를 마지막에 추가하는 경우는 경우의 수가 복잡해짐
	// 제일 작은 건물을 마지막에 추가하는 방법으로 경우의 수 계산
	// 경우의 수는 왼쪽에 배치하는 경우, 오른쪽에 배치하는 경우, 가운데 배치하는 경우
	// 왼쪽에 배치하는 경우는 D[N-1][L-1][R]
	// 오른쪽에 배치하는 경우는 D[N-1][L][R-1]
	// 가운데 배치하는 경우는 D[N-1][L][R] * (N-2)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		
		long[][][] D = new long[N+1][L+1][R+1];
		D[1][1][1] = 1;
		
		for(int i = 2; i<=N; i++) {
			for(int j = 1; j<=L; j++) {
				for(int k = 1; k<=R; k++) {
					D[i][j][k] = (D[i-1][j][k]*(i-2) + D[i-1][j-1][k] + D[i-1][j][k-1]) % 1000000007;
				}
			}
		}
		
		System.out.print(D[N][L][R]);
		
	}

}
