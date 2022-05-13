package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17086 {
	
	static int N, M, answer, tmp, sea[][];
	
	static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	
	static int findSafe(int x, int y) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add( new int[] { x, y, 0 } );
		
		boolean visit[][] = new boolean[N][M];
		visit[x][y] = true;
		
		while( !q.isEmpty() ) {
			int now[] = q.poll();
			
			for( int i=0; i<8; i++ ) {
				//새로운 공간좌표 정의
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int val = now[2];
				
				//공간을 벗어나면 반복문으로
				if( nx<0 || ny<0 || nx>=N || ny>=M ) 
					continue;
					
				//새로운 공간을 방문했다면 반복문으로
				if( visit[nx][ny] == true ) 
					continue;
				
				//상어있는 공간이라면 현재 거리에 1을 더하고 리턴
				if( sea[nx][ny] == 1 ) {
					return val+1;
				}
				
				//새로운 공간 방문처리
				visit[nx][ny] = true;
				
				//새로운 공간을 큐에 넣는다.
				q.add( new int[] { nx, ny, val+1 } );
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sea = new int[N][M];
		
		for( int i=0; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for( int j=0; j<M; j++ ) {
				sea[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		tmp = answer = 0;
		
		for( int i=0; i<N; i++ ) {
			for( int j=0; j<M; j++ ) {
				//상어있는 공간이라면
				if( sea[i][j] == 1) continue;
				
				tmp = findSafe(i, j);
				answer = tmp > answer ? tmp : answer;
			}
		}
		
		System.out.println( answer);
	}
}