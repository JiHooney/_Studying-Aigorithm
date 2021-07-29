package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10845 {
	static String[] que;
	static int idx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt( br.readLine() );
		que = new String[n];
		
		String order;
		while( n --> 0 ) {
			order = br.readLine();
			
			switch( order.charAt(0) ) {
			case 'p':
				if( order.charAt(1) == 'u' ) que[idx++] = order.substring( 5 );
				
				else {
					if( idx == 0 ) sb.append( "-1\n" );
					else {
						sb.append( que[0] + "\n" );
						for( int i=0; i<idx-1; i++ ) que[i] = que[i+1];
						que[--idx] = null;
					}
				}
				break;
				
			case 's':
				sb.append( idx+"\n" );
				break;
				
			case 'e':
				if( idx == 0 ) sb.append( "1\n" );
				else sb.append( "0\n" );
				break;
				
			case 'f':
				if( idx == 0 ) sb.append( "-1\n" );
				else sb.append( que[0] + "\n" );
				break;
				
			case 'b':
				if( idx == 0 ) sb.append( "-1\n" );
				else sb.append( que[idx-1] + "\n" );
				break;
				
			}
		}//while end
		
		System.out.println( sb );
	}
}