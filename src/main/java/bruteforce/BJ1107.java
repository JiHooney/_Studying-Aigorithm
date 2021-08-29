package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
	static boolean[] remocon = new boolean[10]; //0~9번까지있는 리모컨
	
	static int calCount( int now ) {
		
		if( now == 0 ) { //0일 때 예외처리
			if( remocon[0] ) return 0; //0버튼이 고장났으면 
			else return 1;
		}
		
		int len = 0;
		while( now > 0 ) {
			if( remocon[now%10] ) return 0;
			len += 1;
			now /= 10;
		}
		
		return len;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		int m = Integer.parseInt( br.readLine() );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		int tmp_broke = 0;
		for( int i=0; i<m; i++ ) {
			tmp_broke = Integer.parseInt( st.nextToken() );
			remocon[tmp_broke] = true;	//true이면 고장난 것.
		}
		
		//모든 리모콘의 버튼이 고장났을 수도 있으니
		//+-버튼만으로 움직이게 될 때의 수
		int ans = Math.abs( 100 - n );
		
		//0부터 1_000_000까지 모든 채널을 순회하면서 채널n을 만들기 위해 
		//가장 적은 버튼을 눌러서 이동할 수 있는 채널 찾기
		for( int i=0; i<1_000_000; i++ ) {
			int now = i;
			
			//calCount는 now채널을 숫자버튼을 눌러서 이동이 가능한지 확인하고
			//가능하다면 숫자버튼을 몇 번 누르는지 구하는 메서드
			int cnt = calCount( now );
			
			if( cnt > 0 ) {
				//press는 숫자버튼으로 n에 최대한 인접하게 이동한 후
				//+또는-를 몇 번 눌러야 하는지 구하는 변수
				int press = Math.abs( now - n );
				
				if( ans > cnt+press ) {
					ans = cnt + press;
				}
				
			}
		}
		System.out.println( ans );
	}
}