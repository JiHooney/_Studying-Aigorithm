package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		int[][] arr = new int[n][2];
		StringTokenizer st;
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			arr[i][0] = Integer.parseInt( st.nextToken() );
			arr[i][1] = Integer.parseInt( st.nextToken() );
		}
		
		StringBuffer sb = new StringBuffer();
		int sum;
		for( int i=0; i<n; i++ ) {
			sum = n;
			for( int j=0; j<n; j++ ) {
				if( i==j ) continue;				
				if( arr[i][0] >= arr[j][0] || arr[i][1] >= arr[j][1] ) sum--;
			}
			sb.append( sum + " " );
		}
		System.out.println( sb );
	}
}