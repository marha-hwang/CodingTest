package Q1_9;
import java.util.*;
import java.io.*;

public class Page60 {
	public static void main(String args[]) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0; //조건을 만족하는 개수
		StringTokenizer st = new StringTokenizer(in.readLine());
		int count = Integer.parseInt(st.nextToken()); //숫자의 개수
		
		st = new StringTokenizer(in.readLine());
		int sum = Integer.parseInt(st.nextToken());//두개의 숫자가 만들어야 하는값
		
		st = new StringTokenizer(in.readLine());
		int[] array = new int[count +1];
		for(int i=1; i<=count; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i= 1; i<count; i++) {
			for(int j = i+1; j<=count; j++) {
				if(array[i]+array[j] == sum) result +=1;
				}
			}
		System.out.println(result);
		
		}
		
	}
