package chapter7;

public class Person {
	
	private String name;
	private int age;
	
	public Person() { //펄슨 생성자 생성. 없어도 컴파일이 알아서.
		System.out.println("Person 생성자가 호출되었습니다.");
		//부모 생성자는 기본으로 생성된다.
		//디버깅 하거나 프린트로 찍어내면서 보면 공부잘된다.
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age; //생성자 추가해서 만들지 아닐지 자기가 결정.
	}
			
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() { //퍼블릭이니 누구나 호출가능
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(20);
		p.setName("홍길동");
		
		System.out.println();
		
	}
}

//여기에 정의돼있는 스트링을 자식들이 받아서 다시 재작성.
//디스는 자기자신.