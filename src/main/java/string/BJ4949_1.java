package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4949_1 {
	public static String solve( String s ) {
		char[] stack = new char[ s.length() ];
		int size = 0;
		
		for( char v : s.toCharArray() ) {
			if( v=='(' || v=='[' ) stack[size++] = v;
			else if( v==')' ) {
				if( size == 0 || stack[size-1] != '(' ) return "no";
				else size--;
			} else if( v==']' ) {
				if( size == 0 || stack[size-1] != '[' ) return "no";
				else size--;
			}
		}
		if( size != 0 ) return "no";
		else return "yes";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String s;
		
		while( true ) {
			s = br.readLine();
			if( s.equals(".") ) break;
			
			sb.append( solve(s) ).append('\n');
		}
		
		System.out.println( sb );
	}
}