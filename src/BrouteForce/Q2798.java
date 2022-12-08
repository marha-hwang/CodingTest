package BrouteForce;
import java.util.*;
import java.io.*;

public class Q2798 {

	public static void main(String[] args) throws Exception{
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//삼중 반복문으로 모든 조건 탐색
		int answer=0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					if(i != j && i != k && j != k) {
						//조건을 만족하면 answer의 값을 업데이트
						if(arr[i]+arr[j]+arr[k] <= M && answer < arr[i]+arr[j]+arr[k]) {
							answer = arr[i]+arr[j]+arr[k];
						}
					}
				}
			}
		}
		System.out.print(answer);

	}

}
