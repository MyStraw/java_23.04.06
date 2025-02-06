package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F번_나는씹덕이아니야 {
	 static int[] tree;
	    static int[] watchCount;
	    static boolean[] isWellKnown;
	    static int C, M;

	    static void update(int idx, int delta) {
	        while (idx < tree.length) {
	            tree[idx] += delta;
	            idx += idx & -idx;
	        }
	    }

	    static int query(int idx) {
	        int total = 0;
	        while (idx > 0) {
	            total += tree[idx];
	            idx -= idx & -idx;
	        }
	        return total;
	    }

	    static int rangeQuery(int left, int right) {
	        return query(right) - query(left - 1);
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        int K = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());
	        int Q = Integer.parseInt(st.nextToken());

	        tree = new int[M + 1];
	        watchCount = new int[M + 1];
	        isWellKnown = new boolean[M + 1];

	        int wellKnownCount = 0;
	        int[] result = new int[N];

	        List<int[]>[] records = new ArrayList[N + 1];
	        for (int i = 0; i <= N; i++) {
	            records[i] = new ArrayList<>();
	        }

	        for (int i = 0; i < Q; i++) {
	            st = new StringTokenizer(br.readLine());
	            int D = Integer.parseInt(st.nextToken());
	            int P = Integer.parseInt(st.nextToken());
	            int L = Integer.parseInt(st.nextToken());
	            int R = Integer.parseInt(st.nextToken());
	            records[D].add(new int[]{L, R});
	        }

	        for (int day = 1; day <= N; day++) {
	            for (int[] record : records[day]) {
	                int L = record[0];
	                int R = record[1];
	                update(L, 1);
	                if (R + 1 <= M) {
	                    update(R + 1, -1);
	                }
	            }

	            for (int anime = 1; anime <= M; anime++) {
	                if (isWellKnown[anime]) continue;
	                watchCount[anime] = rangeQuery(anime, anime);
	                if (watchCount[anime] >= C) {
	                    isWellKnown[anime] = true;
						wellKnownCount++;
					}
	            }

	            result[day - 1] = wellKnownCount;
	        }

	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        for (int i = 0; i < N; i++) {
	            bw.write(result[i] + "\n");
	        }
	        bw.flush();
	        bw.close();
	    }

}
