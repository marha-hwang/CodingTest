package Q30_39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q36 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arr = input.split("\\+|\\-");
		
		Queue<String> symbol = new LinkedList<String>();
		Queue<Integer> arr2 = new LinkedList<Integer>(); 
		
		symbol.add("+");
		symbol.add("-");
		symbol.add("+");
		symbol.add("+");
		symbol.add("-");
		symbol.add("+");
		symbol.add("-");
		symbol.add("+");
		symbol.add("+");
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("\\+") || arr[i].equals("\\-")) {
				symbol.add(arr[i]);
			}else {
				arr2.add(Integer.parseInt(arr[i]));
			}
		}
		
		boolean tf = true;
		String option;
		int tmp=0;
		ArrayList<Integer> plusarr = new ArrayList<Integer>();
		while(!symbol.isEmpty()) {
			option = symbol.poll();
			if(option.equals("+")) {
				int a = arr2.poll();
				tmp += a;
			}else if(option.equals("-")) {
				if(tf ==true) plusarr.add(tmp);
				else plusarr.add(-tmp);
				tf = false;				
				tmp = arr2.poll();
			}
		}
		
		if(tmp!=0) {
			if(tf ==true) plusarr.add(tmp);
			else plusarr.add(-tmp);
		}
		int sum = 0;
		for(int i= 0; i<plusarr.size(); i++) {
			sum += plusarr.get(i);
		}
		
		System.out.print(sum);
	}

}
