package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibo {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		d = new int[21];
		d[0] = 0;
		d[1] = 1;
		
		for( int i=2; i<=n; i++ ) d[i] = d[i-1] + d[i-2];
		
		bw.write( d[n] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
