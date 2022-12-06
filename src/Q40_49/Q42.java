package Q40_49;

import java.util.Scanner;

public class Q42 {

	static int r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 1;
		
		int a = sc.nextInt();
		int b = sc.nextInt();

		gcd(a,b);
		result = a/r * b/r * r;
		
		System.out.print(result);
	}
	
	public static void gcd(int a, int b) {
		if(a%b == 0) {
			r=b;
			return;
		}
		
		gcd(b,a%b);
	}
	

}
