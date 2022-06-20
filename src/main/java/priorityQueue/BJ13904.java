package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;



/*
1일부터 가능한 과제들을 나열해보고 점수를 계산해본다.
1일에는 전체 과제를 다 할 수 있다.
2일에는 1일날 과제는 마감돼서 못하고 2~6일까지 과제를 다 할 수 있다.
3일에는 1, 2일날 과제는 마감돼서 못하고 3~6일까지 과제를 다 할 수 있다.

		가능한 과제					
1일: 	60 50 40 30 20 10 5		
2일:		60 50 40 30 10 5		(1일날 과제 마감돼서 제거)
3일: 	60 40 10 5				(2일날 과제 마감돼서 제거)
4일:		60 40 10 5				(3일날 과제 마감돼서 제거)
5일:		주어진 과제 없음
6일: 	5						(4일날 과제 마감돼서 제거)

그러면 점수를 내림차순으로 바꾸면 아래와 같이 된다.
4 / 60
2 / 50
4 / 40
3 / 30
1 / 20
4 / 10
6 / 5



*/

public class BJ13904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt( br.readLine() );
		List<int[]> list = new ArrayList<>();
		
		for( int i=0; i<N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int d = Integer.parseInt( st.nextToken() );
			int w = Integer.parseInt( st.nextToken() );
			
			list.add( new int[] {d, w} );
		}
		
		//6일부터 1일까지 내림차순으로 정렬
		Collections.sort( list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		});
		
		int total = 0;
		
		int[] visit = new int[1001];
		
		//내림차순 되어 있는 (d, w) 순회
		for( int[] day : list ) {
			
			//day=6일부터 시작
			for( int i=day[0]; i>0; i-- ) {
				
				//방문한적이 없다면 방문처리하고, 
				//total에 해당 과제의 score를 누적합 
				if( visit[i] == 0 ) {
					visit[i] = 1;
					total += day[1];
					
					break;
				}
			}
		}
		System.out.println( total );
		
	}

}
