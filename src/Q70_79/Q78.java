package Q70_79;
import java.util.*;
import java.io.*;
public class Q78 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int q = Integer.parseInt(st.nextToken());
		//사는 사람을 저장할 배열 생성
		int[][] D = new int[14+1][14+1];
		//배열에 들어갈 기본값 입력하기
		for(int i = 0; i<=14; i++) {
			D[0][i] = i;
			D[i][1] = 1; 
		}
		
		//점화식을 이용하여 배열 채우기
		for(int i = 1; i<=14; i++) {
			for(int j = 1; j<=14; j++) {
				D[i][j] = D[i-1][j] + D[i][j-1];
			}
		}

		//질의의 수만큼 결과를 출력
		for(int i = 0; i<q; i++) {
			int a = Integer.parseInt(in.readLine());
			int b = Integer.parseInt(in.readLine());
			
			System.out.println(D[a][b]);
		}
		
	}

}
