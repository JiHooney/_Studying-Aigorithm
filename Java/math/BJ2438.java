package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2438 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		for( int i=0; i<9; i++ ) {
			int a = Integer.parseInt( br.readLine() );
			if( max <= a ) {
				max = a;
				idx = i+1;
			}
		}
		System.out.println( max+"\n"+idx );
	}
}