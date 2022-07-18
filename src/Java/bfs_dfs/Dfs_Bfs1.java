package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs_Bfs1 {
	public static boolean[] visit;
	public static int[][] arr;
	
	private static void dfs( int v ) throws IOException {
		visit[v] = true;
		System.out.print( v+" " );
		
		if( v == arr.length ) return;
		
		for( int i=1; i<arr.length; i++ ) {
			if( arr[v][i] == 1 && visit[i] == false ) dfs(i);
		}
	}
	
	private static void bfs( int v ) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add( v );
		visit[v] = true;
		System.out.print( v+" " );
		
		while( !q.isEmpty() ) {
			int temp  = q.peek();	//temp에 현재 노드값을 저장시키고 큐에서 poll시킨다.
			q.poll();
			
			for( int i=1; i<arr.length; i++ ) {	//현재 노드에서 갈 수 있는 곳을 순회
				if(arr[temp][i] == 1 && visit[i] == false ) {
					q.add(i);
					visit[i] = true;
					System.out.print( i+" " );
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		StringTokenizer st;

		st = new StringTokenizer( br.readLine() );
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		int v = Integer.parseInt( st.nextToken() );
		
		arr = new int[n+1][n+1];
		
		for( int i=1; i<=m; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int a = Integer.parseInt( st.nextToken() );
			int b = Integer.parseInt( st.nextToken() );
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		//행렬 출력해보기
//		for( int i=1; i<arr.length; i++ ) {
//			for( int j=1; j<arr.length; j++ ) {
//				System.out.print( arr[i][j] );
//			}
//			System.out.println( );
//		}
		
		//dfs함수 호출
		visit = new boolean[n+1];
		dfs( v );
		
		System.out.println();
		
		//bfs함수 호출
		visit = new boolean[n+1];
		bfs( v );
		
	}
	
	
}
