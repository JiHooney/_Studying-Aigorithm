package bfs_dfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468 {
	private static int[][] arr;
	private static int[][] visit;
	private static int n;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	private static int bfs() {
		int res = 0;
		Queue<Point> que = new LinkedList<Point>();
		
		for( int i=1; i<=n; i++ ) {
			for( int j=1; j<=n; j++ ) {
				if( visit[i][j] == 0 ) {
					visit[i][j] = 1;
					que.add( new Point(i, j) );
					
					while( !que.isEmpty() ) {
						int x = que.peek().x;
						int y = que.peek().y;
						que.poll();
						
						for( int k=0; k<4; k++ ) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if( nx <= 0 || nx > n || ny <= 0 || ny > n ) continue;
							if( visit[nx][ny]==0 ) {
								que.add( new Point(nx, ny) );
								visit[nx][ny] = 1;
							}
						}
					}
					res++;
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		arr = new int[n+1][n+1];
		int result = 0;
		
		StringTokenizer st;
		int max = 0;
		for( int i=1; i<=n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=1; j<=n; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
				max = Math.max( max, arr[i][j] );
			}
		}
		
		for( int i=0; i<=max; i++ ) {
			visit = new int[n+1][n+1];
			for( int j=1; j<=n; j++ ) {
				for( int k=1; k<=n; k++ ) {
					if( arr[j][k] <= i ) visit[j][k] = 1;
				}
			}
			result = Math.max( bfs(), result );
		}
		System.out.println( result  );
	}
}