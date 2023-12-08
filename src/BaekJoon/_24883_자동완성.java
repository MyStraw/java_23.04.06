package BaekJoon;

import java.util.Scanner;

public class _24883_자동완성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String al = sc.next();
		
		if (al.equals("N") || al.equals("n")) {
			System.out.println("Naver D2");
		}
		else
			System.out.println("Naver Whale");
	}

}
