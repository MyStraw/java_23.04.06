package chapter4;

public class Test36_1 {

	public static void main(String[] args) {
		char letter = 'A'; // 
		char[] alphabet = new char[26]; // 더블클릭. 디버깅 -> 프로그램을 한줄씩 실행시키게. break 포인트를 집어준거.

		for (int i = 0; i < alphabet.length; i++) { 
			alphabet[i] = (char) (letter + i); 

		}
		for (char c : alphabet) { 
			System.out.println(c); 
		}

	}

}
