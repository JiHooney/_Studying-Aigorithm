package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
	static int n, ans;
	static int[][] arr;
	static int[] visit;
	
	public static void cal( int index, int depth ) {
		if( depth == (n/2) ) {
			int t1 = 0;
			int t2 = 0;
			
			for( int i=0; i<n; i++ ) {
				for( int j=i+1; j<n; j++ ) {
					if( visit[i] == 1 && visit[j] == 1 ) {
						t1 += arr[i][j];
						t1 += arr[j][i];
					} else if( visit[i] == 0 && visit[j] == 0 ) {
						t2 += arr[i][j];
						t2 += arr[j][i];
					}
				}
			}
			
			int cha = Math.abs( t1-t2 );
			if( cha == 0 ) {
				System.out.println( cha );
				System.exit( 0 );
			}
			
			ans = Math.min( ans, cha );
			return;
			
		}
		
		for( int i=0; i<n-1; i++ ) {
			if( visit[i] == 0 ) {
				visit[i] = 1;
				cal( i+1, depth+1 );
				visit[i] = 0;
			}
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		arr = new int[n][n];
		visit = new int[n];
		StringTokenizer st;
		ans = Integer.MAX_VALUE;
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<n; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		cal( 0, 0 );
		System.out.println( ans );
		
	}
}