package Q70_79;
import java.util.*;
import java.io.*;

public class Q70 {

	//핵심아이디어 - 2차원배열 또는 리스트를 이용한 자료구조를 사용하고 DFS탐색의 순서를 조절하여 탐색한다.
	//탐색의 순서를 조절하는법? 재귀함수 구현법을 다시 생각해본다. 루트부터 생각하는 것이 아니 베이스라인부터 거슬러 올라간다.
	static int[][] arr; 
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[26][2];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			
			int node = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left != '.') arr[node][0] = left - 'A';
			else arr[node][0] = -1;
			
			if(right != '.') arr[node][1] = right - 'A';	
			else arr[node][1] = -1;
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		
	}
	
	public static void preOrder(int root) {
		if(root == -1 ) {
			return;
		}
		System.out.print((char)(root + 'A'));
		preOrder(arr[root][0]);
		preOrder(arr[root][1]);
	}
	
	public static void inOrder(int root) {
		if(root == -1 ) {
			return;
		}
		inOrder(arr[root][0]);
		System.out.print((char)(root + 'A'));
		inOrder(arr[root][1]);
	}
	
	public static void postOrder(int root) {
		if(root == -1 ) {
			return;
		}
		postOrder(arr[root][0]);
		postOrder(arr[root][1]);
		System.out.print((char)(root + 'A'));
	}

}
