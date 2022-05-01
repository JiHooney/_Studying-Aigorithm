package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ116556_1 {

	public static void main(String[] args) throws IOException {
		//문자열 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		//접미사 저장할 문자열 배열 선언
		String[] tail = new String[S.length()];
		
		//문자열 앞에서부터 하나씩 자른 뒤 tail 배열에 저장
		for( int i=0; i<S.length(); i++ ) 
			tail[i] = S.substring(i);
		
		//문자열 배열 정렬
		Arrays.sort( tail );
		
		//stringbuffer로 문자열 버퍼에 저장한 뒤 출력
		StringBuffer sb = new StringBuffer();
		for( String t : tail ) 
			sb.append(t+"\n");
		
		System.out.println( sb );
		br.close();
	}
}
