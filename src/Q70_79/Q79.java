package Q70_79;
import java.io.*;
import java.util.*;
public class Q79 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int q = Integer.parseInt(st.nextToken());
		
		//배열 생성하고 기본값 채우기, 사이트의 최대값이 30+1이므로 30+1크기 2차원 배열 생성
		int[][] D = new int[30+1][30+1];
		for(int i = 0; i<=30; i++) {
			D[0][i] = 1;
		}
		
		//점화식을 이용하여 배열 모두 채우기
		for(int i = 1; i<=30; i++) {
			for(int j = i; j<=30; j++) {
				D[i][j] = D[i-1][j-1] + D[i][j-1];
			}
		}
		
		
		//쿼리에 따른 결과값 출력하기
		for(int i = 0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(D[a][b]);
		}
	}

}
