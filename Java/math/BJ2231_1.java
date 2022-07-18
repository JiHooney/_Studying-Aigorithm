package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2231_1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, sum, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		String tmp = String.valueOf( n );
		int len = n-(tmp.length()*9);
		if( len <= 0 ) len = 1;
		
		for( int i=len; i<n; i++ ) {
			int num = i;
			
			sum = 0;
			while( num != 0 ) {
				sum += num%10;
				num /= 10;
			}
			if( sum+i==n ) {
				res = i;
				break;
			}
		}
		
		bw.write( res + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}