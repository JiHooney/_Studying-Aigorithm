package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1525 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder start = new StringBuilder();

        // 입력받는 부분
        for(int i=0;i<3;i++) {
            st=new StringTokenizer( br.readLine() );

            //2차원 배열로 푸는 것보다 1차원 배열이나 문자열로 
            //입력받아서 문제를 푸는 것이 효율적이다.
            for (int j = 0; j < 3; j++) {
                String temp=st.nextToken();

                //완전탐색으로 문제를 풀기 위해 입력값들을 
                //모두 start에 append시켜주고, 0은 9로 바꿔서 넣어준다.
                if(temp.equals("0")) {
                    start.append("9");
                } else { start.append(temp); }
            }
        }

        //BFS부분
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        q.offer( start.toString() );    //큐에 현재 start값을 넣어준다.
        m.put( start.toString(), 0 );   //해쉬맵에 현재 start값과 이동횟수(0)을 넣어준다.

        while( !q.isEmpty() ) {
            String cur = q.poll();
            int nineLoc = cur.indexOf("9");

            /*
            9가 있는 위치, 즉 빈 자리(0)의 좌표는
            예를 들어
            1 2 3 
            4 5 0
            6 7 8
            인데 한 줄로 나타내면 123450678이다.
            이때 0의 index는 5이고,

            x좌표는 5/3 = 1, y좌표는 5%3 = 2
            (1, 2)이 된다.
            */
            int x = nineLoc/3;
            int y = nineLoc%3;
            
            for( int i=0; i<4; i++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nidx = nx*3 + ny;   //빈자리(0)의 새로운 인덱스

                if( nx>=0 && ny>=0 && nx<3 && ny<3 ) {
                    //일단 기존 cur문자열로 next StringBuilder를 만든다.
                    StringBuilder next = new StringBuilder( cur );

                    //새로운 빈자리와 기존 빈자리를 자리바꿈
                    char tmp = next.charAt( nidx );
                    next.setCharAt( nineLoc, tmp );
                    next.setCharAt( nidx, '9');

                    //문자열로 형변환
                    String nextStr = next.toString();

                    //기존 해쉬맵에 없는 키(문자열)라면
                    //큐에도 넣어주고, 해쉬맵에도 이동횟수 1증가시켜서 넣어준다.
                    if( !m.containsKey( nextStr ) ) {
                        q.offer( nextStr );
                        m.put( nextStr, m.get(cur)+1 );
                    }
                }
            }
        }

        //위의 큐 반복문 종료후 "123456798" 키가 있다면 
        //"123456789"키의 이동횟수를 출력하고
        //없다면 -1 출력한다.
        if( m.containsKey("123456789") ) {
            System.out.println( m.get("123456789") );
        } else {
            System.out.println( -1 );
        }
    }
}