package Q30_39;

import java.util.ArrayList;
import java.util.LinkedList;

public class A {

	public static void main(String[] args) {
//		int[] A = new int[10000001];
//				
//		for(int i=2; i<A.length; i++) {
//			A[i]=i;
//		}
//		
//		for(int i =2; i<Math.sqrt(A.length); i++) {
//			if(A[i]==0) {
//				continue;
//			}
//			for(int j=i+i; j<A.length; j=j+i) {
//				A[j] = 0;
//			}
//		}
//		System.out.print("finish");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();				
		for(int i= 2; i<=1000000; i++) {
			arr.add(i);
		}
		
		int i = 0;
		int min;
		while(arr.get(i) <= Math.sqrt(1000000)) {
			min = arr.get(i);
			for(int j=i+1; j<arr.size(); j++) {
				if(arr.get(j)%min ==0) {
					arr.remove(j);
				}
			}
			i++;
		}
		
		System.out.print("finish");
	}
}
