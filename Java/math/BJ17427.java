package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17427 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		long ans = 0;
		
		for( int i=1; i<=n; i++ ) ans += ( n/i ) * i;
		
		System.out.println( ans );
	}
}