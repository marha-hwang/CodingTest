package two_pointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q21921 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int now = 0;
		int count = 0;
		int l = 0;
		int r = x-1;
		
		for(int i = l; i<=r; i++) {
			now+=arr[i];
		}
		if(now > max) {
			max = now;
			count = 1;
		}
		
		l++;
		r++;
		while(r < n) {
			now -= arr[l-1];
			now += arr[r];
			l++;
			r++;
			if(now > max) {
				max = now;
				count = 1;
			}
			else if(now == max) {
				count ++;
			}
		}

		if(max == 0) {
			System.out.print("SAD");
			return;
		}
		out.write(String.valueOf(max) + "\n");
		out.write(String.valueOf(count));
		out.flush();
		out.close();

	}

}

