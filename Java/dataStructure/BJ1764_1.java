package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1764_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		
		HashSet<String> hs = new HashSet<String>();
		for( int i=0; i<n; i++ ) hs.add( br.readLine() );
		
		ArrayList<String> arr = new ArrayList<String>();
		int ans = 0;
		String tmp = "";
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<m; i++ ) {
			tmp = br.readLine();
			if( hs.contains( tmp ) ) {
				ans++;
				arr.add( tmp );
			}
		}
		
		Collections.sort( arr );
		for( int i=0; i<arr.size(); i++ ) sb.append( arr.get(i) ).append( "\n" );
		System.out.println( ans+"\n"+sb );
	}
}