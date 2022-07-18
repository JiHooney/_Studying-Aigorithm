package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class UntilToBe1 {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		int n = Integer.parseInt( st.nextToken() );
		int k = Integer.parseInt( st.nextToken() );
		
		int result = 0;
		
		while( n != 1 ) {	//n이 1이 아니면 while문 반복
			if( n % k != 0 ) { //n이 k의 배수가 아니면
				n -= 1;
				result++;
			} else {
				n = n/k;
				result++;
			}
		}
		
		bw.write( result + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
