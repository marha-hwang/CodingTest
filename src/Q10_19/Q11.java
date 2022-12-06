package Q10_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
//문제 분석: 오름차순 스택을 이용하여 주어진 순열을 출력


public class Q11 {
	public static void main(String args[]) throws Exception{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int count = Integer.parseInt(in.readLine());
	
	int[] arr = new int[count];
	StringTokenizer st = new StringTokenizer(in.readLine());
	for(int j = 0; j<count; j++) {
		arr[j] = Integer.parseInt(st.nextToken());
	}
	
	Stack<Integer> stack = new Stack<>();
	int n = 1;
	StringBuffer bf = new StringBuffer();
	boolean result = true;
	for(int i = 0; i < count; i++) {
		if(arr[i]>=n) {
			while(arr[i]>=n) {
				stack.push(n);
				n++;
				bf.append("+ ");
			}
			stack.pop();
			bf.append("- ");
		}else {
			if(stack.isEmpty() == false) {
				while(stack.peek()!= arr[i] ) {
					stack.pop();
					bf.append("- ");
					if(stack.peek() < arr[i]) {
						result = false;
						System.out.println("NO");
						break;
					}
				}
				stack.pop();
				bf.append("- ");
			}else {result = false; System.out.println("NO"); break;}
		}
	}
	if(result) System.out.println(bf.toString());
}
}
	
	/*
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * int n = sc.nextInt(); int[] arr = new int[n];
	 * 
	 * for(int i = 0; i<n; i++) { arr[i] = sc.nextInt(); } Stack<Integer> stack =
	 * new Stack<>(); StringBuffer bf = new StringBuffer(); boolean result = true;
	 * int num = 1;
	 * 
	 * for(int i = 0; i<n; i++) { if(arr[i]>= num) { while(arr[i]>=num) {
	 * stack.push(num); num ++; bf.append("+ "); } stack.pop(); bf.append("- "); }
	 * else { int top = stack.pop(); if(top>arr[i]) { System.out.println("NO");
	 * result = false; } else { bf.append("- "); } } }
	 * 
	 * if(result) System.out.println(bf.toString()); }
	 */


