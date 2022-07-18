package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11866 {
	private static ArrayList<Integer> arr = new ArrayList<Integer>();
	private static int idx;		//arr에서 값을 뽑아내기위한 인덱스값
	private static int k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		k = Integer.parseInt( st.nextToken() );
		
		//1부터 n까지 리스트에 삽입
		for( int i=1; i<=n; i++ ) arr.add( i );
		
		//최종 출력에 사용될 StringBuffer
		StringBuffer sb = new StringBuffer(); 
		sb.append( "<" );
		
		while( true ) {	//arr가 비어있지 않으면 계속 반복
			
			idx = ( idx + (k-1) ) % arr.size();
			sb.append( arr.get( idx ) );
			arr.remove( idx );
			
			if( arr.isEmpty() ) break;
			sb.append( ", " );
		}
		
		sb.append( ">" );
		System.out.println( sb );
	}
}