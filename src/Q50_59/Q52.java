package Q50_59;
import java.util.*;
import java.io.*;
public class Q52 {
	
	
	// 파티마다 사람들의 연결을 초기화 하는 것이 아닌 사람들의 연결을 유지하면서 파티들의 정보를 연결해야함
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int people = Integer.parseInt(st.nextToken());
		int party = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int truep = Integer.parseInt(st.nextToken());
		int[] trueparr = new int[truep];
		int[] initarr = new int[party];
		
		for(int i=0; i<truep; i++) { //진실을 아는 사람들 저장
			trueparr[i] = Integer.parseInt(st.nextToken());
		}
	
		arr = new int[people+1];
		for(int j = 1; j<=people; j++) { //대표노드배열 초기화
			arr[j] = j;
		}
		
		for(int i = 0; i<party; i++) { //파티수만큼 반복하여 사람연결
			st = new StringTokenizer(in.readLine());
			int visit = Integer.parseInt(st.nextToken());
			int initp = Integer.parseInt(st.nextToken());
			for(int j=1; j<visit; j++) {
				int afterp = Integer.parseInt(st.nextToken());
				union(initp, afterp);
				initp = afterp;
			}
			initarr[i] = initp;
			
		}
		int count = 0;
		for(int i = 0; i<party; i++) {
			boolean tf = true;		
			for(int j = 0; j<truep; j++) {
				if(find(initarr[i]) == find(trueparr[j])){
					tf = false;
					break;
				}				
			}
			if(tf) count ++;
		}
		
		System.out.print(count);
		
	}
	
	public static void union(int a, int b) {
		if(find(a) != find(b)) {
			arr[find(b)] = find(a);
		}
	}
	
	public static int find(int n) {
		if(arr[n] == n) {
			return n;
		}
		else {
			int result = find(arr[n]);
			arr[n] = result;
			return result;
		}
	}
}
















