package BaekJoon.notyet;

import java.util.Scanner;

public class _1212_8진수2진수2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);       
     
        String octopus = sc.nextLine();
        StringBuilder bicycle = new StringBuilder();
        String[] octTobi = {"000", "001", "010", "011", "100", "101", "110", "111"};
   
        bicycle.append(octTobi[octopus.charAt(0) - '0'].replaceFirst("^0+(?!$)", ""));       
      
        for (int i = 1; i < octopus.length(); i++) {
            bicycle.append(octTobi[octopus.charAt(i) - '0']);
        }
   
        System.out.println(bicycle.toString());
	}
}
