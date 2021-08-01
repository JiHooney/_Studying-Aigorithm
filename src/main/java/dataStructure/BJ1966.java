package dataStructure;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );
		int n, m;
		StringTokenizer st;
		
		for( int i=0; i<t; i++ ) {
			st = new StringTokenizer( br.readLine() );
			n = Integer.parseInt( st.nextToken() );
			m = Integer.parseInt( st.nextToken() );
			
			//입력받은 값들을 ArrayList에 저장
			ArrayList<Point> que = new ArrayList<Point>();
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<n; j++ ) 
				que.add( new Point( j, Integer.parseInt( st.nextToken() ) ) );
			
			//j위치의 값보다 큰 값이 있을 경우 j위치 값을 뒤에 삽입
			for( int j=0; j<n-1; j++ ) {
				for( int k=j+1; k<n; k++ ) {
					if( que.get(j).y < que.get(k).y ) {
						que.add( que.get(j) );
						que.remove( j );
						k = j;
					}
				}
			}
			
			//m값과 같은 point.x값을 출력
			for( int j=0; j<n; j++ ) {
				if( m == que.get( j ).x ) {
					System.out.println( j+1 );
					break;
				}
			}
		}
		
	}
}