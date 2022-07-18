package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16397 {

    static int N, T, G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine() );

        N = Integer.parseInt( st.nextToken() );
        T = Integer.parseInt( st.nextToken() );
        G = Integer.parseInt( st.nextToken() );
        
        BFS();
    }

    public static void BFS() {
        Queue<Pair> q = new LinkedList<Pair>();

        //어떤 수가 이미 계산되었는지 안되었는지를 알기 위해 방문배열을 만든다.
        //N이 99999를 넘으면 안되니깐 100000크기의 방문을 표시하는 배열을 만든다.
        boolean[] visited = new boolean[100000];
        visited[N] = true;  //초기 N 방문처리

        //현재의 N값과 t(누른횟수:0)을 큐에 넣어준다.
        q.add( new Pair(N, 0) );

        while( !q.isEmpty() ) {
            Pair tmp = q.poll();

            //여태까지 버튼 누른횟수(t)가 T보다 크면 반복문 종료
            if( tmp.t > T ) break;  

            //여태까지 계산된 n이 G와 같으면 
            //여태까지 버튼 누른횟수(t)를 출력하고 종료
            if( tmp.n == G ) {
                System.out.println( tmp.t );
                return;
            }

            //위 두 상황이 아니면 A버튼, B버튼 각각의 상황에 대해서 계산한다.
            //i=0일 떄 A버튼, i=1일 때 B버튼을 누르는 것으로 가정
            //현재 큐에 들어있는 N에서 A버튼 눌렀을 때, B버튼 눌렀을 때의 
            //상황을 또 큐에 넣어주게된다.
            for( int i=0; i<2; i++ ) {
                if( i==0 ) {
                    int nx = tmp.n+1;   //A버튼 처리

                    //새로운 n값인 nx가 99999크거나 방문했다면 B버튼으로 넘어간다.
                    //아니라면 방문처리하고 큐에 넣어준다.
                    if( nx>99999 || visited[nx] ) continue;
                    visited[nx] = true;
                    q.add( new Pair( nx, tmp.t+1 ) );

                } else {
                    int nx = tmp.n*2;   //B버튼 처리
                    
                    //문제에 N이 0이 포함되므로 0일 경우에 처리도 해준다.
                    if( nx>99999 || nx==0 ) continue;

                    //가장 높은 자리수에 -1을 해주기 위해
                    //예를들어 nx=13 / (int)Math.pow(10, 2)=100 => 13 % 100 = 13
                    //idx=2 저장하고 80줄코드에서 (int)Math.pow(10, 1)=10 이니깐
                    //nx = 13-10 = 3이 된다.       
                    int idx = -1;
                    for( int j=1; j<7; j++ ) {
                        if( nx % (int)Math.pow(10, j) == nx ) {
                            idx = j;
                            break;
                        }
                    }

                    if( idx != -1 ) {
                        nx -= (int)Math.pow(10, idx-1);
                        if( visited[nx] ) continue;
                        visited[nx] = true; //방문처리후 큐에 넣어준다.
                        q.add( new Pair(nx, tmp.t+1) );
                    }
                }
            }
        }
        System.out.println( "ANG" );
    }
}

class Pair {
    int n;
    int t;

    public Pair( int n, int t ) {
        this.n = n;
        this.t = t;
    }
}