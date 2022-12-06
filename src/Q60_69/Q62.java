package Q60_69;
import java.util.*;
import java.io.*;

public class Q62 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] distance = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				distance[i][j] = 0;
			}
		}
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<n; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(distance[i][k] != 0 && distance[k][j] != 0) {
						distance[i][j] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(distance[i][j] == 0) {
					System.out.print(0 + " ");
				}else {
					System.out.print(1 + "  ");
				}
			}
			System.out.println();
		}
		
	}

}
