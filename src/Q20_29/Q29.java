package Q20_29;
import java.util.*;
import java.io.*;

public class Q29 {
	static int[] find;
	static int[] data;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int data_n = Integer.parseInt(st.nextToken());
		data = new int[data_n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<data_n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		
		int find_n = Integer.parseInt(st.nextToken());
		find = new int[find_n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<find_n; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		
		for(int i: find) {
			Binary(i);
		}
		
		

	}
	
	static void Binary(int n) {
		int start = 0;
		int end = data.length-1;
		int m = (start+end)/2;
		
		while(start>=0 && end<data.length) {
			if(n>data[m]) {
				start = m+1;
				m = (start+end)/2;
			}else if(n<data[m]) {
				end = m-1;
				m = (start+end)/2;
			}else if(n == data[m]){
				System.out.println(1);
				return;
			}
			
			if(start == end) {
				if(n == data[m]) {
					System.out.println(1);
					return;
				}
				System.out.println(0);
				return;
			}
		}
	}
}
