package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
문제에서 처럼 10 20 40이 주어졌을 때 
오름차순 우선순위 큐를 만들어서 
10 + 20 = 30을 결과값에 더해주고
다시 큐에 넣는다.
그러면 결과값은 30, 큐에는 30 40이 들어가 있다.

또 30 + 40 = 70 을 결과값에 더해주고
큐에 넣어준다.
그러면 결과값은 100, 큐에는 70이 들어가있다.

이제 큐에 1개 밖에 없어서 비교가 불가하기 때문에
결과값을 최종적으로 출력해준다.
*/

public class BJ1715 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt( br.readLine() );
		
		//우선순위큐를 오름차순으로 정의
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		//입력받는 값을 하나씩 넣어준다.
		for( int i=0; i<N; i++ ) pq.add( Long.parseLong(br.readLine()) );
		
		long res = 0;
		
		while (pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			
			res += temp1 + temp2;
			pq.add(temp1 + temp2); //합한 묶음 다시 넣기
		}
		
		System.out.println(res);
		
		
		
		

	}

}
