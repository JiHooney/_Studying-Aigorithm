package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		int[] arr = new int[10_001];
		
		for( int i=0; i<n; i++ ) arr[ Integer.parseInt(br.readLine()) ]++;
		
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<arr.length; i++ ) {
			if( arr[i] != 0 ) {
				for( int j=arr[i]; j>0; j-- ) sb.append( i + "\n" );
			}
		}
		System.out.println( sb );
	}
}