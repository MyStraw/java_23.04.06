package BaekJoon.notyet;

import java.util.Scanner;

public class _18409_모음 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);	       
	        int N = Integer.parseInt(sc.nextLine());	       
	        String s = sc.nextLine();	      
	        System.out.println(count(s));
	    }
	 
	    private static int count(String s) {
	        int count = 0;
	        for (char c : s.toCharArray()) {
	            if (moem(c)) {
	                count++;
	            }
	        }
	        return count;
	    }
	   
	    private static boolean moem(char c) {
	        return "aeiou".indexOf(c) >= 0;
	    }

}
