package Q80_89;
import java.util.*;
import java.io.*;
public class Q88 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//점화식 D[N][0] = D[N-1][1], D[N][1] = D[N-1][0] + D[N-1][1], D[N][9] = D[N-1][8]
		long[][] D = new long[N+1][11];
		for(int i = 1; i<=9; i++) {
			D[1][i] = 1;
		}
		
		for(int i = 2; i<=N; i++) {
			D[i][0] = D[i-1][1];
			D[i][9] = D[i-1][8];
			
			for(int j=1; j<9; j++) {
				D[i][j] = D[i-1][j-1]% 1000000000 + D[i-1][j+1]% 1000000000;
			}
		}
		
		long result = 0;
		for(int i = 0; i<=9; i++) {
			result += D[N][i]%1000000000;
		}
		System.out.print(result%1000000000);

	}

}
