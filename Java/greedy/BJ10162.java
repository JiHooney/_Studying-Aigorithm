package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10162 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t;
	private static final int[] arr = {300, 60, 10};
	private static int[] ans = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<3; i++ ) {
			ans[i] = t/arr[i];
			t -= arr[i]*ans[i];
		}
		if( t!=0 ) {
			bw.write( -1 + "\n" );
		} else {
			for( int i=0; i<3; i++ ) bw.write( ans[i] + " " );
		}
        bw.flush();
		bw.close();
		br.close();
	}
}