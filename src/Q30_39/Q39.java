package Q30_39;

import java.util.ArrayList;
import java.util.Scanner;

public class Q39 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> sosuarr = new ArrayList<Integer>(); 
		int min = 2;
		int max = 1000000;
		
		while(true) {
			for(int i=min; i<=max; i++) {
				sosuarr.add(i);
			}		
			int pointer = 0;
			while(sosuarr.get(pointer)<= Math.sqrt(max)) {  //범위 안에서 소수구하기
				for(int i=pointer+1; i<sosuarr.size(); i++) {
					if(sosuarr.get(i)%sosuarr.get(pointer) == 0) {
						sosuarr.remove(i);
					}
				}
				pointer++;
			}
			for(int i=0; i<sosuarr.size(); i++) {//팰린드롬 수가 존재하는지 확인
				String str = Integer.toString(sosuarr.get(i));
				StringBuffer sb = new StringBuffer(str);
				String reverse = sb.reverse().toString();
								
				if(sosuarr.get(i)>= n && reverse.equals(Integer.toString(sosuarr.get(i)))) {
					System.out.print(sosuarr.get(i));
					return;
				}
			}
			min = max+1;
			max+=1000000;
		}
	}

}
