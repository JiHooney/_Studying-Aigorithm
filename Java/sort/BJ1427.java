package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BJ1427 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for( int i=0; i<N.length(); i++ ) {
            int tmp = N.charAt(i)-'0';
            hm.put( tmp, hm.getOrDefault(tmp, 0)+1 ); 
        }

        //hashmap key sort
        Object[] mapkey = hm.keySet().toArray();
        Arrays.sort(mapkey);

        String result = "";

        for( Integer key : hm.keySet() ) {
            for( int i=hm.get(key); i>0; i-- ) result = key+result;
        }

        System.out.println( result );
    }
}
