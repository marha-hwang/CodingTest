package Implementation;
import java.util.*;
import java.io.*;

public class Q1913 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		int[][] arr = new int[n+1][n+1];
		
		//구현문제는 큰 문제를 작은 문제로 쪼개면서 푸는것이 좋은거같음
		//문제 : 달팽이수열을 출력하기
		//사각형의 수열 모두 구하기 -> 테두리의 수열 구하기 -> 한 모서리의 수열 구하기
		//-> 한 모서리의 수열을 구하는 방법은?
		//시작과 끝의 좌표를 구하여 계산하기
		int s = 1;
		int e = n;
		int now = n*n;
		while(s<=e) {
			int diff = e-s;
			if(diff == 0) arr[s][s] = 1;
			for(int i=0; i<e-s; i++) {
				arr[s+i][s] = now-i;
				arr[e][s+i] = now-diff-i;
				arr[e-i][e] = now-2*diff-i;
				arr[s][e-i] = now-3*diff-i;
			}
			now = arr[s][s+1]-1;
			s++;
			e--;
		}
		int row=-1,col=-1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				out.write(arr[i][j] + " ");
				if(arr[i][j] == m) {
					row = i;
					col = j;
				}
			}
			out.write("\n");
		}
		out.write(row + " " + col);
		out.flush();
		out.close();
	
	}

}
















