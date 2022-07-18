package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuyingCard2 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		
		d = new int[n+1];
		for( int i=2; i<=n; i++ ) d[i] = 10001;
		d[1] = p[1];
		
		for( int i=2; i<=n; i++ ) {
			for( int j=0; j<i; j++ ) {
				d[i] = Math.min( d[i], d[j]+p[i-j] );
			}
		}
		
		bw.write( d[n] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
