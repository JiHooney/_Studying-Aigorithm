package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16174 {

static int N;
static int[][] map;
static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt( br.readLine() );

        if( N==1 || N>64 ) System.exit(0);

        map = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;

        for( int i=0; i<N; i++ ) {
            st = new StringTokenizer( br.readLine() );
            for( int j=0; j<N; j++ ) {
                map[i][j] = Integer.parseInt( st.nextToken() );
            }
        }

        DFS( 0, 0 );

        //위 DFS메서드에서 목표지점 도달하지 못하고 
        //빠져나왔을 경우 게임실패
        System.out.println( "Hing" );
    }

    static void DFS( int x, int y ) {
        //DFS 메서드를 호출한 좌표 방문처리
        visit[x][y] = true;

        //목표지점에 도달했을 경우 종료
        if( x==N-1 && y==N-1 ) {
            System.out.println( "HaruHaru" );
            System.exit(0);
        }

        //오른쪽과 아래쪽으로 좌표이동
        int nx = x + map[x][y]; //오른쪽
        int ny = y + map[x][y]; //아래쪽

        //오른쪽, 아래쪽가는 경우를 반복문으로 표현
        //i=0이면 오른쪽, i=1이면 아래쪽
        for( int i=0; i<2; i++ ) {
            if( i==0 ) {
                //공간을 벗어날경우 해당 좌표 패스
                if( nx<0 || nx>=N ) continue;

                //방문했다면 해당 좌표 패스
                if( visit[nx][y] ) continue;

                //방문 안했다면 (nx, y)좌표에서 DFS메서드 호출
                DFS( nx, y );
            }
            else {
                //공간을 벗어날경우 해당 좌표 패스
                if( ny<0 || ny>=N ) continue;

                //방문했다면 해당 좌표 패스
                if( visit[x][ny] ) continue;

                //방문 안했다면 (x, ny)좌표에서 DFS메서드 호출
                DFS( x, ny );
            }
        }
        
    }
}
