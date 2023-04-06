package chapter5;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in); // 우리 써본거.
//		int i = sc.nextInt();

		Armor armor = new Armor(); // 하나의 데이터 타입으로서 작용.(메소드) 스트링, 플롯 이런 기본적인거 말고, 우리가 만든 데이터
		// 객체를 만들었다.
		armor.setName(); // Armor.java에서 만든거 호출한거다.
		// 이걸 왜 써먹나? 일단 이해하고 따라가. 난쥬 클래스 응용하면 유용하단거 알겨

		armor.getName();

		String name = armor.getName();
		System.out.println("Name:" + name);
		
		//이거하면 마크6가 뜨냐 노네임이 뜨냐 => 마크가 뜨지
		//setName을 주석처리하면 NO name 뜬다.
		
		//Armor.java 파일이랑 같이 열어두고 봐

	}

}
