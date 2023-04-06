package chapter5;

//import com.ruby.java.test2.*; // 이 패키지 없으니 주석해놓을겡
import java.util.List; // 임포트 대상 적혀있으면 제일 뒤에 글자는 클래스를 나타냄.(List)
import java.io.*; // *는 all을 의미한다. io라는 패키지 안에있는 모든(*) 클래스를 들여와라. 실제론 다 안들여온다.
//이클립스에서 노란색줄 = 사용되고 있지 않다. ctrl + shift + o 누르면 알아서 없애준다. 노란줄 다 없어지니 주의.

public class Armor {

	private String name;
	private int height; // 정의안되면 primitive는 null로 들어간다. 0이 아닌.
	private int weight;
	private String color;
	private boolean isFly;

	public void setName() { // void 눈 없을 무. 돌려줄게 없다!
		String value = "mark6";
		name = value;

	}

	// String getName이니 String을 돌려준다.
	public String getName() { // 저장되어 있는 값을 가져오는것. privite 속성이면 사용돼? ㅇㅇ 자기가 자기꺼 쓰는거니 사용가능하지.
		// return name; // 리턴 = 현재 이 메소드를 끝을내고 돌아가라.

		if (name == null)
			return "NO Name";

		return name;

		// name = "a"; // 리턴 만나니 돌아가니까 이건 실행이 안됨.
	}

//	public void setHeight(int value) {
//		height = value;
}
