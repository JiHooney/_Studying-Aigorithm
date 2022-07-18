package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1085 {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int x, y, w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		x = Integer.parseInt( st.nextToken() );
		y = Integer.parseInt( st.nextToken() );
		w = Integer.parseInt( st.nextToken() );
		h = Integer.parseInt( st.nextToken() );
	
		//x랑 y좌표 중 작은 거 찾기
		bw.write( Math.min( Math.min( x, w-x ), Math.min( y, h-y ) ) + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}
}