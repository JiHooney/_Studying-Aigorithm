package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThisCote_4_1_answer {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt( br.readLine() );
        StringTokenizer st = new StringTokenizer( br.readLine() );

        int x = 1;
        int y = 1;

        //L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] moveTypes = {"L", "R", "U", "D"};

        while( st.hasMoreTokens() ) {
            int nx = 0;
            int ny = 0;
            String s = st.nextToken();


            for( int i=0; i<moveTypes.length; i++ ) {
                if( s.equals(moveTypes[i]) ) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }

            if( nx < 1 || nx > N || ny < 1 || ny > N ) {
                continue;
            }
            x = nx;
            y = ny;
        }

        System.out.println(x+" "+y);
    }
}
