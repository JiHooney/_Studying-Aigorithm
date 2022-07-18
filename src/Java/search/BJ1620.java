package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		
		int n = Integer.parseInt( st.nextToken() );	//도감의 포켓몬 수
		int m = Integer.parseInt( st.nextToken() );	//다솜이가 맞춰야되는 문제의 개수
			
		//도감 만들기
		HashMap<Integer, String> book1 = new HashMap<Integer, String>();
		HashMap<String, Integer> book2 = new HashMap<String, Integer>();
		for( int i=1; i<=n; i++ ) {
			String tmp = br.readLine();
			book1.put( i, tmp );
			book2.put( tmp, i );
		}
		
		//문제 맞히기
		StringBuffer sb = new StringBuffer();
		int num;
		String name;
		while( m --> 0 ) {
			num = 0; name = null;
			try {
				name = br.readLine();
				num = Integer.parseInt( name );
			} catch (NumberFormatException e) {}
			
			if( num != 0 ) sb.append( book1.get(num)+"\n" );
			else sb.append( book2.get(name)+"\n" );
		}
		
		System.out.println( sb );
	}
}