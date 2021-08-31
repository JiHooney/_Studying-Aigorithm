package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15655 {
	static int n, m;
	static int[] arr, ans, visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs( int start, int depth ) {
		if( depth == m ) {
			for( int val : ans ) sb.append( val ).append( " " );
			sb.append( "\n" );
			return;
		}
		
		for( int i=start; i<n; i++ ) {
			if( depth == 0 ) {
				ans[depth] = arr[i];
				visit[i] = 1;
				dfs( i+1, depth+1 );
			}
			if( visit[i] != 1 ) {
				ans[depth] = arr[i];
				dfs( i+1, depth+1 );
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		arr = new int[n];
		visit = new int[n];
		ans = new int[m];
		
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( st.nextToken() );
		Arrays.sort( arr );
		
		dfs( 0, 0 );
		
		System.out.println( sb );
	}
}