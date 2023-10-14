package BaekJoon.notyet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _8545_Zadanie_probne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String abc = sc.next();
		
		char [] zadanie = abc.toCharArray();
		
		Arrays.sort(zadanie,new Comparator<Integer>() {
			public char compare (char a, char b) {
				return b - a;
			}
		}
	}

}
