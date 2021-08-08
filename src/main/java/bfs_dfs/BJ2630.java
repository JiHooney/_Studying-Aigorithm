package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
	
	private static void cutPaper( int white, int blue, int start, int end, int[][] arr ) {
		
		int tmp = 0;
		for( int i=start; i<end; i++ )
			for( int j=start; j<end; j++ )
				tmp++;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		StringTokenizer st;
		int[][] arr = new int[n][n];
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<n; j++ ) arr[i][j] = Integer.parseInt( st.nextToken() );
		}
		
		int white = 0;
		int blue = 0;
		cutPaper( white, blue, 0, arr.length, arr );
		
		
	}
}