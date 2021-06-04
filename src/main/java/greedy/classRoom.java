package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class classRoom {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 1;	//강의실개수(최종결과값)
		
		int N = Integer.parseInt( br.readLine() );	//수업개수
		
		ArrayList<ArrayList<Integer>> Ss = new ArrayList<ArrayList<Integer>>();	//<<수업개수,수업시작끝값>>
		
		for( int i=0; i<N; i++ ) {	//수업시작끝값 insert
			StringTokenizer st = new StringTokenizer( br.readLine(), " " );
			ArrayList<Integer> ss = new ArrayList<Integer>();
			
			ss.add( Integer.parseInt( st.nextToken() ) );
			ss.add( Integer.parseInt( st.nextToken() ) );
			
			Ss.add( ss );
		}
		
		//수업시작값을 기준으로 오름차순 정렬
		Comparator<ArrayList<Integer>> myCom = new Comparator<ArrayList<Integer>>() {
		
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				if( o1.get(0) == o2.get(0) ) 
					return o1.get(1) - o2.get(1);
				else 
					return o1.get(0) - o2.get(0);
			}
		};
		Collections.sort( Ss, myCom );
		
		int t = 2;	//0: while문 반복, 1: result증가, 2: while문 종료
		
		 do {
			t = 2;
			int i = 0;
			for( i = 0; i<Ss.size()-1; i++ ) {
				for( int j=i; j<Ss.size()-1; j++ ) {
					System.out.println( i+" / "+j+" / ("+Ss.get(i).get(1)+", "+Ss.get(j+1).get(0)+") /" );
					if( Ss.get(i).get(1) == Ss.get(j+1).get(0) ) {
						t = 1;
						Ss.remove(i);
						i = j;
						j -= 1;
						System.out.println( "t : " + t);
					}
				}
				if( i == Ss.size()-1 ) {
					result++;
					System.out.println( "나 지워짐 : " + Ss.get(i) );
					Ss.remove(i);
				}
			}
			
			System.out.println( "반복끝" );
			if( t == 1 ) {
				t = 0;
			}
		} while( t == 0 );
		
		System.out.println( result );
		
	}
}