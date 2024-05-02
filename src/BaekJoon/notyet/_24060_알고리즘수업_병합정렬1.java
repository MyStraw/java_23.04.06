package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24060_알고리즘수업_병합정렬1 {
    static int K; // K번째 저장 횟수
    static int count = 0; // 저장 횟수 카운터
    static int result = -1; // K번째 저장된 요소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(A, 0, N - 1); // 병합 정렬 수행

        System.out.println(result); // 결과 출력 (K번째 저장된 요소)
    }

    // 병합 정렬
    static void merge_sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // 중간 지점 계산
            merge_sort(A, p, q); // 전반부 정렬
            merge_sort(A, q + 1, r); // 후반부 정렬
            merge(A, p, q, r); // 병합
        }
    }

    // 병합 과정
    static void merge(int[] A, int p, int q, int r) {
        int[] tmp = new int[r - p + 1]; // 임시 배열
        int i = p, j = q + 1, t = 0;

        // A[p..q]와 A[q+1..r] 병합
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t] = A[i];
                count++; // 저장 횟수 증가
                if (count == K) {
                    result = A[i]; // K번째 저장된 요소
                }
                t++;
                i++;
            } else {
                tmp[t] = A[j];
                count++; // 저장 횟수 증가
                if (count == K) {
                    result = A[j]; // K번째 저장된 요소
                }
                t++;
                j++;
            }
        }

        // 남은 요소 병합
        while (i <= q) {
            tmp[t] = A[i];
            count++; // 저장 횟수 증가
            if (count == K) {
                result = A[i]; // K번째 저장된 요소
            }
            t++;
            i++;
        }

        while (j <= r) {
            tmp[t] = A[j];
            count++; // 저장 횟수 증가
            if (count == K) {
                result = A[j]; // K번째 저장된 요소
            }
            t++;
            j++;
        }

        // 결과를 A[p..r]에 저장
        for (int k = 0; k < tmp.length; k++) {
            A[p + k] = tmp[k];
        }
    }

}
