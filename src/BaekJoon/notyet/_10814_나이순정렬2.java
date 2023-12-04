package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _10814_나이순정렬2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		List<Person> people = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Person person = new Person(age, name, i);
			people.add(person);
		}

		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int ageCompare = Integer.compare(p1.getAge(), p2.getAge());
				if (ageCompare == 0) {
					return Integer.compare(p1.getNum(), p2.getNum());
				}
				return ageCompare;
			}
		});
		
		for (Person pp : people) {
			bw.write(String.valueOf(pp+"\n"));		
		}
		bw.flush();
		bw.close();
		
	
	}

	static class Person {
		int age;
		String name;
		int num;

		public Person(int age, String name, int num) {
			this.age = age;
			this.name = name;
			this.num = num;

		}
		
		public Person() {
			
		}
		

		public int getAge() {
			return this.age;
		}

		public String getName() {
			return this.name;
		}

		public int getNum() {
			return this.num;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}
}
