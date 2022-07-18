package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1010 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t, n, m;
	private static int[][] d;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<t; i++ ) {
			st = new StringTokenizer( br.readLine() );
			n = Integer.parseInt( st.nextToken() );
			m = Integer.parseInt( st.nextToken() );
			
			d = new int[m+1][];
			for( int j=1; j<=m; j++ ) {
				d[j] = new int[j+1];
				for( int k=0; k<=j; k++ ) {
					if( k==0 || k==j ) d[j][k] = 1;
					else d[j][k] = d[j-1][k-1] + d[j-1][k];
				}
			}
			
			bw.write( d[m][n] +  "\n" );
			bw.flush();
		}
		bw.close();
		br.close();
		
	}
}