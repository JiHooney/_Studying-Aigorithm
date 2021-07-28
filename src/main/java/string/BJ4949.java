package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String line = "";
		
	    
        //.나올 때까지 반복
		while( true ) {
			Stack<Character> stack = new Stack<Character>();
			String ans = "no";   //최종 결과값
			int flag = 0;//괄호열기없이 괄호닫기 나왔을 경우 ans에 "no"를 저장하기 위한 판단값	
			
			line = br.readLine();
            //.이면 종료
			if( line.equals(".") ) break;
			
			//문자열을 문자배열로 바꾼 뒤 순회
			for( char s : line.toCharArray() ) {
				
				//소괄호 또는 대괄호 열기 등장하면 스택에 삽입
				if( s=='(' || s=='[' ) stack.add( s );
				
				//소괄호 닫기 등장할 경우
				else if( s == ')' ) {
					//스택이 비워져있거나 스택 최근값이 (가 아닐 경우
					if( stack.isEmpty() || stack.peek() != '(' ) {
						ans = "no";
						flag = 1;
						break;	//바로 반복문 종료
					
					//스택의 최근값이 소괄호 열기이면 해당 스택값을 제거
					} else if( !stack.isEmpty() && stack.peek() == '(' ) stack.pop(); 
				} 
				//대괄호 닫기 등장할 경우
				else if( s == ']' ) {
					//스택이 비워져있거나 스택 최근값이 (가 아닐 경우
					if( stack.isEmpty() || stack.peek() != '[' ) {
						ans = "no";
						flag = 1;
						break;	//바로 반복문 종료
					
					//스택의 최근값이 대괄호 열기이면 해당 스택값을 제거
					} else if( !stack.isEmpty() && stack.peek() == '[' ) stack.pop(); 
				}
			}//for end
			
			if( !stack.isEmpty() || flag == 1 ) ans = "no";
			else if( flag != 1 ) ans = "yes";
			
			sb.append( ans+"\n" );
			
		}//while end
		
		System.out.println( sb );
	}
}