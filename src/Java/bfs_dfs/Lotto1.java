package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lotto1 {
	
	private static int[] s;	//입력받은 값들을 담을 배열
	private static int[] combi = new int[13];	//6개의 로또조합이 담길 배열
	
	private static void dfs( int start, int depth ) {
		
		//depth가 6이면 combi배열 6번 인덱스까지 출력
		if( depth == 6 ) {
			for( int i=0; i<6; i++ ) System.out.print( combi[i] + " " );
			System.out.println();
			
			//이전함수로 돌아간다.(백트래킹)
			return;
		}
		
		//s배열을 재귀적으로 순회하면서 6가지의 조합을 만들고 combi에 저장한다.
		for( int i=start; i<s.length; i++ ) {
			//조합배열의 depth자리에 s배열의 수를 집어넣는다.
			combi[depth] = s[i];
			
			//dfs함수 재귀적 호출
			dfs( i+1, depth+1 );
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		//0이 입력될 때까지 무한반복
		while( true ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			
			//입력받은 값의 첫 번째 값인 k가 0이면 무한루프 종료
			int k = Integer.parseInt(st.nextToken());
			if( k == 0 ) break;
			
			//k값으로 s배열 크기 정의
			s = new int[ k ];
			
			//입력받은 값의 두 번째 값부터 s배열에 담는다.
			for( int i=0; i<s.length; i++ ) s[i] = Integer.parseInt(st.nextToken());
			
			//dfs함수 호출
			dfs( 0, 0 );
			System.out.println();
			
		}//while end
		
	}//main method end
}//class end
