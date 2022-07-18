package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		//t와 p배열의 크기가 n+2인 이유는
		//편의상 일수와 인덱스를 맞추기 위해 1인덱스부터 시작해야 되기 때문에 n+1이 되고,
		//이제 여기서 n=7인 경우 8일까지 계산해야되기 때문에 n+2가 된다.
		int[] t = new int[n+2];
		int[] p = new int[n+2];
		
		//dp배열의 크기가 n+6인 이유는
		//마찬가지로 인덱스를 1부터 시작할거니깐 n+1인 상태에서
		//마지막날의 업무일수를 계산한 것이다.
		//n=7일 때 마지막날에 최대로 올 수 있는 상담기간 t는 5이기 때문에
		//5를 더해서 n+6의 크기를 가지는 배열이 필요하다.
		int[] dp = new int[n+6];
		int max = 0;
		
		//t와 p배열에 입력값 저장
		StringTokenizer st;
		for( int i=1; i<=n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			t[i] = Integer.parseInt( st.nextToken() );
			p[i] = Integer.parseInt( st.nextToken() );
		}
		
		//1일부터 n+1일까지 계산한다. 
		//왜 n+1 일이냐면 만약 첫째날의 상담기간이 3일 걸리는 경우 
		//4일째되는 날에 첫째날의 결과가 저장되기 때문이다.
		for( int i=1; i<=n+1; i++ ) {
			dp[i] = Math.max( dp[i], max );
			dp[i+t[i]] = Math.max( dp[i+t[i]], dp[i]+p[i] );
			max = Math.max( max, dp[i] );
		}
		
		System.out.println( max );
	}
}