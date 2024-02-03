package BaekJoon.notyet;

import java.util.Scanner;

public class _4999_아 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

     
        String jaehwan = sc.nextLine();
     
        String doctor = sc.nextLine();

        // 결과 출력
        if (jaehwan.length() >= doctor.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
		
	}

}
