package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, result;
	private static int[] a, d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt( br.readLine() );
		a = new int[n+1];
		d = new int[n+1];
		
		st = new StringTokenizer( br.readLine() );
		for( int i=1; i<=n; i++ ) a[i] = Integer.parseInt( st.nextToken() );
		
		d[1] = a[1];
		for( int i=2; i<=n; i++ ) {
			d[i] = a[i];
			for( int j=1; j<i; j++ ) {
				if( a[i] > a[j] ) d[i] = Math.max( d[i], d[j]+a[i] );
			}
		}
		
		for( int i=1; i<=n; i++ ) result = Math.max( result, d[i] );
		
		bw.write( result + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
