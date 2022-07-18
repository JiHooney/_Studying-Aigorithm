package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyingCard1 {
	private static int n;
	private static int[] p;
	private static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		p = new int[n+1];	//카드팩의 가격
		d = new int[n+1];	//dp배열
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		for( int i=1; i<=n; i++ ) p[i] = Integer.parseInt( st.nextToken() );
		
		d[0] = p[0];
		for( int i=1; i<=n; i++ ) {
			for( int j=1; j<=i; j++ ) {
				d[i] = Math.max( d[i] ,d[i-j]+p[j] );
			}
		}
		
		System.out.println( d[n] );
		
	}
}
