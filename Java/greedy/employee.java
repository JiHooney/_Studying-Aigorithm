package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class employee {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		
		int T = Integer.parseInt( br.readLine() );	//테스트케이스 개수
		int[] results = new int[T];	//최종 결과값담는 배열 선언
		
		//테스트 케이스 반복문
		for( int i=0; i<T; i++ ) {
			int N = Integer.parseInt( br.readLine() );	//지원자수
			
			int[][] ranks = new int[N][2];	//지원자 각 순위 담는 배열
			
			//지원자 수 반복문
			for( int j=0; j<N; j++ ) {
				StringTokenizer st = new StringTokenizer( br.readLine(), " " );
				
				ranks[j][0] = Integer.parseInt( st.nextToken() );
				ranks[j][1] = Integer.parseInt( st.nextToken() );
			}
			
			Arrays.sort( ranks, new Comparator<int[]>() {
				public int compare( int a[], int b[] ) {
					if( a[0] == b[0] ) 
						return a[1] - b[1];
					else
						return a[0] - b[0];
				}
			} );
			
			int tmp1 = ranks[0][1];	//서류순위 1등의 면접순위
			
			//tmp1와 각 면접점수들을 비교해서 result값 출력
			for( int k=1; k<N; k++ ) {
				if( ranks[k][1] < tmp1 ) {
					tmp1 = ranks[k][1];
					results[i] += 1;
				}
			}
		}
		
		//최종결과 출력하는 반복문
		for( int i=0; i<T; i++ ) {
			results[i] += 1;
			System.out.println( results[i] );
		}
		

	}
}
