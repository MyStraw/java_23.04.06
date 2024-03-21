package BaekJoon.notyet;

import java.util.Scanner;

public class _29163_Mr_bin {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number % 2 == 0) {
            	count++;
            }
        }

        if (count > n - count) {
            System.out.println("Happy");
        } else {
            System.out.println("Sad");
        }
    }

}
