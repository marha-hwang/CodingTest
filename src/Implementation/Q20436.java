package Implementation;

import java.util.*;
import java.io.*;
public class Q20436 {
	//자판을 모음, 자음둘로분리하여 배열에 저장하기
	static char[][] jaum = {{'q', 'w', 'e', 'r', 't'}, {'a', 's', 'd', 'f', 'g' },{'z', 'x', 'c', 'v'}};
	static char[][] moum = {{' ', 'y', 'u', 'i', 'o', 'p'}, {' ', 'h', 'j', 'k', 'l' },{'b', 'n', 'm'}};;
	static int[] left;
	static int[] right;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//왼손의 자판위치 얻어오기, 오른손의 자판위치 얻어오기
		left = findKey(st.nextToken().charAt(0));
		right = findKey(st.nextToken().charAt(0));
		
		String input = in.readLine();
		int result = 0;
		for(int i = 0; i<input.length(); i++) {
			int[] find = findKey(input.charAt(i));			
			result += moveKey(find);
		}
		System.out.print(result);
	}
	//현재문자의 위치 얻어오기
	static int moveKey(int[] find) {
		int result = 0;
		if(find[0] == 0) {
			int moveTime = Math.abs(left[1] - find[1]) + Math.abs(left[2] - find[2]);
			result = moveTime+1; // 키를 누르는 시간까지 포함
			//이동시간 계산후에 손가락 위치 변경
			left[1] = find[1];
			left[2] = find[2];
		}
		else if(find[0] == 1) {
			int moveTime = Math.abs(right[1] - find[1]) + Math.abs(right[2] - find[2]);
			result = moveTime+1; // 키를 누르는 시간까지 포함
			right[1] = find[1];
			right[2] = find[2];
		}
		return result;
	}
	//현재문자의 모음,자음여부에 따라 이동시간 계산
	static int[] findKey(char c) {
		int[] result = new int[3];
		for(int i = 0; i<jaum.length; i++) {
			for(int j = 0; j<jaum[i].length; j++) {
				if(jaum[i][j] == c) {
					result[0] = 0; result[1] = i; result[2] = j;
					return result;
				}
			}
		}
		
		for(int i = 0; i<moum.length; i++) {
			for(int j = 0; j<moum[i].length; j++) {
				if(moum[i][j] == c) {
					result[0] = 1; result[1] = i; result[2] = j;
					return result;
				}
			}
		}
		return result;
	}

}

