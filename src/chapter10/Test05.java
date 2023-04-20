package chapter10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test05 {

	public static void print(int n, LinkedList<String> list) {
		System.out.println();
		System.out.println(n + " : " + list); // list.toString()해도 동일.
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

		list.add("서울");
		list.add("부산");
		list.add("제주");
		list.add(0, "LA");

		for (String sx : list) {
			System.out.print(" " + sx);
		}

		// Test05 t = new Test05();
		print(1, list); // static 하면 t. 해줄필요 없넹

		List<String> list2 = Arrays.asList("북경", "상해"); //496p, 51line
		list.addAll(list2);
		print(2, list);
		
		Object  obj[] = list.toArray();// 배열을 만들어줘~ 어떤값도 다 만들수있오~
		System.out.println("배열 출력 : " + Arrays.toString(obj));

	}

}
