package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkCount1 {
	
	private static int n, m;		//n:노드개수, m:간선개수
	private static int[] visit;		//방문처리할 배열
	private static int[][] arr;		//노드 간에 간선정보담는 2차원 배열
	private static int sum;			//연결요소의 개수(최종결과값)
	private static boolean flag;	//dfs함수를 반복하게하는 변수
	private static int a;			//dfs함수 호출시 매개변수
	
	private static void dfs( int start ) {
		//현재 노드 방문처리하기
		visit[start] = 1;
		
		//해당 노드와 연결된 노드 탐색하기위한 반복문
		for( int i=0; i<=n; i++ ) {
			if( visit[i] == 0 && arr[start][i] == 1 ) {
				
				dfs( i );
			}
		}
		
	}//dfs method end
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		
		//간선정보배열 크기 선언, 노드번호와 행렬값을 맞추기위해 일부러 각 행열 1씩 늘려줌
		arr = new int[n+1][n+1];	
		
		//노드간 연결정보가 담긴 7x7 행렬을 만든다.
		//0행과 0열은 자리만 맞춰주는 용도이다. 
		for( int i=0; i<m; i++ ) {
			st = new StringTokenizer( br.readLine() );
			
			int x = Integer.parseInt( st.nextToken() );
			int y = Integer.parseInt( st.nextToken() );
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		

		/* 잘 만들어졌는지 출력해보기
		for( int i=0; i<=n; i++ ) {
			for( int j=0; j<=n; j++ ) System.out.print( arr[i][j] );
			System.out.println();
		}
		*/
		
		//방문처리배열 모두 false로 초기화하기
		visit = new int[n+1];
		for( int i=0; i<n; i++ ) {
			if( i == 0 ) visit[i] = 1;
			else visit[i] = 0;
		}
		
		//dfs함수 호출
		a = 1;
		int b = 0;	//방문처리배열 요소들 모두 더한 값이 저장되는 변수
		
		while( !flag ) {
			System.out.println( a );
			dfs( a );	//한 번의 dfs함수는 하나의 연결요소를 나타낸다.
			sum++;
			
			//방문처리배열에 하나라도 false값이 있으면 flag값을 false로 유지시켜서
			//다시 dfs함수가 호출되도록 한다.
			l:for( int i=0; i<=n; i++ ) {
				
				//방문처리배열에 아직 방문하지 않은 0이 있으면 첫 번째로 나오는 값을 a로 선언해준다.
				if( visit[i] == 0 ) {	
					a = i;
					break l;
				}
				if( i==n && visit[i] == 1 ) flag = true;
				
			}
		}//while end
		
		System.out.println( sum );
		
	}//main method end
}//class end
