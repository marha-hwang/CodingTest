package two_pointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q20366 {
	static int abs = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i = 0; i<n-3; i++) {
			for(int j = i+3; j<n; j++) {
				for(int k = i+1; k<j-1; k++) {
					int l = k+1;
					int r = j-1;
					while(l +1 < r) {
						int mid = (l+r) /2;
						if(check(arr[i]+arr[j], arr[k] + arr[mid])) l = mid;
						else r = mid;
					}
					int tempL = arr[i]+arr[j] - arr[k] - arr[l];
					int tempR = arr[i]+arr[j] - arr[k] - arr[r];
					if(Math.abs(tempL) < Math.abs(tempR) ) abs = Math.min(abs, Math.abs(tempL));
					else abs = Math.min(abs, Math.abs(tempR));
						
					}
				}
			}
		
		out.write(String.valueOf(abs));
		out.flush();
		out.close();
	}
	
	static boolean check(int first, int second){
		boolean result = false;
		if(first >= second) result = true;
		
		return result;
	}

}














