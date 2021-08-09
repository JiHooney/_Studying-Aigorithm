package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
	private static int white = 0;
	private static int blue = 0;
	private static int[][] arr;
	
	private static boolean colChk( int row, int col, int size ) {
		int color = arr[row][col];
		
		for( int i=row; i<row+size; i++ ) {
			for( int j=col; j<col+size; j++ ) {
				if( arr[i][j] != color ) return false;
			}
		}
		
		return true;
	}

	private static void cutPaper( int row, int col, int size ) {
		if( colChk( row, col, size ) ) {
			if( arr[row][col] == 0 ) white++;
			else blue++;
			
			return;
		}
		
		int newSize = size / 2;
		cutPaper(row, col, newSize);
		cutPaper(row, col+newSize, newSize);
		cutPaper(row+newSize, col, newSize);
		cutPaper(row+newSize, col+newSize, newSize);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		StringTokenizer st;
		arr = new int[n][n];
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<n; j++ ) arr[i][j] = Integer.parseInt( st.nextToken() );
		}
		
		cutPaper(0, 0, n);
		
		System.out.println( white );
		System.out.println( blue );
		
		
		
	}
}