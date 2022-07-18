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
		//가장 높은 땅을 구한다.
		for( int i=0; i<n; i++ ) 
			for( int j=0; j<m; j++ ) 
				max = Math.max(max, map[i][j]); 
		
		
		int height = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;
		
		//가장 높은 층에서 0으로 내려오면서 각 층에 대한 시간을 구한다.
		for( int h=max; h>=0; h--) {
			a = 0;	//a는 블록을 제거하여 인벤토리에 넣는 블록의 개수
			b = 0;	//b는 인벤토리에서 꺼내서 쌓을 블록의 개수
			
			for( int i=0; i<n; i++ ) 
				for( int j=0; j<m; j++ ) {
					//기준인 h층보다 클 경우 인벤토리에 넣을 블록의 수를 증가시킨다.
					if( map[i][j]>h ) {		
						a += map[i][j] - h;
					}
					//기준인 h층보다 크지않을 경우 인벤토리에서 꺼낼 블록의 개수를 증가시킨다.
					else {
						b += h - map[i][j];
					}
			}
			//만약 인벤토리에 블록이 없다면 층을 낮힌다.
			if( a+k-b < 0 ) continue;	
			//위에층의 시간보다 현재층의 시간이 더 적으면 time과 height를 초기화한다.
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