package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ10250 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t, h, w, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt( br.readLine() );
		for( int i=0; i<t; i++ ) {
			st = new StringTokenizer( br.readLine() );
			h = Integer.parseInt( st.nextToken() );
			w = Integer.parseInt( st.nextToken() );
			n = Integer.parseInt( st.nextToken() );
			
			if( n%h==0 ) bw.write( ( ( n-h * ((n/h)-1) ) * 100 )+(n/h) + "\n" );
			else bw.write( ( ( n-h * (n/h) )*100 )+( (n/h)+1 ) + "\n" );
			bw.flush();
		}
		bw.close();
		br.close();
	}
}