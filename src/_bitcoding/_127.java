package _bitcoding;

import java.util.Scanner;

public class _127 {

	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("문장입력 : ");

			String str = sc.nextLine(); // next() 랑 nextLine()은 띄어쓰기 읽기 차이. next()는 띄움 앞까지만 읽고 nextLine()은 문장 전체 다 읽는다

			str = str.toLowerCase();

			int n_a = str.indexOf('a'); // 모음 a의 글자순번 = n_a
			int n_e = str.indexOf('e');
			int n_i = str.indexOf('i');
			int n_o = str.indexOf('o');
			int n_u = str.indexOf('u');

			if (n_a == 0 || n_e == 0 || n_i == 0 || n_o == 0 || n_u == 0) { //index가 0인건 첫번째글자
				System.out.println("Good Sentence");
			} else {
				System.out.println("Bad~~");
			}
		}

	}

}
