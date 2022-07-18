package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2869 {
	private static int a, b, v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		a = Integer.parseInt( st.nextToken() );
		b = Integer.parseInt( st.nextToken() );
		v = Integer.parseInt( st.nextToken() );
		
		int result = (v-b) / (a-b);
		if( (v-b)%(a-b) != 0 ) System.out.println( ++result );
		else System.out.println( result ); 
	}
}