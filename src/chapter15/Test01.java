package chapter15;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Test01 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(50);
		myList.add(10);
		myList.add(80);
		Stream<Integer> myStream = myList.stream();
		
		myStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		
		Optional<Integer> minVal =myList.stream().min(Integer::compare);
		System.out.println("최저 점수 : " + minVal.get());
		
		Optional<Integer> maxVal =myList.stream().max(Integer::compare);
		System.out.println("최고 점수 : " + maxVal.get());
		
		System.out.println("점수 정렬 : ");
		Stream<Integer> myStream2 = myList.stream().sorted();
		myStream2.forEach((n) -> System.out.println(n + " "));
		System.out.println();
	}

}
