package BaekJoon.notyet;

import java.util.Scanner;

public class _14928_큰수_BIG2 {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        long temp = 0;
        for (int i = 0; i < input.length(); i++) {
            temp = (temp * 10 + (input.charAt(i) - '0')) % 20000303;
        }
        
        System.out.println(temp);
    }

}
