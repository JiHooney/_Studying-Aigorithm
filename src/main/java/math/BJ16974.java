package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ16974 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, sum;
	private static long x;
	private static StringTokenizer st;
	private static String[] d;
	private static StringBuffer sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		x = Long.parseLong( st.nextToken() );
		
		d = new String[n+1];
		sb = new StringBuffer();
		d.append( "bpppb" );
		for( int i=2; i<=n; i++ ) d.append( "b"+d.charAt(i-1)+"p"+d.charAt(i-1)+"b" );

		for( long i=1; i<=x; i++ ) if( d[n].charAt((int)i) == 'p' ) sum++;
		
		bw.write( sum + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}