package bfs_dfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
	private static int[][] arr;
	private static int[][] visit;
	private static int ans, l;
	private static int[] dx = { -1, -1, -2, -2,  1, 1,  2, 2 };
	private static int[] dy = { -2,  2, -1,  1, -2, 2, -1, 1};
	
	private static String bfs( int x, int y ) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer( new Point(x, y) );
		visit[x][y] = 1;
		
		int new_x, new_y;
		while( !que.isEmpty() ) {
			Point p = que.poll();
			if( arr[p.x][p.y] == 1 ) return ans+"";
			
			for( int i=0; i<8; i++ ) {
				new_x = p.x + dx[i];
				new_y = p.y + dy[i];
				
				if( new_x < 0 || new_y < 0 || new_x >= l || new_y >= l ) 
					continue;
				
				if( visit[new_x][new_y] != 1 ) {
					visit[new_x][new_y] = 1;
					que.offer( new Point( new_x, new_y ) );
					ans++;
				}
			}
		}
	
		return ans + "";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int x, y;
		while( t --> 0 ) {
			l = Integer.parseInt( br.readLine() );
			ans = 0;
			
			arr = new int[l][l];
			visit = new int[l][l];
			st = new StringTokenizer( br.readLine() );
			x = Integer.parseInt( st.nextToken() );
			y = Integer.parseInt( st.nextToken() );
			
			st = new StringTokenizer( br.readLine() );
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			
			sb.append( bfs( x, y ) ).append( "\n" );
		}
		
		System.out.println( sb );
	}
}