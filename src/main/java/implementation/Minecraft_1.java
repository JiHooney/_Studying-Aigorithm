package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Minecraft_1 {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a,b;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//행
		int m = Integer.parseInt(st.nextToken());	//열
		int k = Integer.parseInt(st.nextToken());	//인벤토리
		int[][] map = new int[n][m];			//각 땅의 높이 담을 배열
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer(br.readLine());
			//각 땅의 높이를 배열에 담는다.
			for( int j=0; j<m; j++ ) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		//가장 높은 땅을 구함
		for( int i=0; i<n; i++ ) 
			for( int j=0; j<m; j++ ) 
				max = Math.max(max, map[i][j]); 
		
		
		int height = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;
		
		for( int h=max; h>=0; h--) {
			a = b = 0;
			
			for( int i=0; i<n; i++ ) 
				for( int j=0; j<m; j++ ) {
					if( map[i][j]>h ) {
						a += map[i][j] - h;
					} else {
						b += h - map[i][j];
				}
			}
			if( a+k-b < 0 ) continue;
			if( a*2+b < time ) {
				time = a*2+b;
				height = h;
			}
		}
		bw.write( time+" "+height + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
		
	}
}