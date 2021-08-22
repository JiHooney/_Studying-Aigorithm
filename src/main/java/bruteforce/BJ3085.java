package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3085 {
	public static char[][] chu;
	public static int n;
	public static int max = 0;
	
	//우측과 아래측 비교하면서 최대 사탕 개수 찾는 메서드
	public static void check() {
		//우측 먼저 체크
		for( int i=0; i<n; i++ ) {
			int cnt = 1;
			for( int j=0; j<n-1; j++ ) {
				//이전 값과 같으면 cnt 증가
				if( chu[i][j] == chu[i][j+1] ) cnt++;
				//이전 값과 다르면 cnt를 1로 초기화
				else cnt = 1;
				
				max = Math.max( max, cnt );
			}
		}
		
		//아래쪽 확인
		for( int i=0; i<n; i++ ) {
			int cnt = 1;
			for( int j=0; j<n-1; j++ ) {
				if( chu[j][i] == chu[j+1][i] ) cnt++;
				else cnt = 1;
				
				max = Math.max( max, cnt );
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		chu = new char[n][n];
		
		String tmp = null;
		for( int i=0; i<n; i++ ) {
			tmp = br.readLine();
			for( int j=0; j<n; j++ ) chu[i][j] = tmp.charAt(j);
		}
		
		//가로로 인접한 두 사탕 교환하고 최대개수 찾은 뒤 다시 사탕 원위치시키기
		for( int i=0; i<n; i++ ) {
			for( int j=0; j<n-1; j++ ) {
				//가로로 인접한 두 사탕 교환
				char temp = chu[i][j];
				chu[i][j] = chu[i][j+1];
				chu[i][j+1] = temp;
				
				//오른쪽, 아래쪽 체크
				check();
				
				//위에서 교환했던 사탕 원위치
				temp = chu[i][j];
				chu[i][j] = chu[i][j+1];
				chu[i][j+1] = temp;
			}
		}
		
		//세로로 인접한 두 사탕 교환하고 최대개수 찾은 뒤 다시 사탕 원위치시키기
		for( int i=0; i<n; i++ ) {
			for( int j=0; j<n-1; j++ ) {
				//세로로 인접한 두 사탕 교환
				char temp = chu[j][i];
				chu[j][i] = chu[j+1][i];
				chu[j+1][i] = temp;
				
				//오른쪽, 아래쪽 체크
				check();
				
				//위에서 교환했던 사탕 원위치
				temp = chu[j][i];
				chu[j][i] = chu[j+1][i];
				chu[j+1][i] = temp;
			}
		}
		System.out.println( max );
		
	}
}