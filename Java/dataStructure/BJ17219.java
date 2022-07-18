package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ17219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		
		HashMap<String, String> hs = new HashMap<String, String>();		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			hs.put( st.nextToken(), st.nextToken() );
		}
		
		StringBuffer sb = new StringBuffer();
		String tmp = "";
		for( int i=0; i<m; i++ ) {
			tmp = br.readLine();
			sb.append( hs.get(tmp) ).append( "\n" );
		}
		System.out.println( sb );
	}
}