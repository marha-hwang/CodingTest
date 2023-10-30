package Implementation;

import java.util.*;
import java.io.*;
public class Q4396 {
	static int n;
	static String[][] bomb, check, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//문자열을 짜르는 방법은? StringTokenizer, split(), subString
		//	StringTokenizer - 특정문자열을 기준으로 문자열을 토큰화한다.
		//	split - 특정문자열을 기준으로 문자열을 분리하여 문자열 배열에 저장한다.
		//	subString - 문자열의 인덱스를 기준으로 문자열을 읽어온다.
		//	charAt - 문자열이 아닌 특정인덱스의 문자를 읽어온다.
		//방향벡터를 사용하기 적절한 조건은? 특정 좌표를 기준으로 주변을 확인해야 할 때
		
		//예제 입출력 만족후 14%에서 오답이 나옴, 반례를 찾기 어려웠음
		// --> 지뢰를 밟았어도 이미 열린칸에 대해서는 주변 지뢰개수를 표시해야 한다고 함
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		bomb = new String[n][n];
		check = new String[n][n];
		result = new String[n][n];
		for(int i = 0; i<n; i++) {
			String now = in.readLine();
			for(int j = 0; j<n; j++) {
				bomb[i][j] = now.substring(j, j+1);
			}
		}
		
		for(int i = 0; i<n; i++) {
			String now = in.readLine();
			for(int j = 0; j<n; j++) {
				check[i][j] = now.substring(j, j+1);
			}
		}
		boolean bang = exclusion();
		bombCount();
		for(int i = 0; i<n; i++) {
			for(int j= 0; j<n; j++) {
				if(bang && bomb[i][j].equals("*")) System.out.print("*");
				else System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
	}

	//선택된 칸에 지뢰가 존재하는지 확인
	static boolean exclusion() {
		boolean result = false;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(check[i][j].equals("x") && bomb[i][j].equals("*")) result = true;
			}
		}
		return result;
	}
	
	//둘러싸는 칸에 존재하는 지뢰가 몇개인지 확인
	static void bombCount() {
		int[][] vector = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(check[i][j].equals(".")) result[i][j] = ".";
				else {
					int count = 0;
					//해당 칸 주위의 지뢰개수를 확인 후 저장
					for(int k = 0; k<vector.length; k++) {
						int row = i+vector[k][0];
						int col = j+vector[k][1];
						if(row < n && col < n && row >= 0 && col >= 0 && bomb[row][col].equals("*")) count++;
					}
					result[i][j] = Integer.toString(count);
				}
			}
		}
	}
	
}












