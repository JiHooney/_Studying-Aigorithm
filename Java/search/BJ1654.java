package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {
	private static boolean chk( long[] a, int n, long mid ) {
		int cnt = 0;
		for( int i=0; i<a.length; i++ ) cnt += a[i] / mid;
		return cnt >= n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int k = Integer.parseInt( st.nextToken() );	//가지고 있는 랜선개수
		int n = Integer.parseInt( st.nextToken() );	//필요한 랜선의 개수
		
		long arr[] = new long[k];
		long max = 0;
		for( int i=0; i<k; i++ ) {
			arr[i] = Integer.parseInt( br.readLine() );
			max = Math.max( max, arr[i] );
		}
		
		long ans = 0;
		long start = 1;
		long end = max;
		while( start <= end ) {
			long mid = (start+end) / 2;
			if( chk( arr, n, mid ) ) {
				ans = Math.max( ans, mid );
				start = mid + 1;
			} else end = mid - 1;
			
		}
		
		System.out.println( ans );
		
	}
}