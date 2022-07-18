package bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 인접해 있고, 
같은 행에 있다면, 두 개는 같은 나무 판자이고, 두 개의 ‘|’가 인접해 있고, 
같은 열에 있다면, 두 개는 같은 나무 판자이다.
기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.
*/

public class Floor1 {
	
	private static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
	
	private static int n, m;
	private static int answer;
	private static char[][] floor;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );	//세로크기 n
		m = Integer.parseInt( st.nextToken() );	//가로크기 m
		StringBuilder sb = new StringBuilder();
		
		floor = new char[n][m];	//문자담을 배열 초기화
		
		// 연이은 - 개수 찾기
		for( int i=0; i<n; i++ ) {
			floor[i] = br.readLine().toCharArray();	//String을 char배열로 바꿔준다.
			
			for( int j=0; j<m; j++ ) {
				if( floor[i][j] == '-' ) {
					answer++;
					while( j<m && floor[i][j] == '-' ) j++;
				}
			}
		}
		
		// 연이은 | 개수 찾기
		for( int i=0; i<m; i++ ) {
			for( int j=0; j<n; j++ ) {
				if( floor[j][i] == '|' ) {
					answer++;
					while( j<n && floor[j][i] == '|' ) j++;
				}
			}
		}
		sb.append(answer);
		bw.write( sb.toString() );
		bw.flush();
	}
}




