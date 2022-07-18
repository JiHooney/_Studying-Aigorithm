package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BABBA {
	private static BufferedWriter bw = 
			new BufferedWriter( new OutputStreamWriter(System.out));
	private static int n;
	private static Tmp[] d; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		d = new Tmp[n+1];
		if( n <= 1 ) {
			d[1] = new Tmp( 0, 1 );
			
			bw.write( d[n].a + " " + d[n].b + "\n" );
			bw.flush();
			return;
		}
		d[1] = new Tmp( 0, 1 );
		d[2] = new Tmp( 1, 1 );
		
		for( int i=3; i<=n; i++ ) 
			d[i] = new Tmp( d[i-1].a+d[i-2].a, d[i-1].b+d[i-2].b );
		
		bw.write( d[n].a + " " + d[n].b + "\n" );
		bw.flush();
		
		bw.close();
		br.close();
	}
}

class Tmp {
	int a, b;

	public Tmp(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}