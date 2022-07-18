package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1520 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int m, n;
	private static int[][] map, dp;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static StringTokenizer st;
	
	private static int dfs( int x, int y ) {
		if( x==m && y==n ) return 1;
		
		if( dp[x][y] == -1 ) {	//방문하지 않은 원소일 경우	
			dp[x][y] = 0;		//해당 원소값을 0으로 초기화시키고
			
			for( int i=0; i<4; i++ ) {	//상하좌우로 가기위해 반복문을 돌린다.
				int nx = x + dx[i];	//새로운 행값 선언
				int ny = y + dy[i];	//새로운 열값 선언
				
				//새로운 행,열 값이 지도배열의 범위를 벗어나면 또 다른 새로운 행열값을 만든다.
				if( nx<=0 || nx>m || ny<=0 || ny>n ) continue;
				
				//현재 행열값의 원소가 새로운 행열값의 원소보다 클 경우
				if( map[x][y] > map[nx][ny] ) {	
					//현재 행열값의 DP배열 원소를 목표지점까지 갈 수 있는 이동방법 수로 저장한다.
					dp[x][y] += dfs( nx, ny );	
				}
			}
		}
		
		//만약 위의 조건문 불충족하면 이전에 한 번 방문했던 원소이므로 
		//원소값을 반환해준다.
		return dp[x][y];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer( br.readLine() );
		m = Integer.parseInt( st.nextToken() );	//지도 세로 크기
		n = Integer.parseInt( st.nextToken() );	//지도 가로 크기
		
		map = new int[m+1][n+1];
		dp = new int[m+1][n+1];
		for( int i=1; i<=m; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=1; j<=n; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
				dp[i][j] = -1;	//DP배열의 원소들을 모두 -1로 채워준다.
			}
		}
		
		bw.write( dfs(1, 1) + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}