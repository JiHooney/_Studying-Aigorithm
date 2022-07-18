package bruteforce;

import java.util.Arrays;

public class Pro42885 {
    public static void main(String[] args) {
        int[] people1 = {70, 50, 80, 50};
        int[] people2 = {70, 80, 50};
        int limit = 100;

        int result = 0;
        Arrays.sort( people1 );
        Arrays.sort( people2 );

        int minId = 0;

        for( int maxId=people1.length-1; minId <= maxId; maxId-- ) {
            if( people1[minId] + people1[maxId] <= limit ) {
                minId++;
            }
            result++;
        }

        System.out.println( result );

    }
}
