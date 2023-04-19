package BrouteForce;
import java.util.*;
import java.io.*;

public class Q5568 {
	static int n,k;
	static String[] arr;
	static HashSet<String> hash = new HashSet<String>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		k = Integer.parseInt(in.readLine());
		
		arr = new String[n];
		for(int i = 0; i<n; i++) {
			arr[i] = in.readLine();
		}
		DFS(0, 0, "");
		System.out.print(hash.size());
	}
	
	public static void DFS(int count, int visit, String str) {
		//종료조건 : 카드를 k장 모두 뽑았을 때, 1인 비트가 k개 있는 경우
		if(count == k) {
			//HashSet에 저장하고 return
			hash.add(str);
			return;
		}
		
		//반복문 : 주어진 카드의 수만큼
		for(int i = 0; i<n; i++) {
			//조건문 : 이번 카드 모음의 해당되지 않는 카드만, 해당 비트가 1인지 확인
			if(((1<<i) & visit) < 1) {
				DFS( count+1, (1<<i)|visit, str+arr[i]); //해당 비트를 1로 바꾸어 인자로 넣기
			}
		}
	}

}
