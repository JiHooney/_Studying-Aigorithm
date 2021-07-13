package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FloorConstruction1 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;		//바닥 가로 길이
	private static int[] dp = new int[1001]; 	//DP배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		dp[1] = 1;
		dp[2] = 3;
		for( int i=3; i<=n; i++ ) dp[i] = ( dp[i-1]+2*dp[i-2] )%796796;
		
		bw.write( dp[n] + "\n" );
		
		bw.close();
		br.close();
	}
}
