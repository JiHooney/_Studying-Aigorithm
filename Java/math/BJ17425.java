package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ17425 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		long f[] = new long[ 1_000_001 ];
		long g[] = new long[ 1_000_001 ];
		
		//1은 모든 수의 약수이므로 추가
		Arrays.fill( f, 1 );
		
		//먼저 f()를 모두 만들어준다.
		//만약 i가 2일 경우 2의 배수들에는 모두 2가 약수가 되므로 2를 더해준다.
		//만약 i가 3일 경우 3의 배수들에는 모두 3이 약수이므로 3으 더한다.
		//j 반복문의 범위는 i*j까지이다. 
		//i가 2이고 j가 500,000이면 i*j는 1,000,000이기 때문이다.
		for( int i=2; i<f.length; i++ ) {
			for( int j=1; i*j<f.length; j++ ) {
				f[ i*j ] += i;
			}
		}
		
		//이제 g()를 만들어준다.
		//식은 다음과 같다. g(i) = g(i-1) + f(i)
		for( int i=1; i<g.length; i++ ) {
			g[i] = g[i-1] + f[i];
		}
		
		//각 테스트케이스에 따라 g()값을 출력해준다.
		int t = Integer.parseInt( br.readLine() );
		while( t --> 0 ) {
			int n = Integer.parseInt( br.readLine() );
			sb.append( g[n] ).append( "\n" );
		}
		System.out.println( sb );
	}
}