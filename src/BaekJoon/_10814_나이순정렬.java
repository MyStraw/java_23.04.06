package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10814_나이순정렬 { //모자란 코드

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		

		int N = Integer.parseInt(br.readLine());
		
		//클래스에 저장을 하는게 아니라, 담아두는건 리스트나 배열에 담아두는데
		//그때 변수명으로 클래스를 쓴다. 클래스에서 변수를 정의해주는것
		//person이라는 변수에 age와 name이 같이 저장된다. 이렇게 한 세트로 [0]번에 저장되는것

	

		for (int i = 0; i < N; i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Person person = new Person();			
			person.setAge(age);
			person.setName(name);
		}

	}

	static class Person {
		int age;
		String name;

		public Person() {

		}

		public int getAge() {
			return this.age;
		}

		public void setAge(int age) { //이렇게 세터를 쓰는게 아니다.
			this.age = age;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private static void swap(int[] su, int i, int j) {
		int temp = su[i];
		su[i] = su[j];
		su[j] = temp;
	}

}
