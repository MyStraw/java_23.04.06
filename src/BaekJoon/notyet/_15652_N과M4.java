package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652_N과M4 {

    static int N, M;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M]; // 수열을 저장할 배열

        backtrack(0, 1);
    }

    static void backtrack(int count, int start) {
        if (count == M) { // M개를 모두 선택했으면 출력
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) { // start부터 N까지 숫자 중 선택
            sequence[count] = i; // 수열에 숫자 추가
            backtrack(count + 1, i); // 다음 숫자 선택을 위해 재귀 호출, 이번에 선택한 i 이상만 고려
        }
    }

}
