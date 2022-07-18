package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Palindrome {

	private static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
	
	private static int checkPal( int oe, StringBuilder word ) {	//oe는 홀짝여부, word는 단어
		int len = word.length();	//문자 길이
		
		//첫 번째 문자와 끝 문자와 비교하는 반복문
		for( int i=0; i<len; i++ ) {
			if( oe == 1 && i == (len/2) ) continue;
			if( word.charAt(i) != word.charAt(len-1-i) ) return 0;
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {		
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringBuilder sb = new StringBuilder();		//홀수일 때 가운데 문자 제거를 위해 stringbuilder 객체 생성
		
		String word = br.readLine();
		sb.append( word );
		
		bw.write( checkPal( ( sb.length()%2 ), sb ) + "\n" ); //함수호출해서 바로 결과 출력
		bw.flush();

		
		bw.close();
		br.close();
	}
}
