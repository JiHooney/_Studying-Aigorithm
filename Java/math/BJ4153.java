package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ4153 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int[] s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while( true ) {
			int[] s = new int[3];
			StringTokenizer st = new StringTokenizer( br.readLine() );
			s[0] = Integer.parseInt( st.nextToken() );
			s[1] = Integer.parseInt( st.nextToken() );
			s[2] = Integer.parseInt( st.nextToken() );
			if( s[0]==0 ) break;
			
			Arrays.sort( s );
			
			if( s[0]*s[0] + s[1]*s[1] == s[2]*s[2] ) bw.write( "right\n" );
			else bw.write( "wrong\n" );
			bw.flush();
		}
		bw.close();
		br.close();
	}
}