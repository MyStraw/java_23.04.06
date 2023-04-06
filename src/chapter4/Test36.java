package chapter4;

public class Test36 {

	public static void main(String[] args) {
		char letter = 'A'; // 실제 메모리 상에선 65. int로 읽으면 65, char로 읽으면 A 서로 상호호환
		char[] alphabet = new char[26]; //26개짜리 배열 만들고

		for (int i = 0; i < alphabet.length; i++) { // 26바퀴 루프 돌고
			alphabet[i] = (char) (letter + i); // letter를 65로 인식. i=0. 65를 (char)로 강제로 char 타입으로 캐스팅

		}
		for (char c : alphabet) { // 알파벳에서 1개씩 떠내 c에 담고 돌려
			System.out.println(c); // ln 지우면 옆으로
		}

	}

}
