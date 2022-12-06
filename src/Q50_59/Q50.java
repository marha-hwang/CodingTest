package Q50_59;
import java.util.*;
import java.io.*;

public class Q50{

	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		arr = new int[node+1];
		for(int i =0; i<=node; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<input; i++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command.equals("0")) {
				union(a,b);
			}else if(command.equals("1")) {
				int ca = find(a);
				int cb = find(b);
				if(ca == cb) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
		

	}
	//대표노드를 int형으로 리턴하게 하기
	public static int find(int n) {
		if(arr[n] == n) {
			return n;
		}
		else {
			return arr[n] = find(arr[n]);
		}
	}
	
	public static void union(int a, int b) {
		int ca = find(a);
		int cb = find(b);
		if(ca != cb) {
			arr[cb] = ca;
		}
	}
	
}








