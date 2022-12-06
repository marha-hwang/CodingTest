package Q10_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] a = in.readLine().split("");
		int[] arr = new int[a.length];
		for(int i=0; i<a.length; i++) {
			arr[i] = Integer.parseInt(a[i]);
		}
		
		for(int i= 0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int now=arr[i];
				if(now<arr[j]) {
					int save = arr[i];
					arr[i] = arr[j];
					arr[j] = save;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
		System.out.print(arr[i]+" ");
	}
	}

}
