package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
			boolean wh = false;
			if( Y == y ) wh = true;
			
			for( int j=x; j<(X*Y); j += X ) {
				if( wh ) {
					if( j%Y == y || j%Y == 0 ) {
						System.out.println( j );
						ok = true;
						break;
					}
				} else {
					if( j%Y == y ) {
						System.out.println( j );
						ok = true;
						break;
					}
				}
				
			}
			if( !ok ) System.out.println( -1 );
			
			
		}
	}
}