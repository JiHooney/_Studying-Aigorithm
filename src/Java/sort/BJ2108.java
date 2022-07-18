package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		
		int[] arr = new int[8001];		//입력값이 arr 인덱스가 된다.
		int sum = 0;					//산술평균에 쓰일 전체합
		int min = Integer.MAX_VALUE;	//범위 구할 때 쓰일 min
		int max = Integer.MIN_VALUE;	//범위 구할 때 쓰일 max
		
		int mean = 0;		//산술평균
		int mid = 0;		//중앙값
		int mode = 0;		//최빈값
		int range = 0;		//값의 범위
		
		for( int i=0; i<n; i++ ) {
			int tmp = Integer.parseInt( br.readLine() );
			
			//최소값과 최대값을 구한다.
			if( tmp < min ) min = tmp;	
			if( tmp > max ) max = tmp;
			
			sum += tmp;	//산술평균 구하기위해 전체 입력값들 더하기
			arr[4000+tmp]++;	//최빈값 구할 때 사용하기위해 해당 인덱스의 값을 1씩 증가
		}

		ArrayList<Integer> brr = new ArrayList<Integer>();	//최빈값 저장될 리스트
		ArrayList<Integer> crr = new ArrayList<Integer>();	//중앙값 구하기 위해 새로운 배열을 만든다.
		
		int tmp = 1;	//가장 큰 빈도수가 저장될 임시변수
		int k = 0;		//crr배열 인덱스를 위한 변수
		
		for( int i=4000+min; i<=4000+max; i++ ) {
			
			//빈도수가 1 이상일 때
			if( arr[i] >= 1 ) {
				
				//중앙값 구하기위해 crr배열에 값을 넣는다.
				int a = arr[i];
				while( a --> 0 ) { crr.add(i-4000); }
				
				//기존빈도수보다 큰 빈도수가 나타났을 때 
				//최빈값 빈도수 변수 초기화,
				//최빈값 저장될 리스트 초기화하고 다시 저장
				if( arr[i] > tmp ) {
					brr = new ArrayList<Integer>();
					tmp = arr[i];				
					brr.add( i-4000 );
					
				//기존 빈도수와 같은 빈도수일 때 최빈값 리스트에 값 저장
				} else if( arr[i] == tmp ) {
					brr.add( i-4000 );
				}
				
				k++;
			}
		}
		
		//산술평균 구하기
		mean = (int)Math.round( (sum/(double)n) );
		
		//중앙값 구하기
		mid = crr.get( crr.size()/2 );
		
		//최빈값 구하기
		//최빈값 리스트가 1보다 클 경우 두 번째로 큰 값이 최빈값이다.
		if( brr.size() > 1 ) mode = brr.get(1);
		//최빈값리스트 크기가 1일 경우 가장 큰 최빈값 하나밖에 없다.
		else mode = brr.get(0);	

		//값의 범위 구하기
		range = max-min;
		
		StringBuffer sb = new StringBuffer();
		sb.append( mean+"\n" + mid+"\n" + mode+"\n" + range+"\n" );
		System.out.println( sb );
	}
}