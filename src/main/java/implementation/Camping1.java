package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping1 {
	
	private static int l, p, v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i = 1;
		while( true ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			StringBuilder sb = new StringBuilder();
			
			l = Integer.parseInt( st.nextToken() );	//캠핑장 사용가능한 일수
			p = Integer.parseInt( st.nextToken() );	//캠핑장 연속하는 전체일수
			v = Integer.parseInt( st.nextToken() );	//휴가일수
			
			//세 개 변수 모두 0이면 프로그램종료
			if( l==0 && p==0 && v==0 ) break;
			
			int mok = v/p;
			int sum = v%p;
			
			sb.append("Case ").append(i)
				.append(": ").append( mok*l + Math.min(l, sum) );
			System.out.println( sb );
			i++;
		}//while end
		
		br.close();
	}//main method end
}//class end
