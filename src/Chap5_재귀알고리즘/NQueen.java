package Chap5_재귀알고리즘;

import java.util.Scanner;

public class NQueen {
    static int N;
    static int[] cols;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cols = new int[N+1];
        queens(1);
        sc.close();
    }
    
    public static boolean promising(int level) {
        for (int i=1; i<level; i++) {
            if (cols[i] == cols[level]) {
                return false;
            }
            else if (level-i == Math.abs(cols[level]-cols[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void queens(int level) {
        if (!promising(level)) {
            return;
        }
        else if (level == N) {
            for (int i=1; i<=N; i++) {
                System.out.print(cols[i] + " ");
            }
            System.out.println();
        }
        else {
            for (int i=1; i<=N; i++) {
                cols[level+1] = i;
                queens(level+1);
            }
        }
    }
}