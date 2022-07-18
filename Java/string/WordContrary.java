package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WordContrary {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t;
	private static StringBuilder sb, tmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<t; i++ ) {
			st = new StringTokenizer( br.readLine() );
			sb = new StringBuilder();
			
			while( st.hasMoreTokens() ) {
				tmp = new StringBuilder();
				tmp.append( st.nextToken() );
				
				sb.append( tmp.reverse()+" " );
			}
			bw.write( sb.toString() + "\n" );
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
