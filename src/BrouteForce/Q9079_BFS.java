package BrouteForce;
import java.util.*;
import java.io.*;

public class Q9079_BFS {
	static int n;
    static int[] arr;
	static boolean[] visit;
    static int[][] Case = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        Arrays.fill(arr, 0);
        //동전의 앞, 뒤를 비트 마스킹으로 저장
        for(int i=0; i<n; i++)
            for(int j=0; j<3; j++){
                st = new StringTokenizer(in.readLine());
                for(int k=0; k<3; k++){
                    if(st.nextToken().charAt(0) == 'T') arr[i] = (1<<j*3+k)|arr[i];
                }
            }
        
        //동전 뭉치의 개수만큼 실행
        for(int i = 0; i<n; i++){
            visit = new boolean[1<<9];
            int[] c = {0, arr[i]};
            int result = BFS(c);
            System.out.println(result);
        }

		
	}
	
	public static int BFS(int[] c) {
		//큐 생성
		Queue<int[]> que = new LinkedList<int[]>();
		//큐에 동전모양 넣기
		que.add(c);
		visit[c[1]] = true;
		
		int depth = -1;
		//while : 큐가 빌 때까지
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			// 모든 면이 일치하는 경우 break
			if(now[1]==(1<<9)-1 || now[1]==0) {
				depth = now[0];
				break;
			}
			
			// 방문하지 않은 모든 경우를 큐에 넣기
			for(int i=0; i<8; i++){
	            //동전 면 바꾸기
				int[] temp = now.clone();
	            for(int j=0; j<3; j++){
	                int pick = Case[i][j];
	                //1이면 0으로
	                if(((1<<pick)&temp[1]) >= 1) temp[1] = ~(1<<pick)&temp[1];
	                //0이면 1로
	                else temp[1] = (1<<pick) | temp[1];
	            }
	            //큐에 넣기
	            if(!visit[temp[1]]) {
	    			//방문체크
	    			visit[temp[1]] = true;
	    			temp[0]+=1;
	            	que.add(temp);
	            }

	        }
		}
		return depth;
	}

}
