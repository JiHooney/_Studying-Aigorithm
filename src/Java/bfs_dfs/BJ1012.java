package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );
		
		StringTokenizer st;
		int m, n, k, x, y;
		int[][] arr;
		while( t-->0 ) {
			st = new StringTokenizer( br.readLine() );
			m = Integer.parseInt( st.nextToken() );
			n = Integer.parseInt( st.nextToken() );
			k = Integer.parseInt( st.nextToken() );
			
			arr = new int[n+1][m+1];
			while( k-->0 ) {
				st = new StringTokenizer( br.readLine() );
				x = Integer.parseInt( st.nextToken() );
				y = Integer.parseInt( st.nextToken() );
				arr[x][y] = 1;
			}
			
			
		}
	}
}