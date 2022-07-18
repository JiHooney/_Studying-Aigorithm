package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MakingCash1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static int m;
	private static int[] arr;	//화폐의 가치를 담을 배열
	private static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		
		arr = new int[n];
		dp = new int[10001];
		for( int i=0; i<=m; i++ ) dp[i] = 10001;
		
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( br.readLine() );
		
		dp[0] = 0;
		for( int i=0; i<n; i++ ) {
			for( int j=arr[i]; j<=m; j++ ) {
				dp[j] = Math.min( dp[j], dp[j-arr[i]]+1 );
			}
		}
		
		if( dp[m] == 10001 ) System.out.println( "-1" );
		else System.out.println( dp[m] );
		
	}
}
