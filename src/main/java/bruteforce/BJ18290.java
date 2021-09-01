package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18290 {
	static int n, m, k;
	static int[][] arr, visit; 
	static int[] ans; //선택할 값을 넣을 배열
	static int max = Integer.MIN_VALUE;
	
	public static void findMax( int depth ) {
		//depth값이 k이면 최대값 갱신
		if( depth == k ) {
			int tmp = 0;
			for( int i : ans ) tmp += i;
			max = Math.max( max, tmp );
			
		} else {
			for( int i=0; i<n; i++ ) {
				for( int j=0; j<m; j++ ) {
					if( visit[i][j] > 0 ) continue;
					
					ok( i, j );	//상하좌우 좌표에서 재귀호출되지 않도록 상하좌우의 check값을 증가시킨다.
					ans[depth] = arr[i][j];	//현재값을 ans배열에 넣는다.
					findMax( depth+1 );
					comeBack( i, j );	//상하좌우의 check값을 원상복구 시킨다.
				}
			}
			
		}
	}
	
	public static void ok( int row, int col ) {
		visit[row][col]++;  //현재값에 +1을 해준다.
		
		//row의 경우 0~n, col의 경우 0~m까지 범위를 벗어나지 않는지 검사
		//벗어나지 않으면 해당좌표의 visit값을 1씩 증가한다.
		//왼쪽
		if( col-1 >= 0 ) visit[row][col-1]++;
		//오른쪽
		if( col+1 < m ) visit[row][col+1]++;
		//위쪽
		if( row-1 >= 0 ) visit[row-1][col]++;
		//아래쪽
		if( row+1 < n ) visit[row+1][col]++;
	}
	
	public static void comeBack( int row, int col ) {
		//원상복구를 위해 현재값과 현재값의 상하좌우에 -1을 해준다.
		visit[row][col]--;  
		
		//왼쪽
		if( col-1 >= 0 ) visit[row][col-1]--;
		//오른쪽
		if( col+1 < m ) visit[row][col+1]--;
		//위쪽
		if( row-1 >= 0 ) visit[row-1][col]--;
		//아래쪽
		if( row+1 < n ) visit[row+1][col]--;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		k = Integer.parseInt( st.nextToken() );
		ans = new int[k];
		arr = new int[n][m];
		visit = new int[n][m];
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for( int j=0; j<m; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		findMax( 0 );
		
		System.out.println( max );
	}
}