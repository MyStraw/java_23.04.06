package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _6월3일_문자열폭발_9차수정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String moonjang = br.readLine();
		String bomb = br.readLine();
		Stack<Character> st = new Stack<>();
		

		for (char ch : moonjang.toCharArray()) {
			st.push(ch);
			
			
		}
			
			

		
		
		st.get(1);
		st.elementAt(1);
		st.size();
		bomb.charAt(0);
		

		
		
		System.out.println(st.get(1));
		System.out.println(st.elementAt(1));
		
		//bw.flush 꼭 하자
	}
}
