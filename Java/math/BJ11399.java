package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		int[] p = new int[n];
		StringTokenizer st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) p[i] = Integer.parseInt( st.nextToken() );
		
		Arrays.sort( p );
		int sum = p[0];
		int tmp = p[0];
		for( int i=1; i<n; i++ ) {
			tmp += p[i];
			sum += tmp;
		}
		
		System.out.println( sum );
	}
}