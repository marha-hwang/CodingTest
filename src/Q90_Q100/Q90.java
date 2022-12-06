package Q90_Q100;

import java.util.*;
import java.io.*;

/*
 *  문자열에 대한 직관적인 느낌이 들어야 하는 문제, 해결된 부분을 그림으로 묶어서 생각해보기
	현재 비교하는 문자가 같으면 – (현재 비교하는 문자를 모두 제외했을 때 값) +1
	현재 비교하는 문자가 다르면 – Math.max(순열1의 현재문자를 제외했을 때 값, 순열2의 현재문자를 제외했을 때 값)*/
public class Q90 {
	static String A;
	static String B;
	static int[][] D;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine();
		B = sc.nextLine();
		
		D = new int[A.length()+1][B.length()+1];

		//LCS(A.length(),B.length());
		
		for(int i =1; i<= A.length(); i++) {
			for(int j = 1; j<= B.length(); j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					D[i][j] = D[i-1][j-1] + 1;
				}else {
					D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
				}
			}
		}
		
		System.out.println(D[A.length()][B.length()]);
		if(D[A.length()][B.length()] != 0) {
			System.out.print(getText());
		}
	}
//	//모든 경우의 중복되는 문자열을 저장하여 구현하는 함수 - 문자열을 처리하는 과정에서 시간초과 발생
//	public static String LCS(int a, int b) {
//		if(a == 0 || b == 0) {
//			D[a][b] = "";
//			return D[a][b];
//		}
//		
//		//추가한 문자열이 같은경우
//		if(A.charAt(a-1) == B.charAt(b-1)) {
//			if(D[a-1][b-1] == null) {
//				D[a][b] = LCS(a-1, b-1) + A.charAt(a-1);
//			}
//			else D[a][b] = D[a-1][b-1] + A.charAt(a-1);
//		//추가한 문자열이 다른 경우
//		}else {
//			if(D[a-1][b] == null) {
//				D[a-1][b] = LCS(a-1,b);
//			}
//			if(D[a][b-1] == null) {
//				D[a][b-1] = LCS(a, b-1);
//			}
//			
//			if(D[a-1][b].length() > D[a][b-1].length()) D[a][b] = D[a-1][b]; 
//			else D[a][b] = D[a][b-1];
//		}
//		
//		return D[a][b];
//	}
//	중복되는 문자를 출력하는 함수
	public static String getText() {
		String answer = "";
		int i = A.length();
		int j = B.length();
		
		while(D[i][j] != 0) {
				//왼쪽값과 비교해서 왼쪽값과 같으면 왼쪽으로 이동
				while(j>=1 && D[i][j] == D[i][j-1]) {
					j--;
				}	
				
				//현재행의 마지막 지점에서 행과열의 문자가 다르면 위의 행으로 이동하여 행과열의 문자가 같을 때 해당 문자 저장
				if(A.charAt(i-1) != B.charAt(j-1)) {
					i--;
				}else {
					answer = A.charAt(i-1) + answer;
					i--;
					j--;
				}
		}
		return answer;
	}
}

