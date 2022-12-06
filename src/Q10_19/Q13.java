package Q10_19;
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		while(queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
		
		
		
	}

}
