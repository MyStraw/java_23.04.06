package BaekJoon.notyet;
import java.util.Scanner;

public class _30224_Lucky7 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		String N = String.valueOf(n);
		boolean contain = N.contains("7");		
		if(n%7 !=0 && !contain) {
			System.out.println(0);
		}
		else if(n%7 == 0 && !contain) {
			System.out.println(1);
		}
		
		else if(n%7 != 0 && contain) {
			System.out.println(2);
		}
		else if(n%7 == 0 && contain) {
			System.out.println(3);
		}
	}

}
