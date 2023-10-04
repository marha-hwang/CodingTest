package two_pointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q20922 {
	
	//0인덱스 부터 끝까지 순차적으로 탐색 
	//증가시킬 때마다 각 수가 몇번씩 나왔는지 배열에 저장
	//중복가능한 개수를 초과하면 중복되는 수의 다음 지점으로 이동
	//중복되는 수가 나올 때 이동지점을 관리하기 위해서는 큐를 사용했으나 
    //L포인터가 이동한 경우 한칸씩 이동하면서 이전 결과들을 초기화 시킴 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] count = new int[1000001];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
		} 
		
		int l = 0;
		int r = 0;
		int max = 0;
		while(r < n) {
			int now = arr[r];
			//중복된 수가 k개를 넘는 경우 L포인터 위치 이동
			if(count[now] + 1 > k) {
				while(arr[l] != now) {
					count[arr[l]] -= 1;
					l++;
				}
				l++;
			}
			else count[now]++;
	
			if(r-l + 1 > max) max = r-l+1;
			r++;
		}
		out.write(String.valueOf(max));
		out.flush();
		out.close();

	}

}

