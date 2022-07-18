package sort;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		StringTokenizer st;
		
		Point[] arr = new Point[n];
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			arr[i] = new Point( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
		}
		
		Arrays.sort( arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if( o1.y == o2.y ) return o1.x - o2.x;
				else return o1.y - o2.y;
			}
		});
		
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<n; i++ ) sb.append( arr[i].x+" "+arr[i].y+"\n" );
		System.out.println( sb );
	}
}