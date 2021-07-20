package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ12871 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static String s, t;
	private static int max, lcm;
	private static ArrayList<Integer> so = new ArrayList<Integer>();
	private static StringBuilder sb = new StringBuilder();
	private static StringBuilder tb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		sb.append(s);
		tb.append(t);
		
		int a = s.length();
		int b = t.length();
		
		max = Math.max( a, b );
		
		//이따가 최소공배수 구하기 위한 소수구하기
		so.add( 2 );
		for( int i=3; i<=max; i++ ) {
			for( int j=0; j<so.size(); j++ ) {
				if( i%so.get(j)==0 ) break;
				if( j==so.size()-1 && i%so.get(j)!=0 ) so.add(i);
			}
		}
		
		//최소공배수 구하기
		lcm = 1;
		int i = 0;
		while( true ) {
			if( i==so.size()-1 && ( a%so.get(i)!=0 || b%so.get(i)!=0 ) ) {
				lcm *= a*b;
				break;
			}
			if( a%so.get(i)==0 && b%so.get(i)==0 ) {
				lcm *= so.get(i);
				a /= so.get(i);
				b /= so.get(i);
			} else i++;
		}
		
		
		//두 문자열 최소공배수까지 문자열 만들기
		for( int j=0; j<(lcm/s.length())-1; j++ ) sb.append(s);
		for( int j=0; j<(lcm/t.length())-1; j++ ) tb.append(t);
		
		//두 문자열 비교
		if( sb.substring(0, lcm).equals( tb.substring(0, lcm) ) ) bw.write( 1 + "\n" );
		else bw.write( 0 + "\n" );
		
		bw.flush();
		bw.close();
		br.close();
	}
}