package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visit;
	
	public static void dfs( int n, int m, int depth ) {
		if( depth == m+1 ) {
			for( int i=1; i<=m; i++ ) sb.append( arr[i] ).append( " " );
			sb.append( "\n" );
			return;
		}
		
		for( int i=1; i<=n; i++ ) {
			if( !visit[i] ) {
				visit[i] = true;
				arr[depth] = i;
				dfs( n, m, depth+1 );
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		
		arr = new int[m+1];
		visit = new boolean[n+1];
		
		dfs( n, m, 1 );
		
		System.out.println( sb );
	}
}