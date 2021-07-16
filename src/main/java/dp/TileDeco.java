package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TileDeco {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static long[] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		d = new long[81];
		d[1] = 4;
		d[2] = 6;
		for( int i=3; i<=n; i++ ) d[i] = d[i-2] + d[i-1];
		
		bw.write( d[n] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}