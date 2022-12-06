package Q60_69;
import java.util.*;
import java.io.*;

public class Q66 {

	
	//아스키 코드 
	// 대문자 A 65
	// 소문자 a 97
	// 0 48
	static int[] pnode;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int computer = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Cable> que = new PriorityQueue<Cable>();
		int total = 0;
		
		for(int i = 1; i<=computer; i++) {
			st = new StringTokenizer(in.readLine());
			String s = st.nextToken();
			for(int j = 1; j<= computer; j++) {
				int n = (int)s.charAt(j-1);
				
				if( n < 97 && n!=48) { //대문자인 경우
					n = n - 64+26;
				}else if( n > 96){ //소문자인 경우
					n = n - 96;
				} else if(n == 48) { // 0인경우
					n = 0;
				}
				if(n != 0) {
					que.add(new Cable(i, j, n)); 
					total += n;
				}
			}
		}
		
		pnode = new int[computer+1];
		for(int i = 1; i<=computer; i++) {
			pnode[i] = i;
		}
		
		int need = 0;
		int con = 0;
		while(!que.isEmpty()) {
			if(con == computer -1) {
				break;
			}
			Cable now = que.poll();
			if( find(now.s)!= find(now.e) ) {
				union(now.s,now.e);
				con ++;
				need += now.value;
			}
		}
		
		if(con != computer-1) System.out.print(-1);
		else System.out.print(total - need);

	}
	
	public static void union(int a, int b) {
		if(find(a) != find(b)) {
			pnode[find(b)] = find(a);
		}
	}
	
	public static int find(int a) {
		if(pnode[a] == a) {
			return a;
		}else {
			int result = find(pnode[a]);
			pnode[a] = result;
			return result;
		}
		
	}

}

class Cable implements Comparable<Cable>{
	int s, e, value;
	public Cable(int s, int e, int value) {
		this.s = s;
		this.e = e;
		this.value = value;
	}
	
	public int compareTo(Cable o) {
		return this.value > o.value ? 1:-1;
	}
}
