package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AntWarrior1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;		//식량창고의 개수
	private static int[] room;	//식량수가 담길 식량창고 배열
	private static int[] dp; 	//식량창고 수에 따른 결과값이 담길 DP배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		room = new int[n];	//n만큼 식량창고배열 크기 선언
		dp = new int[n];	//n만큼 DP배열 크기 선언
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		for( int i=0; i<n; i++ ) room[i] = Integer.parseInt( st.nextToken() ); 
		
		dp[0] = room[0];
		dp[1] = Math.max( room[0], room[1] );
		
		//바텀업 방식으로 DP구현
		for( int i=2; i<n; i++ ) dp[i] = Math.max( dp[i-1], dp[i-2]+room[i] );
		
		
		bw.write( dp[n-1] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
