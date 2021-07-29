package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
	private static String chkVps(String line) {
		Stack<Character> st = new Stack<Character>();	//스택사용
		
		//매개변수인 line문자열을 문자배열로 바꾼 뒤 순회
		for( char s : line.toCharArray() ) {
			
			//문자s가 괄호열기라면 스택에 s 추가
			if( s=='(' ) st.add( s );
			
			//그 외 스택이 비워져있고 s가 괄호 닫기라면 바로 NO를 반환
			else if( st.isEmpty() && s==')' ) return "NO";
			
			//그 외 스택이 비워져있지 않고 s가 괄호닫기라면 스택의 최근값 비우기
			else if( !st.isEmpty() && s==')' ) st.pop();
		}
		
		//스택이 비워져있으면 PVS이므로 YES, 아니면 NO를 반환
		if( st.isEmpty() ) return "YES";
		else return "NO";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( br.readLine() );
		StringBuffer sb = new StringBuffer();
		
		for( int i=0; i<t; i++ ) {
		
			//stringbuffer에 각 줄의 결과값을 한꺼번에 저장해서 출력
			//chkVps라는 메소드를 호출하고 반환값을 sb에 append
			sb.append( chkVps( br.readLine() )+"\n" );
		}
		System.out.println( sb );
	}
}