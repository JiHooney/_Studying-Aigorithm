package bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Floor2 {

private static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
	
	private static int n, m;
	private int answer;
	private static char[][] floor;
	
	//bfs메서드
	private static void bfs() {
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );	//세로크기 n
		m = Integer.parseInt( st.nextToken() );	//가로크기 m
		StringBuilder sb = new StringBuilder();
		
		floor = new char[n][m];	//문자담을 배열 초기화
		
		bfs();
		
	}

}
