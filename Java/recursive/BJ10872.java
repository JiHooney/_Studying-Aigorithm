package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10872 {
	
	public static int recur( int a ) {
		
		if( a <= 1 ) return 1;
		
		return a * recur( a-1 );
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println( recur(n) );
	}
}