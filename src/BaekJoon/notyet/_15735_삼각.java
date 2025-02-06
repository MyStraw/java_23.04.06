package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15735_삼각 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10001];
        for (int i = 1; i < 10001; i++) {
            arr[i] = arr[i - 1] + i;
        }

		int n = Integer.parseInt(br.readLine()); 
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            ans += arr[i];
        }

        for (int i = n - 1; i > 0; i -= 2) {
            ans += arr[i]; 
        }

        System.out.println(ans); 
    }

}
