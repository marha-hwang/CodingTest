package Q90_Q100;

//타일을 추가할 때 정사각형의 크기가증가하기 위해서는 무슨 조건이 필요할지 생각해보기 
//정사각형의 최대크기가 증가한다면 이전까지 최대크기를 가진 정사각형이 새로 추가할 면적과 붙어있어야 한다.
//또한 증가시킬 크기만큼 현재 위치에서 가로세로 방향으로 타일이 모두 1로 채워져 있어야한다.
//따라서 다음과 같이 1의 개수를 저장하고 구간합 연산을 통해 1이 어떻게 채워져 있는지 확인한다.
//문제점 - 반례(100, 011, 011)이외에도 여러가지 반례가 존재함

import java.util.*;
import java.io.*;

public class Q91 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//입력값 저장
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][m+1];
		for(int i = 1; i<=n; i++) {
			String s = in.readLine();
			for(int j = 1; j<=m; j++) {
				arr[i][j] = Integer.parseInt(s.substring(j-1,j));
			}
		}
	
		int[][] D = new int[n+1][m+1];
		int max = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if(arr[i][j] == 1) {
					D[i][j] = Math.min(D[i-1][j], Math.min(D[i][j-1], D[i-1][j-1])) + 1;
				}
				if(max < D[i][j]) max = D[i][j];
			}
		}
		
		System.out.print(max * max);
	}

}
