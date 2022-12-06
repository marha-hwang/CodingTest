package Q1_9;
import java.util.*;
import java.io.*;

public class Q9 {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int wlen = Integer.parseInt(st.nextToken());
		int plen = Integer.parseInt(st.nextToken());
		
		String word = in.readLine();
		
		st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int a =0;
		int c=0;
		int t = 0;
		int g = 0;
		int result = 0;
		for(int i = 0; i<plen; i++) {
			switch(word.charAt(i)) {
			case('A'): a++; break;
			case('C'): c++; break;
			case('T'): t++; break;
			case('G'): g++; break;
			}
		}
		if(a == A && c==C && g==G&& t==T) {
			result ++;
		}
		
		for(int i=plen; i<wlen; i++) {
			switch(word.charAt(i)) {
			case('A'): a++; break;
			case('C'): c++; break;
			case('T'): t++; break;
			case('G'): g++; break;
			}
			switch(word.charAt(i-plen)) {
			case('A'): a--; break;
			case('C'): c--; break;
			case('T'): t--; break;
			case('G'): g--; break;
			}
			if(a == A && c==C && g==G&& t==T) {
				result ++;
			}
			
		}
		System.out.println(result);
	}
}

