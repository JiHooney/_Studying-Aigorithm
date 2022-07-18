package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
//BJ1620_1
public class BJ1620_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		
		int n = Integer.parseInt( st.nextToken() );	//도감의 포켓몬 수
		int m = Integer.parseInt( st.nextToken() );	//다솜이가 맞춰야되는 문제의 개수
		String[] book1 = new String[n+1];
		HashMap<String, Integer> book2 = new HashMap<String, Integer>();
		
		for( int i=1; i<=n; i++ ) {
			book1[i] = br.readLine();
			book2.put( book1[i],  i );
		}
		
		StringBuffer sb = new StringBuffer();
		while( m --> 0 ) {
			String input = br.readLine();
			if( '1' <= input.charAt(0) && input.charAt(0) <= '9' )
				sb.append( book1[ Integer.parseInt(input) ] ).append( "\n" );
			else sb.append( book2.get(input) ).append( "\n" );
		}
		System.out.println( sb );
	}
}