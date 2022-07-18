package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class employee_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt( in.readLine() );
		
		while( testCase --> 0 ) {
			int n = Integer.parseInt(in.readLine());
			int arr[] = new int[n+1];
			
			for( int i=0; i<n; i++ ) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt( st.nextToken() );
				int b = Integer.parseInt( st.nextToken() );
				
				arr[a] = b;
			}
			
			int ans = 1;
			int min = arr[1];
			for( int i=2; i<=n; i++ ) {
				if( arr[i] <= min ) {
					ans++;
					min = arr[i];
				}
			}
			
			System.out.println(ans);
		}

	}

}

