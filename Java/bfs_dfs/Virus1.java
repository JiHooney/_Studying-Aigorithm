package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus1 {
	public static int[][] arr;
	public static boolean[] visit;
	public static int sum = 0;
	
	private static void bfs( int start ) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add( start );
		visit[start] = true;
		
		while( !q.isEmpty() ) {
			int temp = q.peek();
			q.poll();
			
			for( int i=1; i<arr.length; i++ ) {
				if( arr[temp][i] == 1 && visit[i] == false ) {
					q.add(i);
					visit[i] = true;
					sum += 1;
				}
			}
			System.out.println( "temp는 ? " + temp );
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int n = Integer.parseInt( br.readLine() );
		int m = Integer.parseInt( br.readLine() );
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for( int i=1; i<=m; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int a = Integer.parseInt( st.nextToken() );
			int b = Integer.parseInt( st.nextToken() );
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
			
//		for( int i=0; i<arr.length; i++ ) {
//			for( int j=1; j<arr.length; j++ ) {
//				System.out.print( arr[i][j] );
//			}
//			System.out.println( );
//		}
		
		bfs( 1 );
		System.out.println( sum );
	}

}
