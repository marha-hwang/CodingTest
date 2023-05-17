package BrouteForce;

import java.util.*;
import java.io.*;

public class Q9079_DFS {
    static int n;
    static int[] arr;
    static int[] visit;
    static int[][] Case = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public static void main(String args[]) throws Exception{
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

            //반복문 : 동전 뭉치의 개수만큼
            for(int i = 0; i<n; i++){
                visit = new int[1<<9];
                Arrays.fill(visit, Integer.MAX_VALUE);
                int result = DFS(arr[i], 0);
                if(result == Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(result);
            }


    }

    public static int DFS(int c, int depth){
        //종료조건 : 동전의 면이 모두 같은 경우 종료
        if(c == (1<<9)-1 || c==0) return depth;
        
        //종료조건 : 한번 방문한 동전 조합인 경우 종료
        if(visit[c] <= depth ) return Integer.MAX_VALUE;
        else visit[c] = depth;

        //7가지의 모든 경우를 DFS
        int min = Integer.MAX_VALUE;
        for(int i=0; i<8; i++){
            //동전 면 바꾸기
            int temp = c;
            for(int j=0; j<3; j++){
                int pick = Case[i][j];
                //1이면 0으로
                if(((1<<pick)&temp) >= 1) temp = ~(1<<pick) & temp;
                //0이면 1로
                else temp = (1<<pick) | temp;
            }
            //재귀함수 실행
            min = Math.min(DFS(temp, depth+1), min);

        }
        return min;
    }
}