package Q10_19;
import java.util.*;
import java.io.*;
public class Q12 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(in.readLine());
		int[] okensu = new int[count];
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[count];
		for(int j=0; j<count; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
		}
			
		for(int i=count-1; i>=0; i--) {
			if(stack.isEmpty()) {
				okensu[i] = -1;
				stack.push(arr[i]);
			}else {
				while(!stack.isEmpty() && stack.peek()<= arr[i]) {
					stack.pop();
				}
				if(!stack.isEmpty()) {
					okensu[i] = stack.peek();
					stack.push(arr[i]);
				}else okensu[i] = -1;
			}
		}
		
		for(int k=0; k<count; k++) {
			System.out.print(okensu[k] + " ");
		}
	}

}
