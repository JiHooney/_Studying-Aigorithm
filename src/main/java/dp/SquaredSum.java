package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SquaredSum {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, j, tmp;
	private static int[] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		d = new int[n+1];
		for( int i=1; i<=n; i++ ) {
			tmp = i;
			j = (int)Math.pow( i, 0.5 );
			while( j >= 1 ) {
				tmp = Math.min( tmp, d[i-(int)Math.pow(j, 2)] );
				j--;
			}
			d[i] = tmp+1;
		}
		bw.write( d[n] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
