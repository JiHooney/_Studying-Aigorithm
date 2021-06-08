package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SecureGuard {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer( br.readLine() );
		int a = Integer.parseInt( st.nextToken() );	//블록 가로 길이
		int b = Integer.parseInt( st.nextToken() );	//블록 세로 길이
		int c = Integer.parseInt( br.readLine() );	//상점의 개수
		
		int[][] shops = new int[c][2];	//상점좌표담을 2차원 배열
		
		for( int i=0; i<c; i++ ) {
			st = new StringTokenizer( br.readLine(), " " );
			shops[i][0] = Integer.parseInt( st.nextToken() );	//각 상점 좌표
			shops[i][1] = Integer.parseInt( st.nextToken() );
		}
		
		st = new StringTokenizer( br.readLine() );
		int x = Integer.parseInt( st.nextToken() );	//동근이 위치
		int y = Integer.parseInt( st.nextToken() );
		
		int min_a = 0;	//
		int min_x = 0;
		int sum = 0;
		
		for( int i=0; i<c; i++ ) {
			switch( shops[i][0] ) {
			case 1:	//북쪽
				min_a = shops[i][1] < (a/2) ? shops[i][1] : a-shops[i][1];
				break;
			case 2:	//남쪽
				break;
			case 3:	//서쪽
				break;
			case 4:	//동쪽
				break;
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
