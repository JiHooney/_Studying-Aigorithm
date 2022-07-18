package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {
	private static long searchTree( int[] arr, long target ) {
		int start = 0;
		int end = arr[ arr.length-1 ];
		
		while( start <= end ) {
			int mid = (start+end) / 2;
			long tmp = 0;
			
			for( int i=arr.length-1; i>=0; i-- ) {
				if( arr[i] < mid ) continue;
				else tmp += arr[i] - mid;
			}
			
			if( tmp < target ) end = mid - 1;
			else if( tmp >= target ) start = mid + 1; 
			
		}
		return end;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		long m = Integer.parseInt( st.nextToken() );
		
		int[] arr = new int[n];
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) 
			arr[i] = Integer.parseInt( st.nextToken() );
		
		//오름차순 정렬
		Arrays.sort( arr );
		
		System.out.println( searchTree( arr, m ) );
	}
}