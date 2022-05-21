package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1303 {

	static int N, M, our_res, enemy_res;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	
	static void DFS(int x, int y) {
		char who = map[x][y];
		
		for( int i=0; i<4; i++ ) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if( nx<0 || ny<0 || nx>=N || ny>=M ) continue;
			if( visit[nx][ny] == true ) continue;
			
			if( who == map[nx][ny] ) {
				if( who == 'W' ) {
					our_res++;
				} else {
					enemy_res++;
				}
			} else {
				continue;
			}
			visit[nx][ny] = true;
			DFS(nx, ny);
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt( br.readLine() );	//가로
		M = Integer.parseInt( br.readLine() );	//세로
		
		map = new char[N][M];
		visit = new boolean[N][M];
		
		for( int i=0; i<M; i++ ) {
			String tmp = br.readLine();
			for( int j=0; j<N; j++ ) {
				map[i][j] = tmp.charAt(j);
			}
		}		
		
		for( int i=0; i<N; i++ ) {
			for( int j=0; j<M; j++ ) {
				if( visit[i][j] == false ) {
					DFS(i, j);
					our_res = (int)Math.pow(our_res, 2);
				}
				
			}
		}
		
		
		
	}
}
