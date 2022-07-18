package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tobe1_1 {
	
	private static BufferedWriter bw = 
			new BufferedWriter(new OutputStreamWriter(System.out));
	private static int x;		//입력값
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt( br.readLine() );
		
		//앞서 계산된 결과 저장하기 위한 DP테이블 초기화
		arr = new int[x*x];
		
		//다이나믹 프로그래밍 진행, 바텀업 방식
		for( int i=2; i<=x; i++ ) {
			//현재 수에서 1빼는 경우
			arr[i] = arr[i-1] + 1;
			
			//현재 수가 2로 나누어지는 경우
			if( i%2 == 0 ) arr[i] = Math.min( arr[i], arr[i/2] + 1 );
			
			//현재 수가 3으로 나누어지는 경우
			if( i%3 == 0 ) arr[i] = Math.min( arr[i], arr[i/3] + 1 );
			
			//현재 수가 5로 나누어지는 경우
			if( i%5 == 0 ) arr[i] = Math.min( arr[i], arr[i/5] + 1 ) ;
		}
		
		bw.write( arr[x] + "\n" );
		bw.flush();
		br.close();
		
	}//main end
}
