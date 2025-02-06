package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _29336_월향비상 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int[][] conditions = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            conditions[i][0] = Integer.parseInt(st.nextToken());
            conditions[i][1] = Integer.parseInt(st.nextToken());
        }

        long currentQuality = 0;
        boolean possible = true;
        for (int i = 0; i < m; i++) {
            int day = conditions[i][0];
            int requiredQuality = conditions[i][1];

            while (!pq.isEmpty() && currentQuality < requiredQuality) {
                int topQuality = pq.poll();
                currentQuality += topQuality + day;
            }

            if (currentQuality < requiredQuality) {
                possible = false;
                break;
            }
        }

        while (!pq.isEmpty()) {
            currentQuality += pq.poll() + conditions[m - 1][0];
        }

        if (possible && currentQuality >= conditions[m - 1][1]) {
            System.out.println(currentQuality);
        } else {
            System.out.println(-1);
        }
    }
}
