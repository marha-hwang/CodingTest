package Q40_49;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q43 {

	static long r = 1;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		gcd(a,b);

		while(r>0) {
			out.write("1");
			r--;
		}
		out.flush();
		out.close();
		
	}

	public static void gcd(long a, long b) {
		if(a%b==0) {
			r = b;
			return;
		}
		gcd(b, a%b);		
	}
}
