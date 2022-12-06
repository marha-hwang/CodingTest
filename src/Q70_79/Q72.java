package Q70_79;
import java.io.*;
import java.util.*;
public class Q72 {

	static long[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//세그먼트 트리인덱스 계산
		int seg = 2;
		while(seg<N) seg *= 2;
		
		//세그먼트 초기화
		arr = new long[seg*2];
		for(int i = seg; i<seg + N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		setTree(seg-1 + N);
		
		//최솟값 탐색
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			System.out.println(getMin(seg-1 + s, seg-1 +e));
		}
		
	}
	
	public static void setTree(int i) {
		while(i > 1) {
			if(i % 2 == 0) {
				if(arr[i/2] > arr[i]) arr[i/2] = arr[i];
			}
			else if(i % 2 == 1) arr[i/2] = arr[i];
			
			i--;
		}
	}
	
	public static long getMin(int s, int e) {
		long min = Long.MAX_VALUE;
				
		while(s <= e) {
			if(s % 2 == 1) {
				if(min > arr[s]) min = arr[s];
				s++;
			}
			if(e % 2 == 0) {
				if(min > arr[e]) min = arr[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return min;
	}

}





