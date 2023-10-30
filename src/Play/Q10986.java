package Play;
import java.util.*;
import java.io.*;


public class Q10986 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sum = new int[n];
		sum[0] = arr[0];
		sum[0] = sum[0]%m;
		for(int i = 1; i<n; i++) {
			sum[i] = sum[i-1] + arr[i];
			sum[i] = sum[i]%m;
		}
		
		int[] count = new int[m];
		for(int i = 0; i<n; i++) {
			count[sum[i]]++;
		}
		
		int[] D = new int[n];
		D[0] = count[0];
		count[sum[0]]--;
		for(int i = 1; i<n; i++) {
			D[i] = count[sum[i-1]];
			count[sum[i]]--;
		}
		
		int result = 0;
		for(int i = 0; i<n; i++) {
			result+=D[i];
		}
		System.out.print(result);
	}

}

















