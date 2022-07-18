package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11656 {

	public static void main(String[] args) throws IOException {
		//문자열 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_s = br.readLine();
		
		//접미사별로 나눈 문자열을 저장할 배열
		String[] str_tail = new String[str_s.length()];
		
		//문자열을 앞글자부터 자른 뒤 str_tail배열에 저장
		for( int i=0; i<str_s.length(); i++ ) 
			str_tail[i] = str_s.substring(i);
		
		//배열 정렬
		Arrays.sort(str_tail);
		
		//정렬된 배열 출력
		for( int i=0; i<str_tail.length; i++ )
			System.out.println( str_tail[i] );

	}
}
