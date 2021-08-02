package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		long m = Integer.parseInt( st.nextToken() );
		
		int[] arr = new int[n];
		int max = 0;
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) {
			arr[i] = Integer.parseInt( st.nextToken() );
			max = Math.max( max, arr[i] );
		}
		
		long start = 0;
		long end = max;
		
		while( start <= end ) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for( int a : arr ) 
				if( a > mid ) sum += a - mid;
			
			if( sum >= m ) start = mid + 1;
			else end = mid - 1;
		}
		
		System.out.println( end );
	}
}