package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Zero {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt( br.readLine() );	//재민이가 적어야될 수 k
		
		int sum = 0;	//최종합
		
		Stack stack = new Stack();	//스택을 이용
			
		for( int i=0; i<k; i++ ) {
			int a = Integer.parseInt( br.readLine() );
			if( a != 0 ) {
				stack.push( a );	//a가 0이 아니면 부르는 수를 스택에 넣는다.
			} else {
				stack.pop();		//a가 0이면 가장 마지막에 넣은 수를 스택에서 꺼낸다.
			}
		}
		
		for( int i=0; i<stack.size(); i++ ) {
			sum += (int)stack.get(i);	//스택안에있는 모든 수를 더함
		}

		bw.write( sum + "\n");	//결과출력
		
		bw.flush();
		
		bw.close();
		br.close();
	}

}
