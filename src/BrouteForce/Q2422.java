package BrouteForce;
import java.util.*;
import java.io.*;

//한윤정이 이탈리아에 가서 아이스크림을 사먹는데
public class Q2422 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//불가능한 조합저장
		boolean arr[][] = new boolean[200+1][200+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		int result = 0;
		//3중반복문을 통해 조합을 구한 뒤 arr을 통해 가능한 조합인지 확인 
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				for(int k=j+1; k<=n; k++) {
					if(!arr[i][j]  && !arr[i][k] && !arr[j][k]) {
						result +=1;
					}
				}
			}
		}
		
		System.out.print(result);
		
	}

}
