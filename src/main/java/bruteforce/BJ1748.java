package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1748 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		int ans = 0;
		int tmp = 1;
		int len = 10;
		for( int i=1; i<=n; i++ ) {
			if( i == len ) {
				tmp++;
				len *= 10;
			}
			ans += tmp;
		}
		System.out.println( ans );
		
	}
}