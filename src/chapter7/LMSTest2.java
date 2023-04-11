package chapter7;

public class LMSTest2 {
	public static void main(String[] args) {
		
		Employee e = new Employee();//익스텐드로 연결돼있기 때문에 가능. 클변 뉴클리어
		System.out.println(e);
		
		//null, 0, null으로 찍힌다. 아무것도 입력 안하면
		
		Employee e1 =new Employee("오정임", 47, "입학처");
		System.out.println(e1);
		Professor p = new Professor("김푸름", 52, "빅데이터");
		Student s = new Student("김유빈", 20, "컴퓨터 과학");
		
		System.out.println(e); //오버라이딩 해줬으니 toString 정의한대로 나온다. toString안적어도 자바 버전에 따라 알아서 해준다.
		System.out.println(p.toString());
		System.out.println(s.toString());
		
	}

}
//실행 하니까 과목 같은게 안나오고 이름, 나이만 나오네. 이게 정상~
//이제; 왔다갔다해. 임플로이에는 toString이 없음에도 이름하고 나이 찍어줬네.
//이 메소드는 person에서 상속을 받아서 그걸쓴다. 부모클래스에 toString이 정의되어있다. 정의가 이름과 나이만 있네
//이게 이름과 나이만 찍게 되어있다. 계속 상속상속 받아서 display 하는걸 10분 쉬었다가 합시다.부모에게서 받아온걸 다시 재조립해 쓸수있다.

//부가적 정보도 나오도록 수정해보자. 임플로이로 가. generate toString 임플로이 안에있는 toString만 호출하네
//자기꺼 있으니 부모꺼 호출 안해.

//부모 생성자 먼저
//그다음 자식 생성자
//그리고 toString
