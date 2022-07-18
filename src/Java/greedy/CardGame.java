package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardGame {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		int n = Integer.parseInt( st.nextToken() ); //카드 행
		int m = Integer.parseInt( st.nextToken() ); //카드 열
		
		int min = 0;	//결과 변수
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			
			int[] tmp = new int[m];	//각 행에 대한 카드값을 담을 배열
			for( int j=0; j<m; j++ ) {	//m번 순회하면서 카드값을 배열에 담는다.
				tmp[j] = Integer.parseInt( st.nextToken() );
			}
			Arrays.sort(tmp);	//tmp배열을 오름차순으로 정렬
			
			if( i==0 ) min = tmp[i];	//i가 1일 때 min을 tmp의 가장 낮은 값으로 초기화
			if( min < tmp[0] ) min = tmp[0];	//각 행의 첫번째값이 min보다 크면 min을 첫번째값으로 초기화
		}
		
		bw.write( min + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
