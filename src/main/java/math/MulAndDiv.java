package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MulAndDiv {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int a1, a2, t1, t2, re1, re2;
	private static ArrayList<Integer> arr = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		a1 = Integer.parseInt( st.nextToken() );
		a2 = Integer.parseInt( st.nextToken() );
		
		//소수 구하기
		arr.add(2);
		l1:for( int i=3; i<=Math.max(a1, a2); i++ ) {
			for( int j=0; j<arr.size(); j++ ) {
				if( i % arr.get(j) == 0 ) continue l1;
				if( j == arr.size()-1 ) arr.add( i );
			}
		}
		
		re1 = re2 = 1;
		t1 = a1;
		t2 = a2;
		//최대공약수 구하기
		for( int i=0; i<arr.size(); i++ ) {
			if( arr.get(i) > a1 || arr.get(i) > a2 ) break;
			if( t1%arr.get(i)==0 && t2%arr.get(i)==0 ) {
				t1 = t1/arr.get(i);
				t2 = t2/arr.get(i);
				re1 *= arr.get(i);
				i = -1;
			}
		}
		//최소공배수 구하기
		re2 = (a1/re1) * (a2/re1) * re1;
		
		bw.write( re1 + "\n" + re2 + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
