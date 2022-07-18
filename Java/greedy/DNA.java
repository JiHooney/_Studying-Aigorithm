package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DNA {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static char toChar( int a, int t, int g, int c, int max ) {
		if( max==a ) return 'A';
		else if( max==c ) return 'C';
		else if( max==g ) return 'G';
		else return 'T';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		int N = Integer.parseInt( st.nextToken() );
		int M = Integer.parseInt( st.nextToken() );
		
		String[] list = new String[N];
		int max = 0, hd = 0;
		
		for( int i=0; i<N; i++ ) {
			String dna = br.readLine();
			list[i] = dna;
		}
		
		for( int i=0; i<M; i++ ) {
			int a=0, t=0, g=0, c=0;
			
			for( int j=0; j<N; j++ ) {
				switch( list[j].charAt(i) ) {
				case 'A': a++; break;
				case 'T': t++; break;
				case 'G': g++; break;
				case 'C': c++; break;
				}
			}
			max = Math.max( a>c? a:c , g>t? g:t );
			hd += ( N-max );
			bw.write( toChar(a,t,g,c,max) );
		}
		bw.write( "\n" + hd + "\n" );
		
		bw.flush();
		bw.close();
		br.close();
	}
}
