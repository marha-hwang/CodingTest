package Q70_79;

import java.util.*;
import java.io.*;
public class Q73 {

	static long[] arr;
	//수의 개수는 백만, 정수의 범위는 백만 까지이다. 따라서 최악의 경우에는 long의 범위도 넘어서기 때문에
	//곱셈연산을 수행할 때 마다 MOD로 나눠주는 코드를 추가한다.
	static int MOD = 1000000007;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
	//세그먼트트리 초기화
		//트리 배열 크기 seg구하기
		int seg = 2;
		//seg의 크기가 N보다 작은경우에만 while실행
		while(seg < N) seg *=2;
		
		//주어진 데이터 채워넣기
		arr = new long[seg*2]; //만약 데이터의 개수가 8인경우 인덱스 15까지 필요
		//포화이진 트리 이므로 데이터를 채운후 비어있는 리프노드 존재, 비어있는 노드는 1로 채우기
		for(int i = seg; i<=seg-1 + N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		//비어있는 노드는 1로 채우기
		for(int i = seg + N; i<seg*2; i++) {
			arr[i] = 1;
		}		
			//setTree함수 실행
		setTree(seg*2 - 1); // 트리의 마지막 부터 루트 까지 계산하며 트리 채우기, 마지막인덱스 필요
		
	//질의및 변경연산 수행
		for(int i = 0; i< M + K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
		//만약 1이면 변경연산
		//changeVal함수
			if(a == 1) {
				changeVal(seg-1 +b, c);
			}
		
		//만약 2면 구간곱연산
		//getMuti
			if(a == 2) {
				System.out.println(getMuti(seg-1+ b,seg-1+ c));
			}
		}
	}
	
	public static void setTree(int i) {
		//i를 감소시켜가면서 부모노드를 수정
		while(i>1) {
			arr[i/2] = (arr[i] * arr[i-1]) % MOD;
			//i값을 감소시켜 가면서 반복
			i -=2;
		}
	}
	
	public static void changeVal(int a, int val) {
		//노드의 값을 주어진 값으로 변경
		arr[a] = val;
		//부모노드까지 거슬러 올라가면서 계산
		while(a > 1) {
			//현재노드의 값을 수정
			if(a%2 == 1 ) {
				arr[a/2] = (arr[a]% MOD) * (arr[a-1] % MOD) % MOD;
			}else if(a%2 == 0) {
				arr[a/2] = (arr[a] % MOD) * (arr[a+1] % MOD) % MOD;
			}
			//부모노드로 이동
			a /=2;
		}
	}

	public static long getMuti(int s, int e) {
		long muti = 1;
		
		//s값이 e값보다 커지기 전까지 반복
		while( s <= e) {
			if(s % 2 == 1) {
				muti = (muti * arr[s]) % MOD;
				s ++;
			}
			if(e % 2 == 0) {
				muti = (muti * arr[e]) % MOD;
				e --;
			}
			s /=2;
			e /=2;
		}
		
		return muti;
	}
}







