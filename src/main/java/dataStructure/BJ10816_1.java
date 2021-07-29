package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10816_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		//n입력 및 해시맵 선언
		int n = Integer.parseInt( br.readLine() );
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) {
			int a = Integer.parseInt( st.nextToken() );
			//해시맵 키 중에 a가 있으면 a키값+1, 없으면 1로 put
			hm.put( a, hm.getOrDefault(a, 0)+1 );
		}
		
		int m = Integer.parseInt( br.readLine() );
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<m; i++ ) {
			int a = Integer.parseInt(st.nextToken());
			//hm해시맵에 a키가 있으면 a키의 값을 sb에 append하고 없으면 0을 append한다.
			if( hm.containsKey( a ) ) sb.append( hm.getOrDefault( a, 0 ) + " " );
			else sb.append( 0 + " " );
		}
		System.out.println( sb );
	}
}