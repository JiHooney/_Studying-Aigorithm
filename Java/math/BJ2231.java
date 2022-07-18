package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2231 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, sum, res;
	private static String tmp = "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		tmp = String.valueOf( n );
		
		int len = n-(tmp.length()*9);
		if( len <= 0 ) len = 1;
		
		for( int i=len; i<n; i++ ) {
			tmp = String.valueOf( i );
			
			sum = i;
			for( int j=0; j<tmp.length(); j++ ) sum += tmp.charAt(j)-'0';
			
			if( n == sum ) {
				res = i;
				break;
			} else continue;
		}
		bw.write( res + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}