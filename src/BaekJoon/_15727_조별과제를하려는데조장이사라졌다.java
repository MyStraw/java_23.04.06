package BaekJoon;

import java.util.Scanner;

public class _15727_조별과제를하려는데조장이사라졌다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double t = sc.nextInt();
		
		double result = t/5;
		
		System.out.println((int)Math.ceil(result));
		
	}

}
