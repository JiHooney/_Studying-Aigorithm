package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		Queue<Integer> que = new LinkedList<Integer>();
		for( int i=1; i<=n; i++ ) que.add( i );
		
		int tmp = 0;
		while( que.size() > 1 ) {
			que.poll();
			tmp = que.poll();
			que.add( tmp );
		}
		System.out.println( que.poll() );
	}
}