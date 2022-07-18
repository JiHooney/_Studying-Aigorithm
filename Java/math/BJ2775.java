package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2775 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t, k, n;
	private static int[][] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<t; i++ ) {
			k = Integer.parseInt( br.readLine() );
			n = Integer.parseInt( br.readLine() );
			
			d = new int[k+1][n];
			int a = 1;
			for( int j=0; j<=k; j++ ) {
				for( int z=0; z<n; z++ ) {
					if( j==0 ) d[j][z] = a++;
					else if( z==0 ) d[j][z] = 1;
					else d[j][z] = d[j][z-1] + d[j-1][z];
				}
			}
			bw.write( d[k][n-1] + "\n" );
			bw.flush();
		}
		bw.close();
		br.close();
	}
}