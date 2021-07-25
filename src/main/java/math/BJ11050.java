package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11050 {
	private static int n, k;
	private static int[][] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		k = Integer.parseInt( st.nextToken() );
		
		d = new int[n+1][];
		d[1] = new int[2];
		d[1][0] = d[1][1] = 1;
		for( int i=2; i<=n; i++ ) {
			d[i] = new int[i+1];
			for( int j=0; j<=i; j++ ) {
				if( j==0 || j==i ) d[i][j] = 1;
				else d[i][j] = d[i-1][j-1] + d[i-1][j];
			}
		}
		System.out.println( d[n][k] );
	}
}