package BinarySearch;

import java.io.*;
import java.util.*;

public class BinarySearchSample {
	static long s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		s = Long.valueOf(in.readLine());
		
		//여러가지 경우의 수를 만들어 머리 복잡하게 하는 원인을 찾고 제거할 수 있으면 제거하기!!!!!!!! 
		//-> R-1을 굳이 할 필요 없었음!!
		
		//이분탐색에서 헷갈리는 포인트: mid가 정답인 조건에 일치하는 경우 
		//--> 정답일 가능성이 존재하는 요소와, 정답인 요소를 구별하여 생각해야 한다.
		
		//진짜 정답인지 확실하게 하기 위해 일단 L 포인터를 mid에 옮겨놓고 계속 탐색을 진행한다.
		//정답일 가능성이 없다면 R포인터를 mid에 옮겨놔 가능성이 없는 부분을 더 이상 탐색하지 않는다.
		
		//최종적으로 L과 R은 한칸 차이로 탐색이 멈춘다
		//-- > L과 R의 중간을 반복하여 찾으므로 중간이 1칸 남아있는 경우 이후 L과 R이 인접하게 되고
		//		인접한 상황에서 중간위치는 L로 계속 반복되기 때문이다.
		
		//구현팁 : 요소를 판별하는 과정을 매번 생각하면 머리 아프니까 check함수를 만들어 사용하기
		
		//탐색범위 설정 주의하기!!
		long l = 0;
		long r = 1000000;
		
		while(l + 1 != r) {
			long mid = (l+r)/2;
			if(check(mid)) l = mid;
			else r = mid; 
		}	
		
		//R이 이동했다면 답은 무조건 L이지만 R이 이동하지 않는 경우 답이 L임을 확신할 수 없다.
		//이제 정답은 L과R위치중 하나이기 때문에 둘중 하나를 선택한다.
		if(check(r)) System.out.print(r+1);
		 System.out.print(l+1);
	}
	
	static boolean check(long mid) {
		if(mid*(mid+1)/2 + mid < s) return true;
		else return false;
	}
}

