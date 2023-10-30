package Play;

import java.util.*;
import java.io.*;

public class Q2018 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		int l=1,r=0;
		
		//while문? 끝이 정해지지 않은 반복을 하기위한 문법
		//while문에서 i의 마지막 값을 예측하기 힘들었음 
		//원인: 종료조건은 sum이 n을 넘지 않는지점까지 반복하는 것이었는데 while문 마지막에 i++를 함으로써 
		//	   종료조건을 만족할 때 i의 값이 차이가 나버려서 코드 작성이 어려웠다.
		//	   명확한 종료조건이 있는 경우는 헷갈리지 않지만, 작을수도 같을수도 있는 불명확한 상황에서는 헷갈림
		int sum=0;
		int i = 0;
		//해당 조건을 만족하는 i의 마지막 지점을 구하기 위한 코드
		//n을 만족할때 종료하면 n을 만족하고 한단계를 더 진행하므로
		//n을 만족하기 한단계 전까지 작업을 수행한다.
		while(sum < n) {
			i++;
			sum += i; 
		}
		r = i;
		
		int result = 0;
		while(l <= n) {
			if(sum > n) {
				sum-=l;
			}
			else if(sum == n) {
				result++;
				sum-=l;
				sum += ++r;
			}
			else if(sum < n) {
				sum-=l;
				sum += ++r;
			}
			
			l++;
		}

		
		System.out.print(result);
		
	}

}

