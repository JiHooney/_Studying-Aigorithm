package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plus123_1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int t;		//테스트케이스 개수
	private static int n;		//주어지는 정수
	private static int[] arr;	//정수 n이 만들어지는 개수가 담길 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt( br.readLine() );
		
		arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for( int i=0; i<t; i++ ) {
			n = Integer.parseInt( br.readLine() );
			
			for( int j=4; j<=n; j++ ) {
				arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
			}
			
			bw.write( arr[n] + "\n" );
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
