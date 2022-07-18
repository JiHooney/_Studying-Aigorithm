package hashing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ15829 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int l;
	private static long sum;
	private static String s;
	private static int r = 31;
	private static final int m = 1_234_567_891; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		l = Integer.parseInt( br.readLine() );
		s = br.readLine();
		
		long tmp = 1;
		for( int i=0; i<s.length(); i++ ) {
			sum = ( sum + ((s.charAt(i)-'a'+1 ) * tmp) ) % m;
			tmp = (tmp * r) % m;
		}
		
		bw.write( sum%m + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}