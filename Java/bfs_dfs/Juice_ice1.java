package bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Juice_ice1 {
	private static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
	
	private static int n, m;	//행렬 길이
	private static int[][] arr;
	
	private static boolean dfs(int i, int j) {
		
		//i와 j가 주어진 범위를 벗어나면 종료
		if( i <= -1 || i >= n || j <= -1 || j >= m ) {
			return false;
		}
		
		if( arr[i][j] == 0 ) {
			//해당노드 방문처리
			arr[i][j] = 1;
			
			//상하좌우 모두 재귀적으로 dfs메서드 호출하기
			dfs( i+1, j );
			dfs( i-1, j );
			dfs( i, j-1 );
			dfs( i, j+1 );
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		int answer = 0;
		
		st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );	//행의 길이
		m = Integer.parseInt( st.nextToken() );	//열의 길이
		
		arr = new int[n][m];	//얼을틀 행렬 초기화
		
		for( int i=0; i<n; i++ ) {
			String tmp1 = br.readLine();
			String[] tmp2 = tmp1.split( "" );
			for( int j=0; j<m; j++ ) {
				arr[i][j] = Integer.parseInt( tmp2[j] );
			}
		}
		
		
		for( int i=0; i<n; i++ ) {
			for( int j=0; j<m; j++ ) {
				
				if ( dfs(i, j) == true ) {
					answer++;
				}
			}
		}

		bw.write( String.valueOf(answer) );
		bw.flush();
		
		
	}//메인메서드 끝
}
