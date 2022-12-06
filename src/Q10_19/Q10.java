package Q10_19;
import java.util.*;
import java.io.*;

public class Q10 {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			int now = Integer.parseInt(st.nextToken());
			while(!mydeque.isEmpty() && mydeque.getLast().value>now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i));
			if(mydeque.getFirst().index <= i-l) {
				mydeque.removeFirst();
			}
			out.write(mydeque.getFirst().value + " ");
		}
		out.flush();
		out.close();
	}
	
	static class Node{
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
