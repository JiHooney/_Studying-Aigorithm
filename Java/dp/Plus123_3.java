package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plus123_3 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t, n, div, limit;
	private static long[] d; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		div = 1_000_000_009;
		limit = 1_000_000;
		d = new long[limit+1];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for( int i=4; i<=limit; i++ ) d[i] = (d[i-3] + d[i-2] + d[i-1]) % div; 
		
		t = Integer.parseInt( br.readLine() );
		
		for( int tc=0; tc<t; tc++ ) {
			n = Integer.parseInt( br.readLine() );
			
			bw.write( d[n] + "\n" );
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}