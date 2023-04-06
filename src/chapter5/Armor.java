package chapter5;

//import com.ruby.java.test2.*; // 이 패키지 없으니 주석해놓을겡
import java.util.List; // 임포트 대상 적혀있으면 제일 뒤에 글자는 클래스를 나타냄.(List)
import java.io.*; // *는 all을 의미한다. io라는 패키지 안에있는 모든(*) 클래스를 들여와라. 실제론 다 안들여온다.
//이클립스에서 노란색줄 = 사용되고 있지 않다. ctrl + shift + o 누르면 알아서 없애준다. 노란줄 다 없어지니 주의.

public class Armor {
		
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;

	public void setName() {
		String value = "mark6";
		name = value;
	}

	public void setHeight(int value) {
		height = value;
	}
}
