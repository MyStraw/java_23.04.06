package chapter7;

public class Student extends Person {
	private String major;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age, String major) {
		super(name,age);		
		this.major = major;
		System.out.println("Student(name, age, major) 생성자 실행!");
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override // 덮어쓰네? 원래 펄슨에서 네임이랑 에이지만 받아올수 있는데; 메이저 못받으니 재수정 해서 toString 할수있도록. 이게 오버라이딩.
	public String toString() {
		return "Student [name= " + getName() + ", age= " + getAge() + ", major=" + major + "]";
	}
}

//name이랑 age 부모에게 다 상속을 받았는데 못읽고있다.
//person이 private로 되어있다. public 하거나 아예 지워
//그럼 default(같은 패키지 내 다 가능)
//기본원칙. 자바 클래스 내에;서 private만 쓴다.

//private 속성인데 가져오기 위한 메쏘드가 게터, 세터
//부모의 겟네임 호출 해주면 된다. 부모의 겟네임은 public

//부모 클래스 호출했을때 toString으로. 어떤 구조로 호출이 되는지 이해!
//부모클래스에서 메소드 만들었는데 상속 못하도록 하고싶으면? private 앞에 넣으면 부모 지만 쓸수있다.
//퍼블릭은 거의 안쓴다. private만 쓴다고생각!
//메소드는 프라이빗, 퍼블릭 다 쓴다.