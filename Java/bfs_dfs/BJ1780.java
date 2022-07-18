package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780 {
	private static int[][] arr;
	private static int a, b, c;
	
	private static void check( int row, int col, int size ) {
		if( colChk( row, col, size ) ) {
			if( arr[row][col] == -1 ) a++;
			else if( arr[row][col] == 0 ) b++;
			else c++;
			return;
		}
		int newSize = size/3;
		
		check( row, col, newSize );						//(1, 1)
		check( row, col+newSize, newSize );				//(1, 2)
		check( row, col+2*newSize, newSize );			//(1, 3)
		
		check( row+newSize, col, newSize );				//(2, 1)
		check( row+newSize, col+newSize, newSize );		//(2, 2)
		check( row+newSize, col+2*newSize, newSize );	//(2, 3)
		
		check( row+2*newSize, col, newSize );			//(3, 1)
		check( row+2*newSize, col+newSize, newSize );	//(3, 2)
		check( row+2*newSize, col+2*newSize, newSize);	//(3, 3)
	}
	
	private static boolean colChk( int row, int col, int size ) {
		int color = arr[row][col];
		
		for( int i=row; i<row+size; i++ ) {
			for( int j=col; j<col+size; j++ ) {
				if( color != arr[i][j] ) return false;
			}
		}
		return true;
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
		check( 0, 0, n );
		
		System.out.println( a + "\n" + b + "\n" + c );
	}
}
