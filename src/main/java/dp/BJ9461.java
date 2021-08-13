package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );
		
		long[] dp;
		while( t --> 0 ) {
			 int n = Integer.parseInt( br.readLine() );
			 dp = new long[n+1];
			 
			 if( n == 1 ) dp[1] = 1; 
			 else if( n == 2 ) {
				 dp[1] = 1;
				 dp[2] = 1;
			 } else {
				 dp[1] = 1;
				 dp[2] = 1;
				 for( int i=3; i<=n; i++ ) dp[i] = dp[i-3] + dp[i-2];				
			 }
			 
			 System.out.println( dp[n] );
		}
	}
}
