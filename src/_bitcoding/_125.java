package _bitcoding;

import java.util.Scanner;

public class _125 {

	public static void main(String[] args) {
		
		System.out.println("년도를 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();		
		
		
		if (year % 4 == 0) {
			System.out.println("윤년입니다");
		}
			
		else if (year % 100 ==0){
			System.out.println("평년.");						
		}
		
		else if (year % 400 == 0) {
			System.out.println("윤년입니다");
		}						
			
		}

}


