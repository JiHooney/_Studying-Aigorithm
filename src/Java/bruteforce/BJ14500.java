package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500 {
	static int n, m, ans;
	static int[][] arr, visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	public static void dfs( int row, int col, int len, int sum ) {
		if( len == 4 ) {
			ans = Math.max( ans, sum );
			return;
		}
		
		for( int i=0; i<4; i++ ) {
			int nrow = row + dy[i];
			int ncol = col + dx[i];
			
			if( nrow<0 || ncol<0 || nrow>=n || ncol>=m ) continue;
			if( visit[nrow][ncol] == 1 ) continue;
			
			visit[nrow][ncol] = 1;
			dfs( nrow, ncol, len+1, sum+arr[nrow][ncol] );
			visit[nrow][ncol] = 0;
		}
	}
	
	public static void additionalPlus( int row, int col ) {
		int sum = 0;
		
		//ㅗ ㅜ ㅏ ㅓ 순으로 비교
		//ㅗ
		if( row-1>=0 && col-1>=0 && col+1<m ) {
			sum = arr[row-1][col] + arr[row][col-1] + arr[row][col] + arr[row][col+1];
			ans = Math.max( ans, sum );
			sum = 0;
		}
		
		//ㅜ
		if( row+1<n && col-1>=0 && col+1<m ) {
			sum = arr[row+1][col] + arr[row][col-1] + arr[row][col] + arr[row][col+1];
			ans = Math.max( ans, sum );
			sum = 0;
		}
		
		//ㅏ
		if( row-1>=0 && row+1<n && col+1<m ) {
			sum = arr[row-1][col] + arr[row][col] + arr[row][col+1] + arr[row+1][col];
			ans = Math.max( ans, sum );
			sum = 0;
		}
		
		//ㅓ
		if( row-1>=0 && row+1<n && col-1>=0 ) {
			sum = arr[row-1][col] + arr[row][col] + arr[row][col-1] + arr[row+1][col];
			ans = Math.max( ans, sum );
			sum = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		
		arr = new int[n][m];
		visit = new int[n][m];
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<m; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		for( int i=0; i<n; i++ ) {
			for( int j=0; j<m; j++ ) {
				visit[i][j] = 1;
				dfs( i, j, 1, arr[i][j] );
				visit[i][j] = 0;
				additionalPlus( i, j );
			}
		}
		System.out.println( ans );
		
	}
}