package implementation;

import java.util.ArrayList;

public class SelfNumber1 {
	
	private static ArrayList<Integer> arr = new ArrayList<Integer>(10000);
	private static int num;
	private static int tmp;
	
	public static void main(String[] args) {
		for( int i=1; i<=10000; i++ ) arr.add( i );
		
		for( int i=1; i<=10000; i++ ) {
			num = 0; tmp = 0;
			
			String end = i+"";
			for( int j=0; j<end.length(); j++ ) {
				tmp += end.charAt(j)-'0';
			}
			num = i+tmp;
			
			try {
				arr.remove( arr.indexOf(num) );
			} catch (Exception e) {
				continue;
			}
			
		}
		
		for( int i=0; i<arr.size(); i++ ) {
			System.out.println( arr.get(i) );
		}

	}//main method end
}//class end
