package Q20_29;
import java.util.Scanner;
import java.lang.*;

public class Q24 {
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
		
	}

	public static void DFS(int num, int jarisu) {
		boolean sosu = true;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				sosu = false;
			}
		}
		
		if(jarisu == n) {
			if(sosu) {
				System.out.println(num);
			}
		return;
		}
		
		if(sosu == false)return;
		
		for(int i=1; i<=9; i++) {
			if(i%2 != 0) DFS(num*10 + i ,jarisu+1);
		}
		
	}
}
