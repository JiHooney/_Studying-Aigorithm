package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ10816 {
	
	private static int chkSearch( int target, ArrayList<Integer> nr ) {
		int ans = 0;
		int start = 0;
		int end = nr.size()-1;

		while( true ) {
			if( start > end ) break;
			if( start == end && nr.get(start) != target ) break;
			
			int mid = (start+end)/2;
			
			if( nr.get(mid) == target ) {
				ans++;
				nr.remove( mid );
				end = nr.size()-1;
				continue;
				
			} else if( nr.get(mid) < target ) start = mid + 1;
			else end = mid;
		}
		
		return ans;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		//n입력 및 nrr 배열 설정
		int n = Integer.parseInt( br.readLine() );
		ArrayList<Integer> nrr = new ArrayList<Integer>(n);
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) nrr.add( Integer.parseInt( st.nextToken() ) );
		
		Collections.sort( nrr );
		
		//m입력 및 입력값에 대한 이분탐색 실시	
		int m = Integer.parseInt( br.readLine() );
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<m; i++ ) {
			ArrayList<Integer> arr = new ArrayList<Integer>(nrr);
			sb.append( chkSearch( Integer.parseInt(st.nextToken()), arr ) + " " );
		}
			
		System.out.println( sb );
	}
}