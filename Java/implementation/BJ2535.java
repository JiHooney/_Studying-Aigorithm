package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class contest {
    int nation;
    int stuNum;
    int score;

    public contest( int nation, int stuNum, int score ) {
        this.nation = nation;
        this.stuNum = stuNum;
        this.score = score;
    }
}

public class BJ2535 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt( br.readLine() );

        contest[] cts = new contest[N];

        StringTokenizer st;
        for( int i=0; i<N; i++ ) {
            st = new StringTokenizer( br.readLine() );
            
            int tmp_nation = Integer.parseInt( st.nextToken() );
            int tmp_stuNum = Integer.parseInt( st.nextToken() );
            int tmp_score = Integer.parseInt( st.nextToken() );

            cts[i] = new contest( tmp_nation, tmp_stuNum, tmp_score );
        }

        Arrays.sort( cts, new Comparator<contest>() {
            @Override
            public int compare( contest o1, contest o2 ) {
                return o2.score-o1.score;
            }
        });

        int[] visit = new int[N+1];
        int cnt_answer = 0;

        for( int i=0; i<N; i++ ) {
            if( cnt_answer >= 3 ) break;
            
            if( visit[cts[i].nation] < 2 ) {
                System.out.println( cts[i].nation+" "+cts[i].stuNum );

                cnt_answer++;
                visit[cts[i].nation]++;
            }
        }

    }
}
