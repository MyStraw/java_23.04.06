package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6월3일_문자열폭발_5차수정 { // 잉... 하다보니까 스택 어디갔냐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String moonjang = br.readLine();
		String bomb = br.readLine();
		StringTokenizer st = new StringTokenizer(moonjang, bomb);
//		Queue<String> que = new LinkedList<>();
		//StringTokenizer는 구분자(bomb)를 문자열 묶음으로 구분하지 않고, 각각 글자를 다 구분자로 구분한다.

		
		System.out.print(st.nextToken()); 
		System.out.print(st.nextToken());
		System.out.print(st.nextToken());
		
	

//		while (st.hasMoreElements()) {
//			splitmoonjang += st.nextToken();
//		}
//		if(splitmoonjang != "") {
//		System.out.println(splitmoonjang);
//		}
//		else {
//			System.out.println("FRULA");
//		}

//		String ss = (st.nextToken()+st.nextToken());
//		System.out.println(ss);

//		if(moonjang.length() == 0) {
//			System.out.println("FRULA");
//		}else
//			System.out.println(moonjang);
//		
	}
}
