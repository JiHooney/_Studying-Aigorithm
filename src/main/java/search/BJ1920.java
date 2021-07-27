package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {
	
	private static int Search( int[] arr, int target, int start, int end ) {
		int a = 0;
		
		while( start <= end ) {
			if( start == end && arr[start] != target ) break;
			int mid = (start+end)/2;
			
			if( arr[mid] == target ) {
				a = 1; 
				break;
			} else if( arr[mid] < target ) start = mid + 1;
			else end = mid - 1;
		}
		
		return a;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt( br.readLine() );
		int[] arr = new int[n];
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( st.nextToken() );
		
		int m = Integer.parseInt( br.readLine() );
		int[] brr = new int[m];
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<m; i++ ) brr[i] = Integer.parseInt( st.nextToken() );
		
		//arr 배열 오름차순 정렬
		Arrays.sort( arr );
		
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<brr.length; i++ ) 
			sb.append( Search( arr, brr[i], 0, arr.length-1 )+"\n" );
		System.out.println( sb );
	}
}