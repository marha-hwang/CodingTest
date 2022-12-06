package Q60_69;
import java.util.*;
import java.io.*;

public class Q69 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Node root = new Node();
		for(int i = 0; i<n; i++) {
			String text = in.readLine();
			Node now = root;
			for(int j = 0; j<text.length(); j++) {
				char c = text.charAt(j);
				
				//알파벳의 순서에 해당하는 배열의 인덱스를 찾기위한 c-'a'
				if(now.next[c - 'a'] == null) {
					now.next[c - 'a'] = new Node();
				}
				
				now = now.next[c - 'a'];
				if(j == text.length()-1) {
					now.end = true;
				}
			}
		}
		int result = 0;
		for(int i = 0; i<m; i++) {
			String text = in.readLine();
			Node now = root;
			for(int j = 0; j<text.length(); j++) {
				char c = text.charAt(j);
				if(now.next[c - 'a'] == null) break;
				
				now = now.next[c - 'a'];
				
				//저장된 문자의 끝이면 text의 길이와 일치하는치 확인후 종료
				if(now.end && text.length() - 1 == j) {
					result++;
				}
				 
			}
		}
		
		System.out.print(result);

	}

}

class Node {
	Node[] next = new Node[26];
	boolean end;
}
