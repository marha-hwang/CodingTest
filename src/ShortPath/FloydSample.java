package ShortPath;

import java.util.*;
import java.io.*;

public class FloydSample {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] D = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<n; j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k == 1) D[i][j] = 1;
				else D[i][j] = 10000;
			}
		}
		
		//k반복 : 근처부터 잇는다. 
		//i, j반복 : 근처를 계속 잇다가 통로가 뚫리면 자연스레 모든 루트에 대한 거리를 구할 수 있다.
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					D[i][j] = Math.min(D[i][j] ,D[i][k] + D[k][j]);
				}
			}
		}
		
		Arrays.stream(D).forEach((int[] arr) -> { 
			Arrays.stream(arr).forEach((int i) -> {
				if(i != 10000)System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}); 
			System.out.println();
		});
		
	}


}
