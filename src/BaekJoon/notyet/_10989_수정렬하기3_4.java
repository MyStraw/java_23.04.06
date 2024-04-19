package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _10989_수정렬하기3_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];
        
        for (int i = 0; i < N; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }
        
        br.close();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    sb.append(i).append('\n');
                }
            }
        }
        
        System.out.print(sb);
    }
}
