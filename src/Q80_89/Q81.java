package Q80_89;
import java.util.*;
import java.io.*;
public class Q81 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int option = Integer.parseInt(st.nextToken());
		
		if(option == 1) {
			long k = Long.parseLong(st.nextToken());
			ArrayList<Integer> result = new ArrayList<Integer>();
			ArrayList<Integer> arr = new ArrayList<Integer>(); 
			//k까지의 수를 ArrayList에 저장
			for(int i = 1; i<=N; i++) {
				arr.add(i);
			}
			long fac = 1;
			for(int i = 1; i<=N; i++) {
				fac *= i;
			}
			
			for(int i = 0; i<N; i++) {
				
				fac /= (N-i);
				//첫번째 수를 알아내기
				// k / (n!/n) + 1이 첫번째 수
				long index = k/fac;
				k = k%fac;
				
				if(k != 0) {
					result.add(arr.get((int)index));
					arr.remove((int)index);
				}			
				// 나머지가 0이 나오는 경우 몫-1의값을 인덱스로 가지는 수를 출력하고 역순으로 나머지 수 출력
				else if(k == 0) {
					result.add(arr.get((int)index-1));
					arr.remove((int)index-1);
					for(int j = arr.size()-1; j>=0; j--) {
						result.add(arr.get(j));
					}
					break;
				}
			}
			
			for(int i : result) {
				System.out.print(i + " ");
			}
			
		}
		else if(option ==2) {
			//배열에 입력된 값 저장
			int[] input = new int[N];
			for(int i = 0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			//ArrayList에 N까지 저장
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i = 0; i<N; i++) {
				arr.add(i+1);
			}
			
			//n!구하기
			long fac = 1;
			for(int i = 1; i<=N; i++) {
				fac *= i; 
			}
			long result = 1;
			//반복문 - 배열의 크기만큼
			for(int i = 0; i<N; i++) {				
				fac /= (N-i);
				
				//배열의 값이 ArrayList의 몇번 인덱스인지 알아내기
				for(int j = 0; j<arr.size(); j++) {
					if(input[i] == arr.get(j)) {						
						arr.remove(j);
						
						//n!/n * 인덱스를 누적합에 더하기
						result += fac*j;
						break;
					}
				}
			}
			System.out.print(result);
		}
			
	}
}
