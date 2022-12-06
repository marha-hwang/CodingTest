package Q30_39;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q32 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		
		//우선순위 큐를 사용하여 구현
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<n; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		while(queue.size() != 1) {
			int a = queue.poll();
			int b = queue.poll();
			sum = sum + a + b;
			queue.add(a + b);
		}
		System.out.print(sum);
		
		//합쳐진 카드뭉치 역시 카드뭉치 이기 때문에 아래방식으로 구현하면 가장 작은 카드뭉치끼리 합쳐야
		//최소가 나온다는 규칙에 위배된다.
		//우선순위 큐를 사용하지 않고 틀린구현
//		int[] arr = new int[n];
//		for(int i = 0; i< n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(arr);
//		int sum = 0;
//		if(arr.length == 1) {
//			System.out.print(sum);
//		}else if(arr.length>=2) {
//			sum = arr[0]+arr[1];
//			for(int i= 2; i<n; i++) {
//				sum = sum + sum + arr[i];
//			}
//			System.out.print(sum);
//		}
	}

}
