package string;

import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		ArrayList<Character> all = new ArrayList<Character>();
		all.contains( 'A' );
		
		String[] ss = { "AB", "BC", "CD" };
		for( String s : ss ) {
			
			s.charAt(0);
			
			for( Character c : s.toCharArray() ) {
				System.out.println( c );
			}
		}
	
		
	}
}