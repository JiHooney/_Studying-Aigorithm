package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10866 {
	private static String[] deque = new String[10001];
	private static int idx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt( br.readLine() );
		
		StringTokenizer st;
		String order;
		String value = null;
		
		while( n --> 0 ) {
			st = new StringTokenizer( br.readLine() );
			
			order = st.nextToken();
			if( st.countTokens() == 1 ) value = st.nextToken();

			switch( order ) {
			case "push_front":
				if( idx == 0 ) deque[idx++] = value;
				else {
					for( int i=idx; i>0; i-- ) deque[i] = deque[i-1];
					deque[0] = value;
					idx++;
				}
				break;
				
			case "push_back":
				deque[idx++] = value;
				break;
				
			case "pop_front":
				if( idx == 0 ) sb.append( "-1\n" );
				else {
					sb.append( deque[0]+"\n" );
					for( int i=0; i<idx-1; i++ ) deque[i] = deque[i+1];
					idx--;
				}
				break;
				
			case "pop_back":
				if( idx == 0 ) sb.append( "-1\n" );
				else {
					sb.append( deque[--idx]+"\n" );
					deque[idx] = null;
				}
				break;
				
			case "size":
				sb.append( idx+"\n" ); 
				break;
				
			case "empty":
				if( idx == 0 ) sb.append( "1\n" );
				else sb.append( "0\n" );
				break;
				
			case "front":
				if( idx == 0 ) sb.append( "-1\n" );
				else sb.append( deque[0]+"\n" );
				break;
				
			case "back":
				if( idx == 0 ) sb.append( "-1\n" );
				else sb.append( deque[idx-1]+"\n" );
				break;
			}
			
		}
		System.out.println( sb );
	}
}