package Q10_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		mData[] darr = new mData[n];
		
		for(int i=0; i<n; i++) {
			darr[i] = new mData(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(darr);
		
		int max = 0;
		
		for(int i= 0; i<n; i++) {
			if(darr[i].index>i)max =darr[i].index - i + 1;  
		}
		System.out.print(max);
	}

}

class mData implements Comparable<mData>{
	int value;  //값
	int index; //정렬전 인덱스 번호
	
	public mData(int value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o) {  //value값에 따라 정렬하기
		return this.value > o.value ? 1:-1;
	}
	
}
