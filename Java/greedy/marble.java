//-40 30 30인 경우
//40 + 30
//40 + 30
//40 * 2 + (30 + 30)
//
//-50 40 40 30인 경우
//50 + 40
//50 + 40
//50 + 30
//50 * 3 + (40 + 40 + 30)
//
//-60 60 40 40 30인 경우
//60 + 60
//60 + 40
//60 + 40
//60 + 30
//60 * 4 + ( 60 + 40 + 40 + 30 )
//
//따라서 공식
//( max * (n-1) )+ ( 나머지 값들의 합)

package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class marble {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int n = Integer.parseInt( br.readLine() );
		ArrayList<Integer> L = new ArrayList<>();

		st = new StringTokenizer( br.readLine() );
		
		int max = 0;
		int maxIndex = 0;
		int result = 0;
		
		while( st.hasMoreTokens() ) {
			L.add( Integer.parseInt(st.nextToken() ) );
		}
		
		for( int i=0; i<n; i++ ) {
			int level = L.get(i);
			
			if( max < level ) {
				max = level;
				maxIndex = i;
			}
			result += level;
		}
		
		result += max * (L.size() - 2);
		
		bw.write( result + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}
