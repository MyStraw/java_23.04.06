package BaekJoon.notyet;

import java.util.Scanner;

public class _2083_럭비클럽 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String name = sc.next();
			int age = sc.nextInt(); 
			int weight = sc.nextInt(); 
			String classific;
			
			if (name.equals("#") && age == 0 && weight == 0) {
				break; 
			}
			
			if (age > 17 || weight >=80) {
				classific = "Senior";
			}
			else {
				classific = "Junior";
			}
			
			System.out.println(name + " " + classific);
		}
		
	}

}
