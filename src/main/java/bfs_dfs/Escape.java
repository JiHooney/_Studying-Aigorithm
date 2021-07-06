package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Escape {
	
	private static int n, m;	//미로 담을 배열의 행열 크기
	
	private static int[][] arr;	//미로 담을 배열(dfs용)
	private static int[][] arr1;	//미로 담을 배열(bfs용)
	
	//이동할 4방향 정의(상하좌우)
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	
	private static int sum = 1;
	private static int sum1 = 1;
	
	//dfs함수
	private static void dfs( int now_x, int now_y ) {
		//현재 노드를 0으로 바꿔서 방문처리한다.
		arr[now_x][now_y] = 0;
		
		int x, y;
		
		//상하좌우로 이동하기 위해 arr인덱스값 설정
		for( int i=0; i<4; i++ ) {
			x = now_x + dx[i];
			y = now_y + dy[i];
			
			//x, y값이 배열의 범위를 넘으면 다음 순회
			if( x <= 0 || x >= n+1 || y <= 0 || y >= m+1 ) continue;
			
			//배열값이 1이고, x나 y가 기존 x,y보다 클 때만 bfs 재귀적 호출
			if( arr[x][y] == 1 && ( x>now_x || y>now_y ) ) {
				sum++;
				dfs( x, y );
			}
		}
	}//dfs함수 끝
	
	private static void bfs( int now_x, int now_y ) {
		//bfs에 사용할 큐 선언
		Queue<Integer> que = new LinkedList<Integer>();
		
		//bfs에 담길 x,y좌표를 사용자객체 담아서 큐에 넣는다.
		que.add( now_x );
		que.add( now_y );
		
		//현재 노드를 0으로 바꿔서 방문처리한다.
		arr1[now_x][now_y] = 0;
		
		int x, y;
		
		//큐가 비워질 때까지 반복한다.
		while( !que.isEmpty() ) {
			now_x = que.poll();
			now_y = que.poll();
			
			//현재 노드를 0으로 바꿔서 방문처리한다.
			arr1[now_x][now_y] = 0;
			
			for( int i=0; i<4; i++ ) {
				x = now_x + dx[i];
				y = now_y + dy[i];
				
				//x, y값이 배열의 범위를 넘으면 다음 순회
				if( x <= 0 || x >= n+1 || y <= 0 || y >= m+1 ) continue;
				
				
				//배열값이 1이고, x나 y가 기존 x,y보다 클 때만 아래 코드 실행
				if( arr1[x][y] == 1 && ( x>now_x || y>now_y ) ) {
					sum1++;
					que.add( x );
					que.add( y );
				}
			}
		}
		
	}//bfs method end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );	//미로출구 n행
		m = Integer.parseInt( st.nextToken() );	//미로출구 m행
		
		arr = new int[n+1][m+1];	//미로배열 선언
		arr1 = new int[n+1][m+1];	//미로배열 선언
		
		for( int i=0; i<=n; i++ ) {
			if( i == 0 ) {
				int[] tmp = {0, 0, 0, 0, 0, 0, 0};
				arr[i] = tmp;
				arr1[i] = tmp;
			} else {
				char[] tmp1 = br.readLine().toCharArray();
				for( int j=0; j<=m; j++ ) {
					if( j == 0 ) {
						arr[i][j] = 0;
						arr1[i][j] = 0;
					}
					else {
						arr[i][j] = Character.getNumericValue(tmp1[j-1]);
						arr1[i][j] = Character.getNumericValue(tmp1[j-1]);
					}
				}
			}
		}
		
		dfs( 1, 1 );
		bfs( 1, 1 );
		
		System.out.println( "dfs결과: " + sum );
		System.out.println( "bfs결과: " + sum1 );
		

	}//main method end
}
