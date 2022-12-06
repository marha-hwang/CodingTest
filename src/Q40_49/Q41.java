package Q40_49;

import java.util.Scanner;

public class Q41 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<=n; i++) {
			if(arr[i]== i) {
				for(int j= i; j<=n; j=j+i) {
					arr[j] = arr[j] - arr[j]/i;
				}
			}
		}
		System.out.print(arr[n]);
	}

}
