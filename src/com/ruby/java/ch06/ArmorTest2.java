package com.ruby.java.ch06;
//227p
public class ArmorTest2 {
	public static void main(String[] args) {
		Armor suit = new Armor();
		System.out.println(suit.getName());
		suit = null;
		suit.setName("mark6");
		suit.setHeight(180);
		System.out.println(suit.getName() + " : " + suit.getHeight());
	}
}

//에러메세지
//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.ruby.java.ch06.Armor.setName(String)" because "suit" is null
// at com.ruby.java.ch06.ArmorTest2.main(ArmorTest2.java:8)

//참조변수가 null. ArmorTest2의 8번째 라인 부분이 문제.
//null.setName() 하니까 null은 가리키는게 없는데?
//윗줄 null pointer 예외. 부를라 하는데 없으니 에러. 가장 빈번한 오류다.