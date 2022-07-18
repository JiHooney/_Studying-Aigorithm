package bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jelly1 {
	private static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	
	private static int dr[] = {1, 0};
	private static int dc[] = {0, 1};
	
	//dfs 선언
	private static void dfs(int n, int[][] arr, boolean[][] visit, int a, int b ) throws IOException {
		int now = arr[a][b];
		
		//-1에 도달했으면 결과 출력하고 종료
		if( now == -1 ) {
			bw.write( "HaruHaru" );
			bw.flush();
			System.exit(0);
		} 
		
		//오른쪽 혹은 아래로 가야하므로 2회 반복
		for( int i=0; i<2; i++ ) {
			int row = a + dr[i]*now;	//i 0일때는 row값만 변경되고 col값은 그대로
			int col = b + dc[i]*now;	//i 1일때는 col값만 변경되고 row값은 그대로
			
			//row와 col이 이상치이면 continue
			if( row < 0 || col < 0 || row >= n || col >= n ) continue;
			//visit가 true면 방문했으므로 continue
			if( visit[row][col] ) continue;
			
			//방문하지 않은 노드면 true
			visit[row][col] = true;
			dfs( n, arr, visit, row, col );
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		//게임 구역의 크기 입력받기
		int n = Integer.parseInt( br.readLine() );
		
		int[][] arr = new int[n][n];	//게임판 구역 배열
		boolean[][] visit = new boolean[n][n];	//노드 방문여부 배열
		
		//게임판의 구역 입력받기
		for(int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<n; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		//dfs함수 호출
		dfs(n, arr, visit, 0, 0);
		
		//dfs함수에서 HaruHaru 나오지않으면 Hing출력
		bw.write( "Hing" );
		bw.flush();
	}
	
}
