package Q50_59;
import java.io.*;
import java.util.*;

public class Q59 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int nedge = Integer.parseInt(st.nextToken());
		
		Edge[] arr = new Edge[nedge];
		for(int i = 0; i<nedge; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
 			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			arr[i] = new Edge(start,end, value);
		}
		
		long[] distance = new long[node+1];
		for(int i = 1; i<=node; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[1] = 0;
		boolean cycle = false;
		
		for(int i = 1; i<node; i++) {
			for(int j = 0; j<nedge; j++) {
				if((distance[arr[j].start] != Integer.MAX_VALUE) && 
						(distance[arr[j].end] > distance[arr[j].start] + arr[j].value)) {
					distance[arr[j].end] = distance[arr[j].start] + arr[j].value;
				}
			}
		}
		
		for(int j = 0; j<nedge; j++) {
			if((distance[arr[j].start] != Integer.MAX_VALUE) && 
					(distance[arr[j].end] > distance[arr[j].start] + arr[j].value)) {
				//distance[arr[j].end] = distance[arr[j].start] + arr[j].value;
				cycle = true;
			}
		}
		
		if(cycle) System.out.print("-1");
		else {
			for(int i = 2; i<=node; i++) {
				if(distance[i] != Integer.MAX_VALUE) {
					System.out.println(distance[i]);
				}else System.out.println(-1);
			}
		}
	
		
	}

}

class Edge{
	int start, end, value;
	public Edge(int start, int end, int value){
		this.start = start;
		this.end = end;
		this.value = value;
	}
}
