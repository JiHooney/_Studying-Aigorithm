package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ13458 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, b, c;
	private static long sum;
	private static int[] a;
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		a = new int[n];
		st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) a[i] = Integer.parseInt( st.nextToken() );
		
		st = new StringTokenizer( br.readLine() );
		b = Integer.parseInt( st.nextToken() );
		c = Integer.parseInt( st.nextToken() );

		for( int i=0; i<n; i++ ) {
			a[i] -= b;	//총 감독관 수 뺀다.
			sum++;
			if( a[i] <= 0 ) continue;	//더이상 감독받을 학생이 없으면 다음 강의실이동
			
			if( a[i]%c == 0 ) sum += a[i]/c;	//학생수가 부감독관 감시수로 나머지가 0이면 나눗셈
			else sum += ( a[i]/c ) + 1;		//학생수가 부감독관 감시수보다 크거나 작을 경우 나누기 + 1
		}
		
		bw.write( sum + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}