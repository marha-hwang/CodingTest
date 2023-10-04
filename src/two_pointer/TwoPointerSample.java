package two_pointer;

import java.util.*;
import java.io.*;

public class TwoPointerSample {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] a1 = new int[n];
		int[] a2 = new int[m];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			a1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<m; i++) {
			a2[i] = Integer.parseInt(st.nextToken());
		}
		
		int p1 = 0;
		int p2 = 0;
		
		int[] result = new int[n+m];
		int i = 0;
		while(p1 < n && p2 < m) {
			if(a1[p1] < a2[p2]) {
				result[i] = a1[p1];
				p1++;
			}
			else {
				result[i] = a2[p2];
				p2++;
			}
			i++;
		}
		
		while(p1 < n) {
			result[i] = a1[p1];
			p1++;
			i++;	
		}
		
		while(p2 < m) {
			result[i] = a2[p2];
			p2++;
			i++;
		}
		
		for(int k = 0; k<n+m; k++) {
			out.write(result[k] + " " );
		}
		
		out.flush();
		out.close();

	}

}












