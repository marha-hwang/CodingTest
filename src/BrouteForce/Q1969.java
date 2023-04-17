package BrouteForce;
import java.util.*;
import java.io.*;

public class Q1969 {
	static int[] min_distance;
	static String result = "";
	static int n,m;
	static char[] arg = {'A', 'C', 'G', 'T'};
	static String[] dnas;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		min_distance = new int[m];
		Arrays.fill(min_distance, Integer.MAX_VALUE);
		
		dnas = new String[n];
		for(int i = 0; i<n; i++) {
			dnas[i] = in.readLine();
		}
		
		for(int i = 0; i<4; i++) {
			DFS(0, String.valueOf(arg[i]) );
		}
		
		System.out.println(result);
		System.out.println(min_distance[m-1]);
	}

	static void DFS(int distance, String dna) {
		int diff = 0;
		//반복문 : 추가한 자리의 문자와 주어진 DNA의 각 자리와 비교하기, 다른 경우 +1
		for(int j = 0; j<n; j++) {
			if(dna.charAt(dna.length()-1) != dnas[j].charAt(dna.length()-1)) diff++;
		}
		
		distance += diff;
		
		//종료조건 : 현재 distance가 min_distance 보다 크거나 같은 경우 종료
		if(min_distance[dna.length()-1] <= distance)return;
		else min_distance[dna.length()-1] = distance;
		
		//종료조건 : 문자열이 모두 채워진 경우
		if(dna.length() == m) {
			if(distance == min_distance[m-1]) {
				result = dna;
				return;
			}else return;
		}
		
		
		//재귀함수 실행 : ACTG를 문자열에 추가
		for(int i = 0; i<4; i++) {
			DFS(distance, dna+arg[i]);
		}
		
		
	}
}
 