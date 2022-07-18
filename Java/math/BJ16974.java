package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ16974 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int N;
	private static long X;
	private static long[] h, p;
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer( br.readLine() );
		N = Integer.parseInt( st.nextToken() );
		X = Long.parseLong( st.nextToken() );

		//h는 레벨의 전체햄버거 재료수, p는 레벨의 패티수
		h = new long[N+1];
		p = new long[N+1];
		h[0] = p[0] = 1;
		
		//n레벨까지 전채 재료수와 패티수를 구한다.
		for( int i=1; i<=N; i++ ) {
			h[i] = 1 + h[i-1] + 1 + h[i-1] + 1;
			p[i] = p[i-1] + 1 + p[i-1];
		}
		
		//패티수 반환해주는 메소드 호출
		bw.write( getP( N, X ) +  "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static long getP( int n, long x ) {
		//재귀호출로 인해 n이 0이 될경우 레밸 0의 패티는 한 장이다. bpb
		if( n==0 ) {
			if( x==0 ) return 0;
			else if( x==1 ) return 1;
		}
		
		//각 레벨의 첫 번째 자료는 패티가 아니므로 0반환
		if( x == 1 ) return 0;
		
		//x가 중간패티 위치보다 작으면 맨 앞에 번을 빼고 이전 레밸의 햄버거 패티수를 호출
		//맨 앞에 번을 빼기 위해 x-1을 해준다.
		else if( x <= 1+h[n-1] ) return getP( n-1, x-1 );
		
		//x가 중간패티의 위치라면 이전 패티수+1을 반환
		else if( x == 1+h[n-1]+1 ) return p[n-1]+1;
		
		//x가 중간패티 위치보다 크면 
		else if( x <= 1+h[n-1]+1+h[n-1] ) return p[n-1]+1+getP( n-1, x-(1+h[n-1]+1) );
		
		//x가 현재 레밸 재료수의 크기와 같다면 현재 레밸의 패티수를 반환
		else return p[n-1]+1+p[n-1];
	}

}