package Q30_39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q34 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pt1 = new PriorityQueue<Integer>((o1,o2)->{
			return o1<=o2?1:-1;
		});
		PriorityQueue<Integer> pt2 = new PriorityQueue<Integer>((o1,o2)->{
			return o1>=o2?1:-1;
		});
		
		int one = 0;
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int su = Integer.parseInt(st.nextToken());
			if(su>1) {
				pt1.add(su);
			}else if(su==1) { //1+1은 2지만 1*1은 1이기 때문에 1은 따로 세준다.
				one++;
			}
			else {
				pt2.add(su);
			}
		}
		
		int sum = 0;
		while(pt1.size()>1) {
			int a = pt1.poll();
			int b = pt1.poll();
			sum += a*b;
		}
		sum += one;
		
		while(pt2.size()>1) {
			int a = pt2.poll();
			int b = pt2.poll();
			sum += a*b;
		}
		
		if(pt1.size()==0 && pt2.size() == 1) {
			sum += pt2.poll();
		}else if(pt1.size()==1 && pt2.size() == 0) {
			sum += pt1.poll();
		}
		
		System.out.print(sum);
	}

}
