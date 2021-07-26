package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2751 {
	private static int n;
	private static Integer[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		arr = new Integer[n];
		for( int i=0; i<n; i++ ) arr[i] = Integer.parseInt( br.readLine() );
		
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<n; i++ ) sb.append( arr[i]+"\n" );
		System.out.println( sb );
	}
}