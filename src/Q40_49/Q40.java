package Q40_49;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q40 {

	public static void main(String[] args) throws Exception{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int min = Integer.parseInt(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		int gaesu = (int) Math.sqrt(max);
		int[] sosu =new int[gaesu+1];
				
		for(int i = 2; i<=gaesu; i++) {
			sosu[i] = i;
		}
		
		for(int i=2; i<=Math.sqrt(gaesu); i++) {
			if(sosu[i]!=0) {
				//반복문의 증가를 조절하여 반복횟수를 줄인다.
				for(int j = i+i; j<= gaesu; j=j+i) {  
						sosu[j] = 0;
					}
				}
		}
		
		//max의 최대범위가 1조이기 때문에 반복문을 max까지 돌려서 제곱인수를 카운트 하는 방식은 시간복잡도를 초과함
		//따라서 수정필요
		int count = 0;
		for(int i = 2; i<= gaesu; i++) {
			int multi = sosu[i];
			while(sosu[i] != 0 && multi < max) {
				multi *= sosu[i];
				if(multi>min && multi<max) {
					count ++;
				}
			}
		}
		System.out.print(max-count);
	}

}
