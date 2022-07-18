package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		
		HashMap<String, Integer> hs1 = new HashMap<String, Integer>();
		for( int i=0; i<n; i++ ) hs1.put( br.readLine(), 1 );
		
		ArrayList<String> arr = new ArrayList<String>();
		int ans = 0;
		for( int i=0; i<m; i++ ) {
			String tmp = br.readLine();
			hs1.put( tmp, hs1.getOrDefault( tmp, 0 ) + 1 );
			if( hs1.get(tmp) > 1 ) {
				arr.add( tmp );
				ans++;
			}
		}
		Collections.sort( arr );
		
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<arr.size(); i++ ) sb.append( arr.get(i) ).append( "\n" );
		
		System.out.println( ans+"\n"+sb );
	}
}