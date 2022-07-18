package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ10610 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int sum = 0;
		int val = 0;
		
		for( int i=0; i<N.length(); i++ ) {
			val = N.charAt(i) - '0';
			sum += val;
			list.add( val );
		}
		
		Collections.sort( list );
		
		StringBuffer sb = new StringBuffer();
		
		if( list.get(0) != 0 || sum % 3 != 0 ) {
			System.out.println( "-1" );
		} else {
			for( int i=list.size()-1; i>=0; i-- ) {
				sb.append( list.get(i) );
			}
			System.out.println( sb );
		}
		

	}

}
