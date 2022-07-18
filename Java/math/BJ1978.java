package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1978 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, sum;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) {
			int num = Integer.parseInt( st.nextToken() );
			
			for( int j=2; j<=num; j++ ) {
				if( j!=num && num%j==0 ) break;
				else if( j==num && num%j==0 ) sum++;
			}
		}
		bw.write( sum + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}