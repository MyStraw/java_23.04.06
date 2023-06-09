package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6월10일_북극곰은사람을찢어_2차수정 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine()) ; //난 이게 필요가 없어쪄. 그냥 한방에 괄호쌍 다 입력해서.
		//괄호쌍 입력 한방에
		Stack<Character> st = new Stack<>(); //스택으로
		int count = 0;
		int day = 0;
		String bear = br.readLine();
		for (int i = 0 ; i < N ; i ++) { //bear 돌면서 한글자씩 ch에
			char b = bear.charAt(i); 
			st.push(b); //ch를 스택안에 넣어준다.;
			if (st.peek()=='(') { //toString 하지마... character는 '(' 이거쟈냐
				count++;
			}

			else if (st.peek()==')') {
				count--; //( 이거 일 경우에 카운트를 1개 올리고, ) 일 경우 카운트를 1개 깎는다.
			}

			if (Math.abs(count) > day) { //하나 넣을때마다 돌면서 최대 괄호 쌓이는 절대값을 day에 넣어준다. 이게 바로 최대 일수.
				day = Math.abs(count);
			}
		}
		if (count == 0) { //괄호쌍이 무조건 맞아야 가능. //
			System.out.println(day);
		} else
			System.out.println("-1"); //괄호쌍 안맞으면 불가능.
	}

}
