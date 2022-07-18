package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		int m = Integer.parseInt( br.readLine() );
		
		boolean[] remocon = new boolean[10]; //0~9번까지있는 리모컨
		
		//리모컨 버튼이 하나도 고장나지 않은 경우를 위해서 if문을 사용한다.
		if( m != 0 ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			int tmp_broke = 0;
			for( int i=0; i<m; i++ ) {
				tmp_broke = Integer.parseInt( st.nextToken() );
				remocon[tmp_broke] = true;	//true이면 고장난 것.
			}
		}
		
		int ans = Math.abs( n - 100 );
		int tmp_ans = Integer.MAX_VALUE;
		
		//왜 완전탐색을 해야하는가? : dfs로하려다가 겁나꼬여서 실패...ㅅㅂ
		//일단 최적의해를 찾는 문제라면 완전탐색을 먼저 떠올리자 !
		//0번채널부터 999_999채널까지 순회하면서 
		//각 채널에서 n채널을 만드려면 몇 번의 버튼을 눌러야되는 지 구한다.
		for( int i=0; i<=999_999; i++ ) {
			int channel = i;
			int pow = 0;//channel의 자리수를 구할 때 필요한 변수(ex: 100 -> 10을 만들기 위해 필요함)
			boolean chk = false;//현재 channel의 버튼중에 하나라도 고장났을 때의 경우를 나눠주는 변수
			int buttonCnt = (i+"").length();//누르는 버튼 수 (예시: 123이면 3개버튼 누르게된다)
			
			for( int j=buttonCnt; j>0; j-- ) {//버튼 수만큼 반복		
				pow = (int)Math.pow( 10, j-1 );
				
				if( remocon[ channel/pow ] ) {//해당 버튼이 고장났을 경우
					//현재 channel에서 하나의 버튼이라도 고장났으면
					//계산을 그만하고 다음 채널로 넘어간다.
					chk = true;	 
					break;
				}
				
				//위에 for문에서 버튼이 고장 안났으면 channel의 자리수를 하나 내려준다. 
				channel -= (channel/pow)*pow;
			}
			
			
			//위에 for문에서 channel의 버튼이 하나라도 고장났으면 chk=true이므로 다음 채널로 넘어가고
			//버튼이 고장안났다면 버튼수+(n-현재채널)을 구한 다음 ans값과 비교한다.
			if( chk ) continue;
			else {
				tmp_ans = buttonCnt + Math.abs( n - i );
				ans = Math.min( ans, tmp_ans );
			}
		}
		
		System.out.println( ans );
	}
}