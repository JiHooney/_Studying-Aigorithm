package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( st.nextToken() );
		
		StringBuilder sb = new StringBuilder();
		
		int ans = 0;
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for( int i=0; i<n; i++ ) {
			ans = 0;
			for( int j=0; j<n; j++ ) {
				if( i==j ) continue;
				if( !hs.containsKey( arr[j] ) && arr[i] > arr[j] ) {
					hs.put( arr[j], 1 );
					ans++;
				}
			}
			sb.append( ans ).append( " " );
		}
		
		System.out.println( sb );
	}
}