package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6064 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );
		StringTokenizer st;
		
		int X=0, Y=0, x=0, y=0;
		for( int i=0; i<t; i++ ) {
			st = new StringTokenizer( br.readLine() );
			X = Integer.parseInt( st.nextToken() );
			Y = Integer.parseInt( st.nextToken() );
			x = Integer.parseInt( st.nextToken() );
			y = Integer.parseInt( st.nextToken() );
			
			boolean ok = false;
			int a = 1, b = 1, cnt = 1;
			while( true ) {
				if( a == X && b == Y ) {
					ok = true;
					break;
				}
				if( a == x && b == y ) break;
				if( a == X ) a = 0;
				if( b == Y ) b = 0;
				a++; b++;
				cnt++;
			}
			
			if( ok ) System.out.println( -1 );
			else System.out.println( cnt );
		}
	}
}