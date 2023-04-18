package chapter10;

import java.util.ArrayList;
import java.util.Arrays;

class Employee {
	String name;
	int age;
	int height;
	int weight;
	char bloodType;
	String email;

	public Employee(String name, int age, int height, int weight, char bloodType, String email) { // 생성자
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.email = email;
	}

	public String toString() {// 출력형식 폼
		return name + ", " + age + ", " + height + ", " + weight + ", " + bloodType + ", " + email;
	}
}

class Student {
	int sid;
	String name;
}

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); // 여기 보라색이 제네릭 리스트. int가들어가면 int.

		list.add("서울");
		list.add("부산");
		list.add("창원");
		list.add("서울");
		list.add("울산");
		list.add("밀양");
//		for (int i = 0; i < list.size(); i++)
//			System.out.print(" " + list.get(i).toString());
		System.out.println(list.toString());
		list.add(0, "인천"); // 0번째에 인천을 끼운다.
		list.remove(1);// 인덱스 1번(서울) 지운다.
		System.out.println("\n인천 삽입후::");
//		for (int i = 0; i < list.size(); i++)
//			System.out.print(" " + list.get(i).toString());
//		System.out.println();
		System.out.println(list.toString()); // 실행하니까 배열 쭉 보여준다.
		Object obj[] = list.toArray();// 471p 27line//리스트를 배열로 만들고
		System.out.println("8:: " + Arrays.toString(obj));//배열을 출력.
		

//		ArrayList<Student> list = new ArrayList<>(); //여기 보라색이 제네릭 리스트. 뒤 보라는 생략가능. 467p
		// <Student>를 없애면 무슨 타입이든지 다 들어갈수가 있게된다.

		Object arr[] = new Object[10]; // 이건 배열~
		ArrayList lst = new ArrayList();
		String s = "java";
		Integer i = 123;
		arr[0] = s;
		arr[1] = i;
		int m = arr.length;
		int l = s.length();
//	int len = arr[0].length();// arr[0]이 스트링이야. 이것만왜 에러? 467p. [0]뒤에 . 찍어보면 length없다. 부모에 없다.
		lst.add(s);
		lst.add(i);
		int h = ((String) lst.get(0)).length();// 타입변환
//	int []data = new int [10];//이런 예들은 에러 안나는디
//	int k = data.length;
	}

//		int[] a = new int[10];
//		Employee[] eset = new Employee[10];
//		eset[0] = new Employee("hong", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[1] = new Employee("kim", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[2] = new Employee("lee", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[3] = new Employee("park", 11, 130, 50, 'A', "bhhong@go.kr");
//		eset[4] = eset[3];
//		eset[3] = eset[2]; //이런과정을 해줘야중간에 끼어든다. 근데 이러면 노가다고 이런코딩 하믄 안돼. 배열을 해야된다.
//		eset[2] = new Employee("choi", 11, 130, 50, 'A', "bhhong@go.kr"); // 이러면 기존의 2가 날라가.
//		for (int i = 0; i < 4; i++) {
//			System.out.println(eset[i].toString());
//		}
//		eset[4] = new Employee("choi", 11, 130, 50, 'A', "bhhong@go.kr"); // 이걸2번째에 넣고싶다~ 위에 2 넣으면 기존이날라가.
// 	}
} //깃허브 다시 덮어쓰기
