package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LeaveCop {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, max;
	private static int[] t, p, d;
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		max = Integer.MIN_VALUE;
		t = new int[n+1];
		p = new int[n+1];
		d = new int[n+1];
		
		for( int i=1; i<=n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			t[i] = Integer.parseInt( st.nextToken() );
			p[i] = Integer.parseInt( st.nextToken() );
		}
		
		for( int i=1; i<=n; i++ ) {
			max = Math.max( max, d[i-1] );
			
			if( i-1+t[i]<=n ) {
				d[ i-1+t[i] ] = Math.max( max+p[i],  d[ i-1+t[i] ] );
			}
		}
		
		bw.write( Arrays.stream(d).max().getAsInt() + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
		
	}
}