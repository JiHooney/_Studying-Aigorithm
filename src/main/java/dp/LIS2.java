package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS2 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, result;
	private static int[] a, d;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		a = new int[n+1];
		d = new int[n+1];
		d[1] = 1;
		
		st = new StringTokenizer( br.readLine() );
		for( int i=1; i<=n; i++ ) a[i] = Integer.parseInt( st.nextToken() );
		
		for( int i=2; i<=n; i++ ) {
			d[i] = 1;
			for( int j=1; j<i; j++ ) 
				if( a[i]>a[j] && d[i]<=d[j] ) d[i] = d[j]+1;
		}
		
		for( int i : d ) result = Math.max( result, i );
		
		bw.write( result + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}//main end
}