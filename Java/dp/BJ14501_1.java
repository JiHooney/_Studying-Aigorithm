package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_1 {
	static int n, ans;
	static int[][] arr;
	
	public static void dfs( int idx, int pay ) {
		if( idx >= n ) {
			ans = Math.max( ans, pay );
			return;
		}
		
		if( idx+arr[idx][0] <= n ) dfs( idx+arr[idx][0], pay+arr[idx][1] );
		else dfs( idx+arr[idx][0], pay );
		
		dfs( idx+1, pay );
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		StringTokenizer st;
		
		arr = new int[n][2];
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			arr[i][0] = Integer.parseInt( st.nextToken() );
			arr[i][1] = Integer.parseInt( st.nextToken() );
		}
		
		ans = 0;
		dfs( 0, 0 );
		
		System.out.println( ans );
	}
}