package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
	static int n, ans;
	static int[][] arr, visit;
	
	public static void dfs( int a, int b, int hap, int depth ) {
		if( depth == (int)(n/2) ) {
			ans = Math.min( ans, hap );
			return;
		}
		
		for( int i=0; i<n; i++ ) {
			for( int j=0; j<n; j++ ) {
				
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		arr = new int[n][n];
		visit = new int[n][n];
		StringTokenizer st;
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<n; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		ans = Integer.MAX_VALUE;
		dfs( 0, 0, 0, 0 );
		System.out.println( ans );
	}
}