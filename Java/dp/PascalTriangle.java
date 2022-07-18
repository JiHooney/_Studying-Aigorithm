package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PascalTriangle {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, k;
	private static int[][] d;
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		k = Integer.parseInt( st.nextToken() );
		
		d = new int[n+1][];

		for( int i=1; i<=n; i++ ) {
			d[i] = new int[i+1];
			for( int j=1; j<=i; j++ ) {
				if( j==1 || j==i ) d[i][j] = 1;
				else d[i][j] = d[i-1][j-1] + d[i-1][j];
			}
		}
		bw.write( d[n][k] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}