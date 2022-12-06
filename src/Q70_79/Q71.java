package Q70_79;
import java.util.*;
import java.io.*;

public class Q71 {

	static long[] arr;
	public static void main(String[] args) throws Exception{
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		//세그먼트 트리 초기화
		//트리배열 개수 알아내기
		int n = 2;
		while(n<=node) { n *= 2; }
		
		//트리 생성후 리프노드 초기화
		//리프노드 초기화
		arr = new long[n*2+1];
		//시작인덱스 구하기
		for(int i = n; i<=n-1+node; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i] = Long.parseLong(st.nextToken());
		}
		//부모노드 초기화
		setTree(n-1+node);
		
		for(int i = 0; i<query; i++) {
			//입력받기
			st = new StringTokenizer(in.readLine());
			char command = st.nextToken().charAt(0);
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			//세그먼트트리 수정(1연산)
			if(command == '1') {
				changeVal(n-1+a, b);
			}else if(command == '2') {
				//세그먼트트리를 이용한 구간합구하기(2연산)
				
				System.out.println(getSum(n-1+a, n-1+b));
			}
		}
	}
	
	public static void setTree(int i) {
		while(i!=1) {
			arr[i/2] = arr[i] + arr[i/2];
			i--;
		}
	}
	
	public static void changeVal(long a, long val) {
		long diff = val - arr[(int)a];
		while(a > 0) {
			arr[(int)a] += diff;
			a /= 2;
		}
	}
	
	public static long getSum(long start, long end) {
		long sum = 0;
		while(start<=end) {
			if(start%2 == 1) {
				sum += arr[(int)start];
				start ++;
			}
			if(end%2 == 0) {
				sum += arr[(int)end];
				end --;
			}
			start /= 2;
			end /= 2;
		}
		return sum; 
	}

}





