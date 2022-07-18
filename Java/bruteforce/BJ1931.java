package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1931 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt( br.readLine() );

        StringTokenizer st;
        int meeting[][] = new int[N][2];
        for( int i=0; i<N; i++ ) {
            st = new StringTokenizer( br.readLine(), " " );
            meeting[i][0] = Integer.parseInt( st.nextToken() );
            meeting[i][1] = Integer.parseInt( st.nextToken() );
        }

        //종료시간을 기준으로 오름차순 정렬한다.
        Arrays.sort( meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시간이 같을 경우 시작시간이 빠른순으로 정렬한다.
                if( o1[1] == o2[1] ) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            } 
        });

        int result = 0;
        int prev_end_time = 0;

        for( int i=0; i<N; i++ ) {

            //이전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if( prev_end_time <= meeting[i][0] ) {
                prev_end_time = meeting[i][1];
                result++;
            }
        }

        System.out.println( result );

    }
}
