package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Minecraft {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int i, j;	//반복문 변수
		
		st = new StringTokenizer( br.readLine() );
		
		int n = Integer.parseInt( st.nextToken() );	//N개의 행
		int m = Integer.parseInt( st.nextToken() );	//M개의 열
		int b = Integer.parseInt( st.nextToken() );	//인벤토리 안에 보유하고있는 블록 개수
		
		int time = 0;
		
		int[][] ground = new int[n][m];	//초기 땅 블록 담을 배열
		HashMap<Integer, Integer> hm = new HashMap<>();	//초기 땅 블록에서 높이별 개수를 세기위한 변수
		
		for( i=0; i<n; i++ ) {	//n개 줄만큼 초기블록 설정
			st = new StringTokenizer( br.readLine() );
			
			for( j=0; j<m; j++ ) {
				ground[i][j] = Integer.parseInt( st.nextToken() );
				
				//해시맵 안에 각 높이별 개수를 집어넣는다. 0이 11개고 1이 1개면 => 0: 11개, 1: 1개
				if( hm.get( ground[i][j] ) == null ) hm.put( ground[i][j], 1 );
				else hm.put( ground[i][j], hm.get( ground[i][j] )+1 );
			}
		}

		
		//해시맵에서 가장 값이 큰 키를 찾아낸다. -> 가장 많이 나오는 높이를 찾음
		int max_value = 0;
		int max_ground = 0;	//가장 많이 나오는 높이 변수
		
		for( Integer k : hm.keySet() ) {
			if( max_value < hm.get(k) ) {
				max_value = hm.get(k);
				max_ground = k;		//64가 가장 많이나왔으면 64가 저장된다.
			}
		}
		
		
		a:for( i=0; i<n; i++ ) {
			for( j=0; j<m; j++ ) {
				
				//땅 높이 배열의 값이 가장많이나온높이(64)보다 크면 인벤토리에 차이를 저장하고 블록을 빼준다.
				if( ground[i][j] > max_ground ) {	
					int cha = ground[i][j] - max_ground;
					b += cha;
					time += 2*cha;
					ground[i][j] -= cha;
					continue;
				
				//땅 높이 배열의 값이 가장 많이나온 높이(64)보다 작으면 인벤토리에서 1을 빼고 블록을 쌓아준다. 
				//이때 인벤토리가 0이면 땅 높이 배열의 값을 평평하게 해야되는 높이로 바꿔준다.
				} else if( ground[i][j] < max_ground ) {
					if( b > 0 ) {
						b -= 1;
						ground[i][j] += 1;
						time += 1;
						j -= 1;
						continue;
					} else {
						max_ground = ground[i][j];
						i = -1;
						continue a;
					}
				}
			}
		}
		
		bw.write( time + " " + max_ground + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}

}
