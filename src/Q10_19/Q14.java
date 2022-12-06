package Q10_19;
import java.util.*;
import java.io.*;

public class Q14 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs) return o1>o2? 1: -1;
			else return first_abs - second_abs;
		});
		
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=n; i++) {
			int x = sc.nextInt();
			if(x==0) {
				if(!queue.isEmpty()) {
					System.out.println(queue.poll());
				}else System.out.println("0");
			}else {
				queue.add(x);
			}
		}
		
	}
}