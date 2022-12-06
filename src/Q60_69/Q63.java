package Q60_69;
import java.util.*;
import java.io.*;
public class Q63 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		long[][] distance = new long[n+1][n+1];
		for(int i = 1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				distance[i][j] = Integer.MAX_VALUE;
				if(i == j) distance[i][j] = 0;
			}
		}
		
		
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		
		
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
						distance[j][i] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		int sum = 100;
		int result = 0;
		for(int i = 1; i<=n; i++) {
			int a = 0;
			for(int j = 1; j<=n; j++) {
				a += distance[i][j];
			}
			if(a<sum) {
				sum = a;
				result = i;
			}
			
		}
		System.out.print(result);

	}

}
