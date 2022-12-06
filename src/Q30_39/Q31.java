package Q30_39;
import java.util.*;
import java.io.*;

public class Q31 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int gaesu = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int[] arr = new int[gaesu];
		for(int i = 0; i<gaesu; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		for(int i = gaesu-1; i>=0; i--) {
			if(price == 0)break;
			if(price>arr[i]) {
				count = count + price/arr[i];
				price = price%arr[i];
			}
		}
		System.out.print(count);

	}

}
