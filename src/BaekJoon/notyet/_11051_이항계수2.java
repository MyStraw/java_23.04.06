package BaekJoon.notyet;

import java.util.Scanner;

public class _11051_이항계수2 {  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        System.out.println(eHang(N, K));
    }    
  
    static int eHang(int N, int K) {
        int ja = factorial(N);
        int mo = (factorial(K) * factorial(N - K)) % 10007;      
        return ja * power(mo, 10007 - 2) % 10007;
    }    

    static int factorial(int N) {
        int result = 1;
        for (int i = 2; i <= N; i++) {
            result = (result * i) % 10007;
        }
        return result;
    }    
  
    static int power(int base, int exponent) {
        if (exponent == 0) return 1;
        int half = power(base, exponent / 2);
        int temp = (half * half) % 10007;
        if (exponent % 2 == 0) return temp;
        else return (temp * base) % 10007;
    }

}
