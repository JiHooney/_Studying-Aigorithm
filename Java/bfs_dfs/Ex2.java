package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Ex2 {
	
	private static void bfs( int[][] arr, int v, boolean[] visit ) {
		//큐 선언
		Queue<Integer> que = new LinkedList<Integer>();
		
		//큐에 현재 노드 값 추가
		que.add( v );
		
		//현재 노드 방문처리
		visit[v] = true;
		
		//큐가 빌 때까지 반복
		while( !que.isEmpty() ) {
			//큐에서 하나의 원소를 뽑아서 출력한다.
			int q = que.poll();
			System.out.print( q + " " );
			
			//해당 노드와 연결되고 아직 방문하지 않은 원소들을 큐에 삽입
			for( int i : arr[q] ) {
				if( visit[i] == false ) {
					que.add( i );
					visit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = {
				{},	//0번 노드 비워놓는다.
				{2, 3, 8},
				{1, 7},
				{1, 4, 5},
				{3, 5},
				{3, 4},
				{7},
				{2, 6, 8},
				{1, 7}
		};
		
		boolean[] visit = new boolean[9];
		for( int i=0; i<9; i++ ) visit[i] = false; 
		
		bfs( arr, 1, visit );
	}

}
