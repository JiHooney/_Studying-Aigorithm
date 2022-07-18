package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15656 {
	static int n, m;
	static int[] arr, ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs( int start, int depth ) {
		if( depth == m ) {
			for( int val : ans ) sb.append( val ).append( " " );
			sb.append( "\n" );
			return;
		}
		
		for( int i=0; i<n; i++ ) {
			ans[depth] = arr[i];
			dfs( i, depth+1 );
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		
		arr = new int[n];
		ans = new int[m];
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( st.nextToken() );
		Arrays.sort( arr );
		
		dfs( 0, 0 );
		
		System.out.println( sb );
	}
}