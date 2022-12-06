package Play;
import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class Play1 {

	public static void main(String[] args) {
		//문제1
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<i; j++) {
//				System.out.print(" ");
//			}
//			for(int j = i; j<n; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//문제2
//		String s = "hansung 100.3 Seoul 200 Korea 50.3 a 10";
//		String[] arr = s.split(" ");
//		
//		double sum = 0;
//		
//		for(int i = 0; i< arr.length; i++) {
//			try {
//				sum+= Double.parseDouble(arr[i]);
//			}catch(NumberFormatException e) {
//				
//			}
//		}
//		
//		System.out.print(sum);
		
		//문제3
		int[] Year = LeapYear(2000,3000);
		
		for(int i = 0; i<Year.length; i++) {
			System.out.println(Year[i]);
		}
		
	}
	
	public static int[] LeapYear(int a, int b) {
		
		int count = 0;
		for(int i=a; i<=b; i++) {
			if( (i%4==0 && i%100 != 0) || (i%400 == 0) ) {
				count +=1;
			}
		}
		
		int[] arr = new int[count];
		int narr = 0;
		for(int i=a; i<=b; i++) {
			if( (i%4==0 && i%100 != 0) || (i%400 == 0) ) {
				arr[narr] = i;
				narr++;
			}
		}
		
		
		return arr;
	}
	

}















