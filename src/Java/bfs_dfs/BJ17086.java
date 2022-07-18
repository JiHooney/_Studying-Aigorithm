package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17086 {
	
	//미리 필요한 변수들 static 영역에 전역변수로 선언
	//dx, dy는 8방향 탐색을 위한 변수
    static int N, M, sea[][], answer;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    
    public static void main(String[] args) throws IOException {
    	
    	//입력받는 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt( st.nextToken() );
        M = Integer.parseInt( st.nextToken() );
        
        sea = new int[N][M];
                
        for( int i=0; i<N; i++ ) {
            st = new StringTokenizer( br.readLine() );
            for( int j=0; j<M; j++ ) {
                sea[i][j] = Integer.parseInt( st.nextToken() );
            }
        }
        
        
        //BFS메서드를 통해 현재 좌표에서 상어가 있는 공간까지의 거리를 계산해서 리턴하고
        //tmp 변수에 저장한다. 그리고 기존 answer과 tmp를 비교해준다.
        int tmp = 0;
        for( int i=0; i<N; i++ ) {
            for( int j=0; j<M; j++ ) {
                if( sea[i][j] == 1 ) continue;
                
                tmp = BFS(i, j);
                answer = tmp > answer ? tmp : answer;                
            }
        }
        System.out.println( answer );     
    }
    
    
    static int BFS( int x, int y ) {
        boolean visit[][] = new boolean[N][M];
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.add(new int[] {x, y, 0});
        visit[x][y] = true;
        
        while( !q.isEmpty() ) {
            int now[] = q.poll();
            
            for( int i=0; i<8; i++ ) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int val = now[2];
                
                if( nx<0 || ny<0 || nx>=N || ny>=M ) continue;
                if( visit[nx][ny] == true ) continue;
                if( sea[nx][ny] == 1 ) return val+1;
                visit[nx][ny] = true;
                q.add( new int[] {nx, ny, val+1} );
            }
        }
        return 0;
    }
}