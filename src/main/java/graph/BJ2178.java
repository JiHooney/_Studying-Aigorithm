package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
	
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//n, m입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//지도 크기 정의
		map = new int[n][m];
		
		//미로의 정수값 입력, 문자로 map배열에 넣는다.
		for( int i=0; i<n; i++ ) {
			String s = br.readLine();
			for( int j=0; j<m; j++ ) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		//방문배열 크기정의
		visited = new boolean[n][m];
		
		//(0, 0)은 무조건 방문
		visited[0][0] = true;
		
		//bfs 시작
		bfs(0, 0);
		
		//정답출력
		System.out.println( map[n-1][m-1] );
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		//현재 bfs에 들어온 x, y값을 큐에 넣어준다.
		q.add(new int[] {x, y});
		
		//큐가 비어있지 않으면 계속 반복
		while( !q.isEmpty() ) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for( int i=0; i<4; i++ ) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				
				//map의 범위를 벗어나면
				if( newX<0 || newY<0 || newX>=n || newY>=m ) continue;
				
				//방문했거나 map에서 미로값이 0이면 
				if( visited[newX][newY] || map[newX][newY] == 0 ) continue;
				
				//위 두 가지 조건문에 해당되지 않으면 큐에 이동할 좌표값인 newX와 newY를 추가
				//그리고 새로운 좌표의 정수값에 1을 더해주어 여태까지의 이동횟수를 적어준다.
				//그리고 새로운 좌표를 방문표시도 해준다.
				q.add( new int[] {newX, newY} );
				map[newX][newY] = map[nowX][nowY] + 1;
				visited[newX][newY] = true;
				
			}
		}
		
	}

}
