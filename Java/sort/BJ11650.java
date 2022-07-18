package sort;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		StringTokenizer st;
		
		//point라는 객체는 int x, int y를 필드로 가지는 클래스이다. 이를 활용한다.
		//사용자 객체를 만들어도 되지만 귀찮으니깐 ㅎ
		Point[] arr = new Point[n];
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			
			//Point객체의 생성자 형식에 맞게 new Point( x, y ) 형식으로 데이터를 집어넣는다.
			arr[i] = new Point( Integer.parseInt( st.nextToken() ), Integer.parseInt( st.nextToken() ) );
		}
		
		//이제 arr배열을 x좌표 오름차순으로 정렬하되 x좌표가 같을 경우 y좌표를 오름차순으로 정렬하기 위해
		//Arrays.sort 메소드에 Comparator 인터페이스의 compare메소드를 재정의해서 
		//조건에 맞도록 정렬한다.
		Arrays.sort( arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if( o1.x==o2.x ) return o1.y - o2.y;
				else return o1.x - o2.x;
			}
		});
		
		//출력속도를 향상시키기 위해 StringBuffer에 출력값을 모두 저장했다가
		//한꺼번에 출력한다.
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<n; i++ ) sb.append( arr[i].x + " " + arr[i].y + "\n" );
		System.out.println( sb );
	}
}