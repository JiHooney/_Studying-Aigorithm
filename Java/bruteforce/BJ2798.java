package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2798 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, m, sum, ans;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		
		arr = new int[n];

		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( st.nextToken() );
		
		l:for( int i=0; i<n; i++ ) {
			for( int j=1; j<n; j++ ) {
				if( j==i ) continue;
				
				for( int k=2; k<n; k++ ) {
					if( k==i || k==j ) continue;
					
					sum = arr[i] + arr[j] + arr[k];
					
					if( sum > m ) continue;
					else if( sum == m ) {
						ans = sum; 
						break l;
					} else if( m-sum <= m-ans ) ans = sum;
					
				}
			}
		}
		bw.write( ans + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}