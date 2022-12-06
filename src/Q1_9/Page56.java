package Q1_9;
import java.util.*;
import java.io.*;

public class Page56 {
	/*
	 * public static void main(String[] args) throws Exception { BufferedReader in =
	 * new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st =
	 * new StringTokenizer(in.readLine()); int n = Integer.parseInt(st.nextToken());
	 * int sum = 0; int count = 0; int k=0;
	 * 
	 * 
	 * for(int i=1; i<=n; i++){ while(sum<=n){ sum+=i+k; k++; if(sum == n) count+=1;
	 * } sum = 0; k = 0; } System.out.println(count); }
	 */
	
	public static void main(String args[]) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int start = 1;
		int end = 1;
		int sum =1;
		int n = Integer.parseInt(st.nextToken());
		int count = 1;
		
		while((start != n) && (end != n)) {
			if(sum<n) {
				end ++;
				sum+=end;
			}else if(sum==n){
				count ++;
				end ++;
				sum += end;
			}else if(sum>n){
				sum = sum - start;
				start ++;
			}
		}
		System.out.println(count);
	}

}
