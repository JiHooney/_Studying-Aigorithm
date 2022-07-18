package greedy;
import java.util.Scanner;

public class coin {
	
	//동전수 계산해주는 메소드
	public static int calCoin( int[] coins_arr, int num2 ) {
		int len_arr = coins_arr.length;
		int result = 0;	//결과 출력값
		
		for( int i=len_arr-1; i>=0; i-- ) {
			int re = num2 / coins_arr[i];
			result += re;	//결과값에 동전수를 해당 동전수를 더한다.
			num2 -= re % coins_arr[i];	//해당동전수를 원래돈에서 빼준다.
			
			if( num2 == 0 )
				break;
		}
		
		return result;
	}
	
	
    public static void main( String[] args ) {
    	
        Scanner sc = new Scanner( System.in );
    	System.out.println( "첫 번째 입력값: 사용할 동전 수, 두 번째 입력값: 구하고자 하는 금액(숫자만입력)");
    	String input = sc.nextLine();
    	
    	String[] inputs = input.split(" ");
    	
    	int num1;
    	int num2;
    	
		try {
			num1 = Integer.parseInt( inputs[0] );
			num2 = Integer.parseInt( inputs[1] );
			
	    	int[] coins = { 1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000 };
	    	int[] coins_arr = new int[num1];	//동전수 계산시 사용할 배열
	    	
	    	//사용자 입력값만큼 사용할 동전을 출력한다.
	    	for( int i=0; i<num1; i++ ) {
	    		//System.out.println( coins[i] );
	    		coins_arr[i] = coins[i];
	    		System.out.println( coins_arr[i] );
	    	}
	    	
	    	int result = calCoin( coins_arr, num2 );
	    	
	    	//끝
	    	System.out.println( result );
			
		} catch (NumberFormatException e) {
			System.out.println( "숫자만 입력해주세요." );
			System.exit(2);
		}
    	
    	
    }
}
