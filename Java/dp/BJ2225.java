package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt( st.nextToken() );
		int k = Integer.parseInt( st.nextToken() );
		
		long[][] dp = new long[n+1][k+1];
		for( int i=1; i<=n; i++ ) {
			for( int j=1; j<=k; j++ ) {
				if( i==1 ) {
					dp[i][j] = j;
					continue;
				}
				if( j==1 ) dp[i][j] = 1;
				else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;
			}
		}
		System.out.println( dp[n][k] % 1_000_000_000 );
	}
}