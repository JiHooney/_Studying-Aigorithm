package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ6588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//소수구하기 - 에라토스테네스의 체 이용
		boolean[] sosu = new boolean[1_000_001];
		for( int i=2; i<=1_000_000; i++ ) sosu[i] = true;
		
		for( int i=2; i<=1_000_000; i++ ) {
			for( int j=i*2; j<=1_000_000; j += i ) {
				if( !sosu[j] ) continue;
				sosu[j] = false;
			}
		}
		
		while( true ) {
			int n = Integer.parseInt( br.readLine() );
			if( n == 0 ) break;
			
			boolean ok = false;
			for( int i=2; i<=n/2; i++ ) {
				if( sosu[i] && sosu[n-i] ) {
					System.out.println( n + " = " + i + " + " + (n-i) );
					ok = true;
					break;
				}
			}
			
			if( !ok ) System.out.println( "Goldbach's conjecture is wrong." );
		}
		
	}
}