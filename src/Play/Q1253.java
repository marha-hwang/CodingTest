package Play;

import java.util.*;
import java.io.*;
public class Q1253 {
	static long[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//가장 쉬운방법 : 수를 정렬하고 모든 경우의 수를 하나씩 찾아감
		//시간 복잡도는? 2000*(2000-1)/2 * n개의 수
		//시간복잡도를 초과하므로 좀더 효율적으로 위치를 특정하는 방법이 필요
		//이분탐색을 활용하면 11*2000번의 방법으로 찾기가능
		
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		int count = 0;
		for(int i = 0; i<n; i++) { //만들 수
			for(int j = 0; j<n-1; j++) { //정해진 수
				if(j == i) continue;
				boolean result = search(i, j);
				if(result) {
					count++;
					break;
				}
			}
		}
		
		System.out.print(count);
	}
	//r포인터를 통해 이분탐색하여 i와 일치하는 수가 있는지 찾는 함수
	static boolean search(int target, int start) {
		boolean result = false;
		
		int l = start+1;
		int r = n-1;
		while(l+1 < r) {
			int mid = (l+r)/2;
			if(mid == target) {
				if(check(target, start, mid) == 1) r = mid-1;
				else if(check(target, start, mid) == -1) l = mid+1;
				else {
					l=mid-1;
					r=mid+1;
					break;
				}
			}
			
			
			if(check(target, start, mid) == 1) r = mid; 
			else if(check(target, start, mid) == -1 ) l = mid; 
			else if(check(target, start, mid) == 0) {
				result = true;
				break;
			}
		}
		
		if(l != target && check(target, start, l) == 0) result = true;
		if(r != target && check(target, start, r) == 0) result = true;
		
		return result;
	}
	
	static int check(int target, int l, int r) {
		if(arr[l] + arr[r] > arr[target]) return 1;
		else if(arr[l] + arr[r] < arr[target]) return -1;
		else return 0;
	}
}







