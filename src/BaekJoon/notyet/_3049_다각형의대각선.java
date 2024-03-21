package BaekJoon.notyet;

import java.util.Scanner;

public class _3049_다각형의대각선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        long cross = combination(N, 4);
       
        System.out.println(cross);
    }

    public static long combination(int n, int k) {
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;    
	}
}