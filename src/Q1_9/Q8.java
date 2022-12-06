package Q1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0; //조건을 만족하는 개수
		StringTokenizer st = new StringTokenizer(in.readLine());
		int count = Integer.parseInt(st.nextToken()); //숫자의 개수
		
		
		st = new StringTokenizer(in.readLine());
		int[] array = new int[count +1];
		for(int i=1; i<=count; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		
		for(int i=count; i>1; i--) {
			int start = 1;
			int end = i-1;
			int sum = array[start]+array[end];
			while(start != end) {
				if(sum > array[i]) {
					end --;
					sum = array[start] + array[end];
				}else if(sum < array[i]) {
					start ++;
					sum = array[start] + array[end];
				}else if(sum == array[i]) {
					result ++;
					break;
				}
			}
		}
		
		
		System.out.println(result);

	}

}
