package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Sugar1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		d = new int[5001];
		Arrays.fill( d, 5000 );
		if( n<5 ) {
			if( n == 3) {
				bw.write( 1 + "\n" );
				bw.flush();
			} else {
				bw.write( -1 + "\n" );
				bw.flush();
			}
			return;
		}
		
		d[3] = d[5] = 1;
		
		for( int i=6; i<=n; i++ ) d[i] = Math.min( d[i-3]+1, d[i-5]+1 );
		
		if( d[n] > 5000) {
			bw.write( -1 + "\n" );
			bw.flush();
		} else {
			bw.write( d[n] + "\n" );
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
