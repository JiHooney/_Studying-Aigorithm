package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
    int x;
    int y;

    tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class BJ7576 {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<tomato> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer( br.readLine() );
        M = Integer.parseInt( st.nextToken() );
        N = Integer.parseInt( st.nextToken() );

        map = new int[N][M];
        q = new LinkedList<tomato>();

        //애초부터 모든 토마토가 익어있는 경우를 위한 변수
        int tmp = 0;

        for( int i=0; i<N; i++ ) {
            st = new StringTokenizer( br.readLine() );
            for( int j=0; j<M; j++ ) {
                map[i][j] = Integer.parseInt( st.nextToken() );
                //익은 토마토 있으면 먼저 큐에 넣기
                if( map[i][j] == 1 ) {
                    q.add( new tomato(i, j) );
                    tmp++;
                }             
            }
        }

        if( tmp == N*M ) {
            System.out.println( 0 );
            System.exit(0);
        }

        System.out.println( BFS() );
    }

    public static int BFS() {
        while( !q.isEmpty() ) {
            tomato t = q.remove();

            int x = t.x;
            int y = t.y;

            for( int i=0; i<4; i++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위 밖으로 벗어나면 패스
                if( nx<0 || ny<0 || nx>=N || ny>=M ) continue;

                //안익은 토마토라면
                if( map[nx][ny] == 0 ) {
                    //익은 토마토로 변경
                    q.add(new tomato(nx, ny));

                    //익은 날짜를 알기 위해 그 전 값에서 1증가
                    map[nx][ny] = map[x][y]+1;
                }
            }
        }

        //최대날짜
        int result = 0;

        for( int i=0; i<N; i++ ) {
            for( int j=0; j<M; j++ ) {
                //안익은 토마토가 있으면
                if( map[i][j] == 0 ) {
                    return -1;
                }

                //최대 날짜 구하기
                result = Math.max( result, map[i][j] );
            }
        }

        //걸린 일수는 최대 날짜에서 -1
        //왜냐하면 입력받을 때 큐에 집어넣은 토마토가 1부터 시작했기때문이다.
        return result-1;
    }
}
