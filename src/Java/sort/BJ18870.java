package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( st.nextToken() );
		
		int copyArr[] = new int[n];
		copyArr = arr.clone();
		Arrays.sort( copyArr );
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		int idx = 0;
		for( int i : copyArr ) {
			
			if( !m.containsKey(i) ) {
				m.put( i, idx++ );
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for( int i : arr ) sb.append( m.get(i) ).append( " " );
		
		System.out.println( sb );
	}
}