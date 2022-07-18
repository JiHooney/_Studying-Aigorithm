package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2751_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		int arr_size = 2_000_001;
		int index = 1_000_000;
		
		boolean[] arr = new boolean[arr_size];
		
		for( int i=0; i<n; i++ ) 
			arr[ Integer.parseInt( br.readLine() ) + index ] = true;
		
		StringBuilder sb = new StringBuilder();
		for( int i=0; i<arr.length; i++ ) 
			if( arr[i] ) sb.append( (i-index)+"\n" );
		
		System.out.println( sb );
	}
}