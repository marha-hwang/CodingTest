package Q30_39;

import java.util.ArrayList;
import java.util.Scanner;

public class Q38 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		long b = sc.nextLong();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=2; i<=Math.sqrt(b);i++) { //거의 소수는 2제곱이상이기 때문에 소수는 제곱근이하이어야함
			arr.add(i);
		}
		
		int now =0;
		int min;
		while(arr.get(now)<= Math.sqrt(Math.sqrt(b))) { //정수의 소수는 해당정수의 제곱근이하기 때문에 제곱근을 한번더해줌
			min = arr.get(now);
			for(int i=now+1; i<arr.size(); i++) {
				if(arr.get(i)%min == 0) {
					arr.remove(i);
				}
			}
			now++;
		}
		
		int count = 0;
		
		for(int i=0; i<arr.size(); i++) {
			int sum = arr.get(i);
			while(sum<=b) {
				sum *= arr.get(i);
				if(sum>=a && sum<=b) {
					count ++;
				}
				else break;
			}
		}
		System.out.print(count);
	}

}
