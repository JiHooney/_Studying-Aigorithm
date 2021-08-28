package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
	public static int end;
	public static void dfs( String sb, String nstr, int index, boolean[] re, int n, int a ) {
		
		if( index == -1 ) {
			index = nstr.charAt(a)-'0';
		}
		
		if( !re[index] ) {
			sb += nstr.charAt(a++);
			if( a == nstr.length() ) {
				end = Integer.parseInt( sb );
				return;
			}
			
			index = nstr.charAt( a )-'0';
			dfs( sb, nstr, index, re, n, a );
			
		} else {
			int x1 = 1;
			boolean check = false;
			while( true ) {
				
				if( !re[index-x1] ) {
					if( a == nstr.length() ) {
						end = Integer.parseInt( sb );
						return;
					}
					
					index = nstr.charAt( a )-'0';
					dfs( sb, nstr, index, re, n, a );
					check = true;
				}
				
				if( !re[index+x1] ) {
					if( a == nstr.length() ) {
						end = Integer.parseInt( sb );
						return;
					}
					
					index = nstr.charAt( a )-'0';
					dfs( sb, nstr, index, re, n, a );
					check = true;
				}
				
				if( check ) break;
				else x1++;
				
			}
			
			
			
			
		}
		
		return end;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		int m = Integer.parseInt( br.readLine() );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		boolean[] re = new boolean[10];
		int tmp_broke = 0;
		for( int i=0; i<m; i++ ) {
			tmp_broke = Integer.parseInt( st.nextToken() );
			re[tmp_broke] = true;
		}
		
		int now = 100;
		int cha = Math.abs( now - n );
		
		int ans = 0;
		String sb = null;
		String nstr = n+"";
		int index = -1;
		int a = 0;
		
		dfs( sb, nstr, index, re, n, a );
		
		
		
		
	}
}