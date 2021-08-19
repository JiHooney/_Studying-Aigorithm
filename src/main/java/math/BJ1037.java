package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int len = st.countTokens();
		int[] arr = new int[len];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int tmp;
		for( int i=0; i<len; i++ ) {
			tmp = Integer.parseInt( st.nextToken() );
			min = Math.min( tmp, min );
			max = Math.max( tmp, max );
			arr[i] = tmp;
		}
		System.out.println( min*max );
	}
}