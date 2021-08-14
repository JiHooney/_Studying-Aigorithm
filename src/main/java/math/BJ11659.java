package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		
		long[] arr = new long[n+1];
		st = new StringTokenizer( br.readLine() );
		long sum = 0;
		for( int i=1; i<=n; i++ ) {
			sum += Integer.parseInt( st.nextToken() );
			arr[i] = sum;
		}
		
		StringBuilder sb = new StringBuilder();
		while( m --> 0 ) {
			st = new StringTokenizer( br.readLine() );
			int a = Integer.parseInt( st.nextToken() );
			int b = Integer.parseInt( st.nextToken() );
			
			sb.append( arr[b] - arr[a-1] ).append( "\n" );
		}
		System.out.println( sb );
	}
}