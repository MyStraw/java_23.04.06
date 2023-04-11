package chapter7;

public class Employee extends Person {

	private String dept; //여기도 dept
//
	
	
	
	public Employee() {
		System.out.println("Employee 생성자가 호출되었습니다.");
		// 얘는 딱 한번만 호출된다. 이거 주석달면 LMSTest2에서 에러난다.
		//에러에서 크리에이트 기본생성자 추가하시겠냐는거 클릭하면 아래 자동으로
		//생성해준다.		}
	
	}

	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;		
		
		
		
		
		
		
//		setName(name);//this.name=name; //부모 프라이빗이라 접근 안돼
//		setAge(age);
//		this.dept=dept;
	}
	
	
//	public Employee() { crtl space enter:기본생성자
//		// TODO Auto-generated constructor stub
//	}


	public String getDept() {
		return dept;
	}

	public void setDept(String dept) { //여기도 dept 변수. 내가가진 dept를 위의 dept로.
		this.dept = dept; //이거 쓰는게 관례다. //변수가 둘다 똑같은 이름 dept네?
		
//	public void setDept(String dep)	//이것도 똑같다
//		(this.)dept = dep; //this 있어도 되고 없어도 되공.
	}

	@Override // 덮어쓰네? 원래 펄슨에서 네임이랑 에이지만 받아올수 있는데; 메이저 못받으니 재수정 해서 toString 할수있도록. 이게 오버라이딩.
	public String toString() {
		return "Employee [name= " + getName() + ", age= " + getAge() + ", dept=" + dept + "]";
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