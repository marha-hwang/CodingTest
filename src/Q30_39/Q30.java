package Q30_39;
import java.util.*;
import java.io.*;

public class Q30 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int lesson = Integer.parseInt(st.nextToken());
		int bluelay = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[lesson];
		int max = 0;
		int sum = 0;
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<lesson; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum = sum + arr[i];
			if(max<arr[i]) max = arr[i];
		}
		
		int start = max;
		int end = sum;
		
		while(start<=end) { //start<end가 아닌 start<=end를 해야하는 이유 생각해보기!!!!!
			// ----> start==end인 경우에 m의 값을 계산하지 않기 때문에 start<end이면 모든 범위를 탐색하지 못한다. 
			//start<=end 인 경우에만 모든 범위를 탐색할 수 있다.
			int m = (start + end)/2;
			int psum = 0;
			int count = 0;
			for(int i=0; i<lesson; i++) {
				if(psum + arr[i]>m) {
					count++;
					psum = 0;
				}
				psum = psum + arr[i];
			}
			if(psum != 0) count++;
			
			if(count > bluelay) {
				start = m+1;
			}else {
				end = m-1;
			}		
		}
		System.out.println(start);
	
		

	}

}
