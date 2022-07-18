package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UpStairs1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;		//총 계단의 수
	private static int[] s;		//계단점수 담을 배열
	private static int[] dp;	//각 계단에 따른 점수 합 담을 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		s = new int[n+1];		//1부터 시작할 수 있도록 n+1크기의 배열로 초기화한다.
		dp = new int[n+1];		
		
		for( int i=1; i<=n; i++ ) s[i] = Integer.parseInt( br.readLine() );
		
		dp[1] = s[1];		//dp[1]은 s[1]로 초기화한다.
		if( n>=2 ) dp[2] = dp[1] + s[2];		//n이 2보다 클경우 dp[2]도 초기화한다.
		
		//DP 바텀업방식으로 진행
		for( int i=3; i<=n; i++ ) 
			dp[i] = Math.max( dp[i-2]+s[i], dp[i-3]+s[i-1]+s[i] );
		
		bw.write( dp[n] + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
