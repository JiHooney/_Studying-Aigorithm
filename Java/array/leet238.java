package array;

public class leet238 {
    public static void main(String[] args) {
        //int nums[] = {1, 2, 3, 4};
        int nums[] = {-1, 1, 0, -3, 3};
        
        int n = nums.length;

        int answer[] = new int[n];

        int p = 1;
        //왼쪽 곱셈
        for( int i=0; i<n; i++ ) {
            answer[i] = p;
            p = p * nums[i];
        }

        p = 1;
        //오른쪽 곱셈
        for( int i=n-1; i>=0; i-- ) {
            answer[i] = answer[i] * p;
            p = p * nums[i];
        }

        for( int i=0; i<n; i++ ) {
            System.out.print( answer[i] + " " );
        }
    }
}
