package sort;

import java.util.Arrays;

public class SortExam {
	
	//버블정렬
	static int[] bubble( int[] arr ) {
		int len = arr.length;
		int tmp;
		
		for( int i=0; i<len; i++ ) {
			for( int j=0; j<len-1; j++ ) {
				if( arr[j] > arr[j+1] ) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr;
	}
	
	//선택정렬
	static int[] selection( int[] arr ) {
		int len = arr.length;
		int tmp;
		
		for( int i=0; i<len; i++ ) {
			for( int j=0; j<len; j++ ) {
				if( arr[i] < arr[j] ) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}		
		return arr;
	}
	
	//삽입정렬
	static int[] insert( int[] arr ) {
		int len = arr.length;
		int tmp;
		
		for( int i=1; i<len; i++ ) {
			tmp = arr[i];
			int j=i-1;
			for( ; j > -1 && arr[j] > tmp; j-- ) { 
				arr[j+1] = arr[j];
			}
			arr[j+1] = tmp;
		}
		return arr;
	}
	
	//병합정렬
	static int[] tmp;
	static void merge( int[] arr, int start, int end ) {
		
		//시작 인덱스가 끝 인덱스보다 작으면 배열을 더 쪼갠다.
		if( start < end ) {
			int mid = (start+end) / 2;
			merge( arr, start, mid );
			merge( arr, mid+1, end );
			
			int p = start;
			int q = mid + 1;
			int idx = p;
			
			//p나 q인덱스가 mid보다 작으면 비교를 반복한다.
			while( p<=mid || q<=end ) {
				
				//q인덱스값은 end를 넘어서 이미 비교할 게 없거나 
				//p는 아직 mid보다 작고 arr[p]가 arr[q]보다 작으면
				//임시배열 tmp에 arr[p]의 값을 넣는다.
				if( q > end || ( p <= mid && arr[p] <= arr[q] ) ) 
					tmp[idx++] = arr[p++];
				
				//반대로 q<end이거나 p>mid && arr[p] > arr[q]인 경우
				//tmp배열에 arr[q]의 값을 넣는다.
				else tmp[idx++] = arr[q++];
			}
			
			//위에서 정렬했던 값을 다시 arr배열에 넣어준다.
			for( int i=start; i<=end; i++ ) arr[i] = tmp[i];
		}
	}
	
	//퀵정렬
	static void quik( int[] arr, int low, int high ) {
		if( low >= high ) return;
		
		//중간 피벗 퀵정렬을 한다.
		int mid = partition( arr, low, high );
		quik( arr, low, mid-1 );
		quik( arr, mid, high );
	}
	
	static int partition( int[] arr, int low, int high ) {
		//중간값을 피벗값으로 설정
		int pivot = arr[ (low+high) / 2 ];
		
		//low값이 high값보다 작으면 반복
		while( low <= high ) {
			
			//arr[low]가 피벗값보다 작으면 low증가
			while( arr[low] < pivot ) low++;
			//arr[high]가 피벗값보다 크면 high감소
			while( arr[high] > pivot ) high--;
			
			//위의 while문이 끝났을때 low가 high보다 작거나 같으면 
			//low와 high 인덱스의 배열값을 바꾼다.
			if( low <= high ) {
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
				
				low++;
				high--;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int origin[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr = Arrays.copyOfRange( origin, 0, origin.length ); 
		
		//버블정렬
		System.out.println( "---버블정렬---" );
		int[] bubbleAns = bubble( arr );
		for( int i=0; i<bubbleAns.length; i++ ) System.out.print( bubbleAns[i] +" " );
		System.out.println( "\n" );
		
		//선택정렬 : 최선의 경우든 최악의 경우든 한결같이 O(n^2)의 시간복잡도를 가진다.
		System.out.println( "---선택정렬---" );
		arr = Arrays.copyOfRange( origin, 0, origin.length );
		int[] selectAns = bubble( arr );
		for( int i=0; i<selectAns.length; i++ ) System.out.print( selectAns[i] +" " );
		System.out.println( "\n" );
		
		//삽입정렬 : 값을 하나 선택하고 그 값보다 앞에있는 값들과 비교하면서 앞에있는 값이 클 경우 현재 값을 그 앞에 추가
		System.out.println( "---삽입정렬---" );
		arr = Arrays.copyOfRange( origin, 0, origin.length );
		int[] insertAns = bubble( arr );
		for( int i=0; i<insertAns.length; i++ ) System.out.print( insertAns[i] +" " );
		System.out.println( "\n" );
		
		//병합정렬
		System.out.println( "---병합정렬---" );
		arr = Arrays.copyOfRange( origin, 0, origin.length );
		tmp = new int[ arr.length ];
		merge( arr, 0, arr.length-1 );
		for( int i=0; i<tmp.length; i++ ) System.out.print( tmp[i] + " ");
		System.out.println( "\n" );
		
		//퀵정렬
		System.out.println( "---퀵정렬---" );
		arr = Arrays.copyOfRange( origin, 0, origin.length );
		quik( arr, 0, arr.length-1 );
		for( int i=0; i<tmp.length; i++ ) System.out.print( arr[i] + " ");
	}
}