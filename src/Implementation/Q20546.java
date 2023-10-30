package Implementation;

import java.util.*;
import java.io.*;
public class Q20546 {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int i = 0;
		arr = new int[1001];
		while(st.hasMoreElements()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		int bnp = BNP(money, i-1);
		int timing = Timing(money, i-1);
		
		if(bnp > timing) System.out.print("BNP");
		else if(bnp < timing)System.out.print("TIMING");
		else System.out.print("SAMESAME");
	}
	
	static int BNP(int money, int date) {
		int count = 0;
		for(int i = 0; i <=date; i++) {
			//만약 주식이 구매 가능하다면
			if(money/arr[i] > 0) {
				int buy = money/arr[i];
				count += buy;
				money -= arr[i] * buy;
			}
		}
		money = money + arr[date] * count;
		return money;
	}
	
	static int Timing(int money, int date) {
		int count = 0;
		for(int i = 3; i<=date; i++) {
			//3일 하락시 매수
			if(arr[i-3] > arr[i-2] && arr[i-2] > arr[i-1] && arr[i-1] > arr[i]) {
				int buy = money/arr[i];
				count += buy;
				money -= arr[i] * buy;
			}
		
			//주식 구매 후 3일 상승시 매도
			if(arr[i-3] < arr[i-2] && arr[i-2] < arr[i-1] && arr[i-1] < arr[i]) {
				money += arr[i] * count;
				count = 0;
			}
		}
		money = money + arr[date] * count;
		return money;
	}
}













