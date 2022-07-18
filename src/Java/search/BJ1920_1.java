package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1920_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		int n = Integer.parseInt( br.readLine() );
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) hm.put( st.nextToken(), 0 );
		
		int m = Integer.parseInt( br.readLine() );
		String[] marr = new String[m];
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<m; i++ ) marr[i] = st.nextToken();
		
		StringBuffer sb = new StringBuffer();
		for( String s : marr ) {
			if( hm.containsKey( s ) ) sb.append( "1\n" );
			else sb.append( "0\n" );
		}
		System.out.println( sb );
	}
}