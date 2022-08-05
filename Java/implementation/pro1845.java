package implementation;

import java.util.HashSet;

public class pro1845 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        //int[] nums = {3,3,3,2,2,4};
        //int[] nums = {3,3,3,2,2,2};

        int max = nums.length / 2;

        //중복제거
        HashSet<Integer> set = new HashSet<>();
        
        for( int num : nums ) {
            set.add(num);
        }

        //중복을 제거한 셋의 크기가 max보다 크면 max,
        //작으면 set의 size리턴
        if( set.size() > max ) {
            System.out.println( max );
        } else {
            System.out.println( set.size() );
        }
    }
}