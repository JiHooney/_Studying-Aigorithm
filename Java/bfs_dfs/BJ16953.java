package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair2 {
    long a;
    int res;

    public Pair2( long a, int res ) {
        this.a = a;
        this.res = res;
    }
}

public class BJ16953 {

    static long A, B;
    static Queue<Pair2> q = new LinkedList<Pair2>();
    
    static int BFS() {
        q.add( new Pair2(A, 0) );

        //BFS 연산간 필요한 변수 미리 정의
        int new_res = 0;
        long new_a1, new_a2 = 0;

        while( !q.isEmpty() ) {
            Pair2 p = q.poll();
            
            //밑에서 연산할거니깐 미리 연산횟수 1증가
            new_res = p.res+1;

            //첫 번째 연산 (*)
            new_a1 = p.a * 2;   

            //목표한 B값과 같으면 현재 연산횟수에 +1해서 출력후 메서드 종료
            if( new_a1 == B ) {
                return new_res+1;
            } 
            //연산된 a1가 B보다 작을 떄만 큐에 넣는다.
            else if( new_a1 < B ) {
                q.add( new Pair2(new_a1, new_res) );
            }

            //두 번째 연산 가장 오른쪽에 1을 붙인다.
            new_a2 = (p.a * 10) + 1;

            //목표한 B값과 같으면 현재 연산횟수에 +1해서 출력후 메서드 종료
            if( new_a2 == B ) {
                return new_res+1;
            } 
            //연산된 a2가 B보다 작을 떄만 큐에 넣는다.
            else if( new_a2 < B ) {
                q.add( new Pair2(new_a2, new_res) );
            }
        }

        //위 while반복문이 끝났으면 B를 만들 수 없음을 의미한다.
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong( st.nextToken() );
        B = Long.parseLong( st.nextToken() );

        System.out.println( BFS() );
    }
}
