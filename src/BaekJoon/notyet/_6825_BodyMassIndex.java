package BaekJoon.notyet;

import java.util.Scanner;

public class _6825_BodyMassIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double weight = sc.nextDouble();
		double height = sc.nextDouble();

		double BMI = weight / (height * height);
		
		if(BMI >= 25) {
			System.out.println("Overweight");
		}
		else if (BMI>18.5) {
			System.out.println("Normal weight");
		}
		else {
			System.out.println("Underweight");
		}
		

	}

}
