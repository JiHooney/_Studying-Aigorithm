package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1874_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		StringBuffer sb = new StringBuffer();
		Stack<Integer> s = new Stack<Integer>();
		
		int start = 0;
		while( n --> 0 ) {
			int val = Integer.parseInt( br.readLine() );
			
			if( val > start ) {
				for( int i=start+1; i<=val; i++ ) {
					s.push( i );
					sb.append( "+\n" );
				}
				start = val;
			} else if( s.peek() != val ) {
				System.out.println( "NO" );
				return;
			}
			
			s.pop();
			sb.append( "-\n" );
			
		}
		System.out.println( sb );
	}
}