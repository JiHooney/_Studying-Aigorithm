package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PenPineapple {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static String s, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		s = br.readLine();
		
		ans = s.replaceAll( "pPAp", "1" ).replaceAll( "[^0-9]", "" );
		
		bw.write( ans.length() + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}