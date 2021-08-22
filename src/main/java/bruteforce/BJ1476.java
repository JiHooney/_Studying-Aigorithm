package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int e = Integer.parseInt( st.nextToken() );
		int s = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		int cnt = 1;
		int ee = 1, ss = 1, mm = 1;
		
		while( true ) {
			if( e == ee && s == ss  && m == mm ) break;
			if( ++ee == 16 ) ee = 1;
			if( ++ss == 29 ) ss = 1;
			if( ++mm == 20 ) mm = 1;
			
			cnt++;
		}
		System.out.println( cnt );
	}
}