package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		StringTokenizer st;
		AgeName[] an = new AgeName[n];
		
		for( int i=0; i<n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			an[i] = new AgeName( Integer.parseInt( st.nextToken() ), st.nextToken(), i );
		}
		Arrays.sort( an, new Comparator<AgeName>() {
			@Override
			public int compare(AgeName o1, AgeName o2) {
				if( o1.age == o2.age ) return o1.num - o2.num;
				return o1.age-o2.age;
			}
		});
		
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<n; i++ ) sb.append( an[i].age + " " + an[i].name + "\n" );
		System.out.println( sb );
	}
}

class AgeName {
	int age;
	String name;
	int num;
	
	public AgeName(int age, String name, int num) {
		this.age = age;
		this.name = name;
		this.num = num;
	}
}