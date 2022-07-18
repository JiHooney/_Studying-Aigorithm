package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		하나의 우선순위큐로 원소의 인덱스를 이용해 중앙값을 구한뒤
		출력하는 풀이는 시간초과가 된다고 한다.
		최대힙 우선순위큐와 최소힙 우선순위큐를 이용한다.
		
		먼저 최대힙 -> 최소힙 순으로 숫자가 쌓인다.
				  최대힙	최소힙
		1:			1	
		2: 			1	5
		3:		  1 2	5
		4:		  1 2	5 10
		5:    -99 1 2	5 10
		6:    -99 1 2	5 7 10
		7:  -99 1 2 5	5 7 10
		
		위처럼 마치 왼쪽에서 오른쪽으로 오름차순처럼 보이게 된다.
		
		이때 최대힙의 peek()가 최소힙의 peek()보다 크면
		둘의 자리를 바꿔줘야한다.
		
		또한 최소힙의 비워져있을 경우엔 최대힙의 값을 출력해준다.
		최대힙의 값이 비워져있을 경우는 없다. 
		왜냐하면 무조건 처음에 최대힙에 숫자가 들어가기 때문이다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt( br.readLine() );
		
		//최대힙, 최소힙 우선순위큐를 만든다.
		PriorityQueue<Integer> minH = new PriorityQueue<>();
		PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
		
		//메모리 절약을 위해 스트링버퍼 사용
		StringBuffer sb = new StringBuffer();
		
		for( int i=0; i<N; i++ ) {
			int n = Integer.parseInt( br.readLine() );
			
			//최대힙과 최소힙의 size가 같다면 최대힙에 정수를 배정
			//같지 않으면 최소힙에 배정
			if( minH.size() == maxH.size() ) maxH.add(n);
			else minH.add(n);
			
			//minH 비워져있으면 F인데 !이므로 T && 최대힙peek가 최소힙 peek보다 크면 교체
			if( !minH.isEmpty() && maxH.peek() > minH.peek() ) {
				int tmp = maxH.poll();
				maxH.add( minH.poll() );
				minH.add( tmp );
			}
			
			sb.append( maxH.peek() + "\n" );
		}
		
		System.out.println( sb );
	}

}
