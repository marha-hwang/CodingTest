package Implementation;

import java.util.*;
import java.io.*;
public class Q2578 {
	//구현 문제: 작성해야 할 코드의 양이 많다보니 예외 케이스와 반례찾기가 힘들었다
	//어떻게 좀 더 잘 할 수 있는 방법이 있을까?
	
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[5][5];
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j= 0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<5; j++) {
				int now = Integer.parseInt(st.nextToken());
				int[] point = change(now);
				
				result += check(point[0], point[1]);
				if(result >= 3) {
					System.out.print(i*5 + (j+1));
					return;
				}
				
				
			}
		}
	}
	//숫자가 불린지점 골라낸 후 -1로 변경
	static int[] change(int now) {
		for(int i = 0; i<5; i++) {
			for(int j= 0; j<5; j++) {
				if(arr[i][j] == now) {
					arr[i][j] = -1;
					int[] result = {i,j};
					return result;
				}
			}
		}
		return null;
	}
	
	//숫자가 불린 지점을 중심으로 빙고여부 체크하는 함수
	static int check(int a, int b) {
		int result = 0;
		
		int count = 0;
		for(int i = 0; i<5; i++) {
			if(arr[a][i] == -1) count += 1; 
		}
		if(count == 5) result += 1;
		
		count = 0;
		for(int i = 0; i<5; i++) {
			if(arr[i][b] == -1) count += 1; 
		}
		if(count == 5) result += 1;
		
		if(a == b || a+b == 4) {
			count = 0;
			for(int i = 0; i<5; i++) {
				if(arr[i][i] == -1) count += 1; 
			}
			if(count == 5) result += 1;
			
			count = 0;
			for(int i = 0; i<5; i++) {
				if(arr[i][4-i] == -1) count += 1; 
			}
			if(count == 5) result += 1;
		}
		return result;
	}
}















