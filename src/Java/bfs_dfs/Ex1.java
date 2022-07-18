package bfs_dfs;

public class Ex1 {

	private static void dfs( int[][] arr, int v, boolean[] visit) {
		//현재노드를 방문처리
		visit[v] = true;
		System.out.print( v + " " );
		
		//현재 노드와 연결된 다른 노드를 재귀적으로 방문하기
		for( int i : arr[v] ) {
			if ( visit[i] == false ) {
				dfs( arr, i, visit );
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {
				{},	//0번 노드 비워놓는다.
				{2, 3, 8},
				{1, 7},
				{1, 4, 5},
				{3, 5},
				{3, 4},
				{7},
				{2, 6, 8},
				{1, 7}
		};
		
		boolean[] visit = new boolean[9];
		for( int i=0; i<9; i++ ) visit[i] = false; 
		
		dfs( arr, 1, visit );
		

	}//main method end

}
