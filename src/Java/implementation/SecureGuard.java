package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SecureGuard {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer( br.readLine() );
		int a = Integer.parseInt( st.nextToken() );	//블록 가로 길이
		int b = Integer.parseInt( st.nextToken() );	//블록 세로 길이
		int c = Integer.parseInt( br.readLine() );	//상점의 개수
		
		int[][] shops = new int[c][2];	//상점좌표 담을 2차원 배열
		
		for( int i=0; i<c; i++ ) {
			st = new StringTokenizer( br.readLine(), " " );
			shops[i][0] = Integer.parseInt( st.nextToken() );	//각 상점 좌표
			shops[i][1] = Integer.parseInt( st.nextToken() );
		}
		
		st = new StringTokenizer( br.readLine() );
		int x = Integer.parseInt( st.nextToken() );	//동근이 위치
		int y = Integer.parseInt( st.nextToken() );
		
		int sum = 0;
		
		//상점 개수만큼 순회하면서 각 상점이 북,남,서,동의 경우로 나눔
		//상점이 북쪽일 경우 또 동근이의 위치를 북,남,서,동의 경우로 나눔
		//상점과 동근이의 시계방향과 시계반대방향의 거리를 구한다음 둘 중에 작은 거를 sum에 더한다.
		for( int i=0; i<c; i++ ) {	
			if( shops[i][0] == 1 ) {
				if( shops[i][0] == x ) {	//상점의 위치와 동근이의 위치가 같은 경우
					sum += Math.abs( shops[i][1] - y );
				} else if( x == 2 ) {		//상점은 북쪽, 동근이는 남쪽인 경우 시계, 반시계 거리를 구한다.
					sum += ( shops[i][1]+b+y ) < ( a-shops[i][1]+b+a-y ) ? shops[i][1]+b+y : a-shops[i][1]+b+a-y;
				} else if( x == 3 ) {		//상점은 북쪽, 동근이는 서쪽인 경우
					sum += shops[i][1]+y;
				} else {					//상점은 북쪽, 동근이는 동쪽인 경우
					sum += a-shops[i][1]+y;
				}
				
			} else if( shops[i][0] == 2 ) {
				if( shops[i][0] == x ) {
					sum += Math.abs( shops[i][1] - y );
				} else if( x == 1 ) {
					sum += ( shops[i][1]+b+y ) < ( a-shops[i][1]+b+a-y ) ? shops[i][1]+b+y : a-shops[i][1]+b+a-y;
				} else if( x == 3 ) {
					sum += shops[i][1]+b-y;
				} else {
					sum += a-shops[i][1]+b-y;
				}
				
			} else if( shops[i][0] == 3 ) {
				if( shops[i][0] == x ) {
					sum += Math.abs( shops[i][1] - y );
				} else if( x == 1 ) {
					sum += shops[i][1]+y;
				} else if( x == 2 ) {
					sum += b-shops[i][1]+y;
				} else {
					sum += ( shops[i][1]+a+y ) < ( b-shops[i][1]+a+b-y ) ? shops[i][1]+a+y : b-shops[i][1]+a+b-y;
				}
	
			} else {
				if( shops[i][0] == x ) {
					sum += Math.abs( shops[i][1] - y );
				} else if( x == 1 ) {
					sum += a-shops[i][1]+y;
				} else if( x == 2 ) {
					sum += a-shops[i][1]+b-y;
				} else {
					sum += ( shops[i][1]+a+y ) < ( b-shops[i][1]+a+b-y ) ? shops[i][1]+a+y : b-shops[i][1]+a+b-y;
				}
				
			}
		}

		bw.write( sum + "\n" );
		
		bw.flush();

		bw.close();
		br.close();
	}
}
