package bfs_dfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Apart1 {
	
	private static int n;						//지도의 크기
	private static int[][] arr;					//지도 담을 배열
	private static int[] dx = {1, -1, 0, 0};	//x좌표 이동시 필요한 배열
	private static int[] dy = {0, 0, 1, -1};	//y좌표 이동시 필요한 배열
	private static int sum;						//각 단지 집의 수
	private static ArrayList<Integer> result = 
			new ArrayList<Integer>();			//결과: bfs 단지 수
	
	private static void bfs( int x, int y ) {
		Queue<Point> que = new LinkedList<Point>();
		
		if( arr[x][y] == 1 ) {
			arr[x][y] = 0;
			sum++;
		}
		
		//큐에 두 개의 값 동시에 집어넣기
		que.add( new Point(x, y) );
		
		//큐가 비어질 때까지 반복
		while( !que.isEmpty() ) {
			
			int tmp_x = que.peek().x;
			int tmp_y = que.peek().y;
			que.poll();
			
			//상하좌우 총 4군데 이동가능하므로 4회 반복
			for( int i=0; i<4; i++ ) {	
				int new_x = tmp_x + dx[i];	//새로운 x좌표
				int new_y = tmp_y + dy[i];	//새로운 y좌표
				
				//새로운 x, y좌표가 지도배열의 범위를 벗어나면 continue
				if( new_x <= 0 || new_x >= n+1 || new_y <= 0 || new_y >= n+1 ) {
					continue;
				}
				
				if( arr[new_x][new_y] == 1  ) {
					//큐에 새로운 위치 추가
					que.add( new Point(new_x, new_y ) );
					
					//현재 위치의 배열값을 0으로 초기화해서 다시 방문하지 않도록한다.
					arr[new_x][new_y] = 0;
					
					//집의 수 증가
					sum++;
				}
				
			}//for end
			
		}//while end
		
	}//bfs end
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		arr = new int[n+1][n+1];	//지도 담을 배열
		
		for( int i=0; i<=n; i++ ) {
			if( i == 0 ) {
				for( int j=0; j<=n; j++ ) arr[i][j] = 0;
				continue;
			}
			String tmp = br.readLine();
			
			//문자열로 한 줄을 입력받고 문자열의 각 문자를 숫자로 변환시켜서 arr배열에 집어넣는다.
			for( int j=0; j<=n; j++ ) {
				if( j==0 ) arr[i][j] = 0;
				else arr[i][j] = tmp.charAt(j-1)-'0';
			}
		}
		
//		for( int i=0; i<=n; i++ ) {
//			for( int j=0; j<=n; j++ ) {
//				System.out.print( arr[i][j] );
//			}
//			System.out.println();
//		}
		
		int x = 1; 	//bfs 호출시 매개변수
		int y = 1; 	//bfs 호출시 매개변수
		
		//지도배열에서 단지수를 찾기위해 무한반복
		while( true ) {
			sum = 0;
			bfs( x, y );
			if( sum == 0 ) break;
			
			result.add( sum );
			
			l:for( int j=1; j<n+1; j++ ) {
				for( int k=1; k<n+1; k++ ) {
					if( arr[j][k] == 1 ) {
						x = j;
						y = k;
						break l;
					}
				}
			}
		
		}//while end
		
		System.out.println( result.size() );
		
		//result 오름차순으로 정렬하기
		Collections.sort( result );
		for( int j=0; j<result.size(); j++ ) System.out.println( result.get(j) );
		

	}//main method end
}//class end
