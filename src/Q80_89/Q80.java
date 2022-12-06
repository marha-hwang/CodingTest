package Q80_89;
import java.util.*;
import java.io.*;
public class Q80 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int color = Integer.parseInt(st.nextToken());
		
		int[] colorN = new int[color];
		
		st = new StringTokenizer(in.readLine());
		int total = 0;
		for(int i = 0; i<color; i++) {
			int a = Integer.parseInt(st.nextToken());
			colorN[i] = a;
			total += a;
		}
		
		int peek = Integer.parseInt(in.readLine());
		
		double result = 0;
		for(int i = 0; i<color; i++) {
			double tmp = 1;
			for(int j = 0; j<peek; j++) {
				tmp *= ((double)colorN[i] - j)/((double)total - j);
			}
			result += tmp;
		}
		
		System.out.print(result);
	}

}
