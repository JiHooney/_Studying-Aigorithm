package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1303_2 {

    static Character[][] map;
    static boolean visit[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int b=0, w=0, N,M,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		M = Integer.parseInt( st.nextToken() );	
		N = Integer.parseInt( st.nextToken() );	
		
		map = new Character[N][M];
		visit = new boolean[N][M];
		
		for( int i=0; i<N; i++ ) {
			String str = br.readLine();
			for( int j=0; j<M; j++ ) {
				map[i][j] = str.charAt(j);	//문자열을 문자로 나눠서 map에 저장
			}
		}

        //DFS
        for( int i=0; i<N; i++ ) {
            for( int j=0; j<M; j++ ) {
                if( !visit[i][j] ) {
                    c = 1;
                    dfs( map[i][j], i, j );

                    if( map[i][j] == 'W' ) 
                        w += (c*c);
                    else 
                        b += (c*c);
                }
            }
        }

        System.out.println( w + " " + b );
    }

    static void dfs( char ch, int row, int col ) {
        visit[row][col] = true;

        //이동
        for( int i=0; i<dx.length; i++ ) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            //배열 범위 벗어나는지
            if( nx>=N || nx<0 || ny>=M || ny<0 ) 
                continue;
            
            //이미 방문했는지
            if( visit[nx][ny] ) 
                continue;

            //ch가 다른 값인지
            if( map[nx][ny] != ch )
                continue;

            c++;
            dfs( ch, nx, ny );
            
        }
    }
}
