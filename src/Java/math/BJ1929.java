package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		
		StringBuffer sb = new StringBuffer();
		int[] sosu = new int[m+1];
		
		for( int i=2; i<=m; i++ ) {
			if( sosu[i] == 1 ) continue;
			
			for( int j=i*2; j<=m; j+=i ) sosu[j] = 1;
			
			if( i >= n && i <= m ) sb.append( i+"\n" );
		}
		System.out.println( sb );
	}
}