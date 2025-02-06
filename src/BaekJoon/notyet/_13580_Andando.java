package BaekJoon.notyet;

import java.util.Scanner;

public class _13580_Andando {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);	        
	      
	        int A = sc.nextInt();
	        int B = sc.nextInt();
	        int C = sc.nextInt();	        
	     
	        if (future(A, B, C)) {
	            System.out.println("S");
	        } else {
	            System.out.println("N");
	        }	        
	 
	    }
	    
	    private static boolean future(int A, int B, int C) {
	     
	        int[] combi = {	                               
	            A, -A,               
	            B, -B,               
	            C, -C,               
	            A + B, A - B, -A + B, -A - B, 
	            A + C, A - C, -A + C, -A - C, 
	            B + C, B - C, -B + C, -B - C, 
	            A + B + C, A + B - C, A - B + C, A - B - C,
	            -A + B + C, -A + B - C, -A - B + C, -A - B - C
	        };
	        
	      
	        for (int sum : combi) {
	            if (sum == 0) {
	                return true;
	            }
	        }
	        
	        return false;
	    }

}
