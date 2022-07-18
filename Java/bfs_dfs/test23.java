package bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class test23 {

	public static void main(String[] args) {
		String a = "[404]adfasdf";
		//System.out.println( a.substring(1, 4) );
		
		StringTokenizer st = new StringTokenizer( "[404]adfads" );
		//System.out.println( st.nextToken() );
		ArrayList<String> lis = new ArrayList<String>();
		
		
		
		HashMap<String, Integer> name = new HashMap<String, Integer>();
		name.put( "charlie", 1);
		name.put( "asdf", 111);
		
		HashMap<Integer, HashMap> hm = new HashMap<Integer, HashMap>();
		hm.put( 101, name );
		
		
		for( Entry<Integer, HashMap> entry: hm.entrySet() ) {
			System.out.println( entry.getKey()+" / "+entry.getValue() );
		}
		//System.out.println( hm.get(101).get( "asdf" ) );
	}

}
