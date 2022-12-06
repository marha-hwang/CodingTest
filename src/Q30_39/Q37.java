package Q30_39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q37 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();	
		LinkedList<Integer> arr = new LinkedList<Integer>();
		
		for(int i= 2; i<=n; i++) {
			arr.add(i);
		}
		
		int i = 0;
		int min;
		while(arr.get(i) <= Math.sqrt(n)) {
			min = arr.get(i);
			for(int j=i+1; j<arr.size(); j++) {
				if(arr.get(j)%min ==0) {
					arr.remove(j);
				}
			}
			i++;
		}
		
		for(int j=0; j<arr.size(); j++) {
			if(arr.get(j)>=m) {
				System.out.println(arr.get(j));
			}
		}
	}

}
