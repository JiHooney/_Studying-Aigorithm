package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1010 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t, n, m;
	private static StringTokenizer st;
	
	private static float combi( int a, int b ) {
		if( a==0 || b==0 ) return 0;
		if( a == b ) return 1;
		
		float result = 1;
		
		for( int i=0; i<a; i++ ) {
			result *= ( (float)(b-i) / (float)(a-i) );
			System.out.println(i+" / "+(b-i)+" / "+(a-i)+" / "+result);
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<t; i++ ) {
			st = new StringTokenizer( br.readLine() );
			n = Integer.parseInt( st.nextToken() );
			m = Integer.parseInt( st.nextToken() );
			
			bw.write( (int)combi(n, m) + "\n" );
			bw.flush();
		}
		bw.close();
		br.close();
		
	}
}