package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ2292 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static ArrayList<Integer> d = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		d.add( 0 );
		d.add( 1 );
		int i = 1;
		while( n > d.get(i) ) {
			d.add( d.get(i) + (6*i) );
			i++;
		}
		bw.write( i + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}