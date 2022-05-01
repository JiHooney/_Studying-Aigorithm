package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2643 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//색종이 수
		int n = Integer.parseInt( br.readLine() );
		
		//입력된 색종이의 두 변 길이를 StringTokenizer로 자른다.
		StringTokenizer st;

		//각각의 색종이를 저장할 배열
		int[][] papers = new int[n][2];
		
		//입력된 각 색종이의 두 변 길이를 papers 배열에 저장 
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			
			int a = Integer.parseInt( st.nextToken() );
			int b = Integer.parseInt( st.nextToken() );
			int tmp = 0;
			
			//가로, 세로 중에 더 긴 변이 앞으로 가게 저장한다.
			if( a < b ) {
				papers[i][0] = b;
				papers[i][1] = a;
			} else {
				papers[i][0] = a;
				papers[i][1] = b;
			}
		}
		
		//가장 큰 색종이를 맨 처음에 오게 한다. -> 2차원배열 내림차순 정렬하기
		Arrays.sort( papers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if( o1[0] == o2[0] ) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
		});
		

		//각 색종이마다 올려놓을 수 있는 개수를 구해준다.
		int max = Integer.MIN_VALUE;
		int[] dp = new int[1000];	
		
		for( int i=0; i<n; i++ ) {
			dp[i] = 1; //현재 색종이 1개
			
			//현재 색종이와 이전 색종이를 비교하여 현재 색종이가 더 크면 이전색종이 dp값에 1을 더해준다. 
			for( int j=0; j<i; j++ ) {
				
				if( papers[i][0] >= papers[j][0] && papers[i][1] >= papers[j][1] && dp[i] < dp[j]+1 ) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max( dp[i], max );
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write( String.valueOf(max) );
		bw.flush();
		
		bw.close();
		br.close();
	}
	
}