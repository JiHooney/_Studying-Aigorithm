package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plus123_2 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t, n, div, limit, sum;
	private static int[][] d;	//정수 n이 만들어지는 개수가 담길 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		div = 1_000_000_009;
		limit = 100_000;
		d = new int[limit+1][4];
		d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;
		
		for( int j=4; j<=limit; j++ ) {
			for( int k=1; k<=3; k++ ) {
				if( k==1 ) d[j][k] = ( d[j-1][2] + d[j-1][3] )% div;
				else if( k==2 ) d[j][k] = ( d[j-2][1] + d[j-2][3] )% div;
				else if( k==3 ) d[j][k] = ( d[j-3][1] + d[j-3][2] )% div;
				d[j][k] %= div;
			}
		}	
		
		t = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<t; i++ ) {
			n = Integer.parseInt( br.readLine() );
			sum = 0;
			
			for( int j=1; j<=3; j++ ) {
				sum += d[n][j];
				sum %= div;
			}
			bw.write( sum + "\n" );
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
