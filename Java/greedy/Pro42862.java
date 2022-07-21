package greedy;

import java.util.Arrays;

public class Pro42862 {
    public static void main(String[] args) {
        // //첫번째 케이스
        // int n = 5;
        // int[] lost = {2, 4};
        // int[] reserve = {1, 3, 5};

        // //두번째 케이스
        // int n = 5;
        // int[] lost = {2, 4};
        // int[] reserve = {3};

        //세번째 케이스
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int answer = 0;

        int[] students = new int[n+2];
        
        Arrays.fill( students, 1 );
        students[0] = students[n+1] = 0;


        //reserve 학생들 +1
        for( int i=0; i<reserve.length; i++ ) students[reserve[i]]++;

        //lost 학생들 -1
        for( int i=0; i<lost.length; i++ ) students[lost[i]]--;

        //체육복없는 학생들 빌려주기
        for( int i=1; i<=n; i++ ) {
            if( students[i]==0 ) {
                //앞 학생이 여벌있을 때
                if( students[i-1]==2 ) {
                    students[i-1]--;
                    students[i]++;

                //뒤 학생이 여벌있을 때
                } else if( students[i+1]==2 ) {
                    students[i+1]--;
                    students[i]++;
                }
            }
        }

        //체육복 가지고 있는 학생 수 세기
        for( int i=1; i<=n; i++ ) 
            if( students[i]!=0 ) answer++;
        
        
        System.out.println( answer );
    }
}
