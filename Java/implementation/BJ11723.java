package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt( br.readLine() );
		
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		String order;
		int x;
		int bitMask = 0;
		
		while( m --> 0 ) {
			x = 0;
			st = new StringTokenizer( br.readLine() );
			order = st.nextToken();
			if( st.countTokens()==1 ) x = Integer.parseInt( st.nextToken() );
			
			switch( order ) {
				case "add":
					bitMask = bitMask | 1<<(x-1);
					break;
					
				case "remove":
					bitMask = bitMask & ~( 1<<(x-1) );
					break;
					
				case "check":
					sb.append( ( ( bitMask & 1<<(x-1) ) == 1<<(x-1) ? 1:0) + "\n" );
					break;
					
				case "toggle":
					bitMask = bitMask ^ 1<<(x-1);
					break;
					
				case "all":
					bitMask = ~0;
					break;
					
				case "empty":
					bitMask = 0;
					break;
			}
		}
		System.out.println( sb );
	}
}