package Implementation;

import java.util.*;
import java.io.*;
public class Q10994 {
	static int n;
	static String[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(in.readLine());
		n = 1+ (input-1) * 4;
		arr = new String[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = "*";
			}
		}
		for(int i = 1; i<(n-1)/2; i+=2) {
			emptyArr(i);
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	static void emptyArr(int k) {
		int max = n-1-k;
		for(int i = 0; i<=max-k; i++) {
			arr[k][k+i] = " ";
			arr[max][k+i] = " ";
			arr[k+i][k] = " ";
			arr[k+i][max] = " ";
		}
	}
}

