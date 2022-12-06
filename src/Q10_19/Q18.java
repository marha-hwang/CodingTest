package Q10_19;
import java.util.*;
import java.io.*;


public class Q18 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<n; i++) {
			boolean bool = false;
			int index = 0;
			for(int j=0; j<i; j++) {
				if(arr[j]>arr[i]) {
					bool = true;
					index = j;
					break;
				}
			}
			if(bool) {
//				int[] arr2 = arr.clone(); // 똑같은 배열을 복사하여 삽입
//				arr[index] = arr2[i];
//				for(int k = index; k<i; k++) {
//					arr[k+1] = arr2[k];
//				}	
				int value = arr[i];
				for(int j=i; j>index; j--) {
					arr[j] = arr[j-1];
				}
				arr[index] = value;
			}
		}
		int[] S = new int[n];
		S[0]= arr[0];
		int sum = 0;
		for(int i=1; i<n; i++) {
			S[i] = arr[i] + S[i-1];
		}
		for(int i=0; i<n; i++) {
			sum += S[i];
		}
		
		System.out.println(sum);
	}

}
