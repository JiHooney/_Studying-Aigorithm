package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BJ1181 {
	private static int n;
	private static ArrayList<String> t = new ArrayList<String>();
	private static ArrayList<SortStr> al = new ArrayList<SortStr>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt( br.readLine() );
		
		for( int i=0; i<n; i++ ) {
			String tmp = br.readLine();
			if( !t.contains( tmp ) ) {
				t.add( tmp );
				al.add( new SortStr( tmp.length(), tmp ) );
			}
		}
		SortStr[] ss = (SortStr[])al.toArray( new SortStr[ al.size() ] );
		Arrays.sort( ss, SortStr.strCom );
		Arrays.sort( ss, SortStr.lenCom );
		
		for( int i=0; i<ss.length; i++ ) System.out.println( ss[i].str );	
	}
}

class SortStr {
	int len;
	String str;
	
	public SortStr(int len, String str) {
		this.len = len;
		this.str = str;
	}

	public static Comparator<SortStr> strCom = new Comparator<SortStr>() {
		@Override
		public int compare(SortStr o1, SortStr o2) {
			return o1.str.compareTo( o2.str );
		}
	};
	
	public static Comparator<SortStr> lenCom = new Comparator<SortStr>() {
		@Override
		public int compare(SortStr o1, SortStr o2) {
			return o1.len - o2.len;
		}
	};
}