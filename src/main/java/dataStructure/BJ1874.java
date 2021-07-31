package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );

		int[] arr = new int[n];
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( br.readLine() );
		
		StringBuffer sb = new StringBuffer();
		Stack<Integer> s = new Stack<Integer>();
		
		int[] ans = new int[n];
		int idx = 0;
		int i = 1;
		int j = 0;
		while( !s.isEmpty() || i <= n ) {
			if( i > n ) {
				ans[j] = s.pop();
				sb.append( "-\n" );
				if( ans[j] != arr[j] ) {
					sb = new StringBuffer();
					sb.append( "NO\n" );
					break;
				}
				j++;
				
			} else if( i <= arr[idx] ) {
				sb.append( "+\n" );
				s.add( i++ );
			} else {
				ans[j] = s.pop();
				sb.append( "-\n" );
				idx++;
				
				if( ans[j] != arr[j] ) {
					sb = new StringBuffer();
					sb.append( "NO\n" );
					break;
				}
				j++;
			}
		}
		
		System.out.println( sb );
	}
}