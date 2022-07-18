package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling2xn2 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int n;	//가로길이
	private static int[] d;	//dp배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		d = new int[n+1];
		d[0] = d[1] = 1;
		
		for( int i=2; i<=n; i++ ) d[i] = (d[i-1] + d[i-2] * 2) % 10007;

		bw.write( d[n] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
