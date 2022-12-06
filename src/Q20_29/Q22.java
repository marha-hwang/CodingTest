package Q20_29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sort(arr, 10000);
		
		for(int i= 0; i<n; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void sort(int[] arr, int max) {
		int jarisu =1;
		int[] tmp = new int[arr.length];
		while(jarisu < max) {
			int[] bucket = new int[10];
			for(int i = 0; i<arr.length; i++) {
				bucket[(arr[i]/jarisu)%10] +=1;
			}
			for(int i=1; i<10; i++) {
				bucket[i] += bucket[i-1];
			}
			
			int zero = 0;
			for(int i=0; i<arr.length; i++) {
				//구간합을 이용해 적절한 순서에 수 삽입
				if((arr[i]/jarisu)%10 !=0) {
					tmp[bucket[(arr[i]/jarisu)%10-1]] = arr[i];
					bucket[(arr[i]/jarisu)%10-1] ++;
				}else {
					tmp[zero] = arr[i];
					zero++;
				}
			}
			for(int i=0; i<arr.length; i++) {
				arr[i] = tmp[i];
			}
			jarisu *=10;
		}
	}

}


