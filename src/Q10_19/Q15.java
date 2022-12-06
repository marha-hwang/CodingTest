package Q10_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for(int k=0; k<n; k++) {
			arr[k] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			for(int j = 0; j<n-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int a = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = a;
				}
			}
		}
		for(int k=0; k<n; k++) {
			System.out.println(arr[k]);
		}
	}

}
