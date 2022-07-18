package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt( br.readLine() );
		
		//우선순위큐를 만든다. 
		//기본은 오름차순이기 때문에 큐원소들을 내림차순으로 만들어준다.
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		//출력시 스트링버퍼를 이용해서 메모리 사용을 줄인다.
		StringBuffer sb = new StringBuffer();
		
		//N개만큼 반복
		for( int i=0; i<N; i++ ) {
			int num = Integer.parseInt( br.readLine() );
			
			//입력받은 값이 0이면 가장 큰 수를 출력하고 제거해야 한다.
			//따라서 poll()을 통해 이를 구현하고
			//큐 사이즈가 0이면 0을 출력해준다.
			if( num == 0 ) {
				sb.append( q.size() == 0 ? 0 : q.poll() ).append('\n');
				
			} else {
				q.add( num );
			}
		}
		
		//최종적으로 스트링버퍼에 있는 문자열들 출력
		System.out.println( sb.toString() );
	}

}
