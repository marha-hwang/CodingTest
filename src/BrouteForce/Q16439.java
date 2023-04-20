package BrouteForce;
import java.util.*;
import java.io.*;

public class Q16439 {
	static int n,m;
	static int[][] arr;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		//치킨의 모든 조합을 구하고, 회원들의 만족도를 계산하기
		//3개의 치킨을 뽑는 것이 정해져 있으므로 단순 3중 반복문 사용
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//입력받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//3중 반복문 시작
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
			//부모 반복문에서 동일한 숫자가 나오는 경우 break
				if(i==j) break;
				for(int k=0; k<m; k++) {
					if(i==k || j==k) break;
					//회원들의 만족도 계산하기(함수 사용)
					int[] c = {i,j,k};
					getSatisfy(c);
					
				}
			}
		}
		System.out.print(result);
	}
	public static void getSatisfy(int[] c) {
		int sum=0;
		for(int i=0; i<n; i++) {
			//회원 한명의 만족도 계산
			int temp = 0;
			for(int j=0; j<3; j++) {
				temp = Math.max(temp, arr[i][c[j]]);
			}
			sum+=temp;
		}
		result = Math.max(result, sum);
	}

}
