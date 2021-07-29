package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ10828 {
	private static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	private static void stack( String order, int a ) {
		arr.add( a );
	}
	
	private static String stack( String order ) {
		
		if( order.equals("top") ) {
			if( arr.size() == 0 ) return "-1";
			else return arr.get( arr.size()-1 )+"";
			
		} else if( order.equals("size") ) {
			return arr.size()+"";
			
		} else if( order.equals("empty") ) {
			if( arr.size() == 0 ) return "1";
			else return "0";
			
		} else { //if( order.equals("pop") )
			if( arr.size() == 0 ) return "-1";
			else {
				int tmp = arr.get( arr.size()-1 );
				arr.remove( arr.size()-1 );
				return tmp+"";
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt( br.readLine() );
		
		String order;
		
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			
			if( st.countTokens() == 2 ) {
				order = st.nextToken();
				int a = Integer.parseInt( st.nextToken() );
				stack( order, a );
				
			} else {
				order = st.nextToken();
				sb.append( stack( order ) + "\n" );
			}
		}
		
		System.out.println( sb );
	}
}