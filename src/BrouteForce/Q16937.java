package BrouteForce;
import java.util.*;
import java.io.*;
public class Q16937 {
	static int h, w, result=0;
	public static void main(String[] args) throws IOException {
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(in.readLine());
		
		int[] r = new int[n];
		int[] c = new int[n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		//이중반복문을 이용하여 모든 조합에 대한 반복
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				//해당 조합에 대하여 모눈종이 안에 들어가는지 확인
				insert(r[i], c[i], r[j], c[j]);
				insert(r[i], c[i], c[j], r[j]);
				insert(c[i], r[i], r[j], c[j]);
				insert(c[i], r[i], c[j], r[j]);
			}
		}
		
		System.out.print(result);
		
	}
	public static void insert(int ar, int ac, int br, int bc) {
		int nH=0, nW=0;
		if(ar <= h && ac <= w) {
			nH = h-ar;
			nW = w-ac;
		}
		else return;
		
		if((br <= nH && bc <= w) || (br <= h && bc <= nW)) {
			result = Math.max(ar*ac + br*bc, result);
		}
	}

}
