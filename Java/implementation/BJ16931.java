package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ16931 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n, m, sum;
	private static int[][] arr;
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		arr = new int[n+1][m+1];
		
		//각 종이 위에 있는 각각의 도형값을 입력받음과 동시에 겉넓이를 구한다.
		for( int i=1; i<=n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=1; j<=m; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
				sum += 2 + arr[i][j]*4;
			}
		}
		
		//각각의 도형들의 겉넓이에서 겹쳐진 도형의 겉넓이를 빼준다.
		//먼저 행에 대해서 겹치는 부분을 빼준다.
		for( int i=1; i<=n; i++ ) {
			for( int j=1; j<m; j++ ) {
				sum -= Math.min( arr[i][j], arr[i][j+1] ) * 2;
			}
		}
		//다음으로 열에 대해서 겹치는 부분을 빼준다.
		for( int i=1; i<=m; i++ ) {
			for( int j=1; j<n; j++ ) {
				sum -= Math.min( arr[j][i], arr[j+1][i] ) * 2;
			}
		}
		
		bw.write( sum + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}