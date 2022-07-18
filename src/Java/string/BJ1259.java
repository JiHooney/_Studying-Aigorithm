package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1259 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static String n, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while( true ) {
			n = br.readLine();
			if( n.equals("0") ) break;
			
			ans = "yes";
			for( int i=0; i< n.length()/2; i++ ) {
				if( n.charAt(i) != n.charAt(n.length()-i-1) ) {
					ans = "no";
					break;
				}
			}
			bw.write( ans + "\n" );
			bw.flush();
		}
		bw.close();
		br.close();
	}
}