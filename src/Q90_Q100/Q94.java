package Q90_Q100;
import java.util.*;
import java.io.*;
public class Q94 {

	public static void main(String[] args) throws Exception{
		//점화식 D[i][j] = D[i][j-k] + D[j-k+1][j] + (두 행렬을 곱할 때 연산횟수) //k는 1이상이고 j-k값은 i보다 큰 모든 경우에서 최솟값.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//입력받기
		int N = Integer.parseInt(st.nextToken());
		//각 구간마다 연산된 행렬을 저장하기 위해 2차원 배열에 행렬을 저장
		Matrix[][] matrix = new Matrix[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			matrix[i][i] = new Matrix(row, column);
		}
		
		//점화식 배열 초기화
		int[][] D = new int[N+1][N+1];
		for(int[] a : D) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
		//점화식 배열 채우기
		for(int i = 1; i<=N; i++) {
			D[i][i] = 0;
		}
		
		for(int r = 1; r<=N; r++) {
			for(int i = 1; i+r <=N; i++) {		
					// D[i][j]를 채우기 위해서는 i에서j까지지를 포함하는 모든 조합고려
					int j = i+r;
					int k = 1;
					while(j-k >= i) {
						//두 행렬의 곱 계산
						Matrix a = matrix[i][j-k];
						Matrix b = matrix[j-k+1][j];
						int muti = a.row * b.row * b.column; 
						matrix[i][j] = new Matrix(a.row, b.column);
						
						D[i][j]= Math.min(D[i][j], D[i][j-k] + D[j-k+1][j] + muti);
						k++;
					}
			}
			
		}
		
		System.out.print(D[1][N]);
	}

}

class Matrix{
	int row, column;
	public Matrix(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
