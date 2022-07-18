package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10818 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for( int i=0; i<n; i++ ) {
			int a = Integer.parseInt(st.nextToken());
			if( a < min ) min = a;
			if( a > max ) max = a;
		}
		System.out.println( min+" "+max );
	}
}