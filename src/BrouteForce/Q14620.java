package BrouteForce;
/*
 *문제 : n*n크기의 마당에 3개의 꽃을 심는 최소비용 찾기, 단 마당을 벗어나거나 꽃이 겹치면 안됨
 *생각해볼 것 : 꽃의 배치가 정해진 경우 비용을 계산 하는 법 - 비트마스킹으로 체크된 지점의 비용합을 구함
 *          
 *  완전탐색을 이용하여 풀이 
 *  무엇을 탐색해야 함? 꽃을 배치하는 모든 경우찾기
 *  어떻게 모든 경우를 찾음? 가능한 자리에 하나씩 차례대로 배치
 *  배치가 가능한 조건은? 마당 안에 있어야함, 겹치면 안됨
 *      마당안에 있는지 확인하는 법은? 마당의 크기를 n+1*n+1로 표현하고 미리 체크해놓기
 *      겹치는지 확인하는 법은? 마당을 배열으로 표현하고 꽃이 위치할 지점이 체크 되었는지 확인 
 *  배치한 이후에는 동작은? 배치된 지점을 체크하고 n*n지점에 대해 모두 꽃이 배치 가능한지 확인
 *  동일한 배치가 반복될 경우를 대비? 방문배열을 이용하여 한번 방문한 경우 체크(시간복잡도는 1000으로 필요x)
 *  DFS or BFS 무엇을 사용할지? 중복된 경우에서 우선순위가 존재하지 않기 때문에 그냥 BFS사용
 *  depth기록을 위해 배열의 0번인덱스에는 depth기록, 1번 인덱스부터 모양저장
 */

import java.util.*;
import java.io.*;
public class Q14620 {
    static int n;
    static int[][] arr;
    static int[][] Case = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {0,0}};
    public static void main(String[] args) throws Exception{
        //입력받기
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        
        int[][] c = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            c[i][0] = 1;
            c[i][n+1] = 1;
            c[0][i] = 1;
            c[n+1][i] = 1;
        }

        arr = new int[n+2][n+2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //BFS실행 및 출력
        c[0][0] = 0;
        System.out.println(BFS(c));

    }

    public static int BFS(int[][] c){
        //큐 생성
        Queue<int[][]> que = new LinkedList<int[][]>();
        //큐에 마당 모양 넣기
        que.add(c);

        int cost=Integer.MAX_VALUE;
        //while : 큐가 빌때까지
        while(!que.isEmpty()){
            //큐 뽑기
            int[][] now = que.poll();
            //만약 depth가 3인 경우 비용을 계산
            if(now[0][0] == 3) {
                //비용계산
                int temp=0;
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        if(now[i][j] ==1) temp += arr[i][j];
                    }
                }
                cost = Math.min(cost, temp);
                continue;
            }

            //반복문 : 배치가능한 모든 경우 반복
            for(int i = 1; i<= n; i++){
                for(int j=1; j<=n; j++){
                    //꽃이 추가된 마당 모양 세팅
                    int[][] temp = now.clone();
                    boolean check = true;
                    for(int k=0; k<5; k++){
                        int x = Case[k][0];
                        int y = Case[k][1];
                        if(temp[i+x][j+y] != 0) {
                            check = false;
                            break;
                        }
                    }
	                 if(check) {
						 for(int k=0; k<5; k++){
						     int x = Case[k][0];
						     int y = Case[k][1];
						     temp[i+x][j+y] = 1;
	                    }
	                 }
                    //심어진 꽃의 개수 저장
                    temp[0][0] +=1;
                    //배치가 가능한 경우만 큐에 넣기
                    if(check) que.add(temp);

                }
            }
        }
        return cost;
    }
}

