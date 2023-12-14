package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _1764_듣보잡 { // getOrDefault 쓰는법이랑 map을 for로 돌때 Entry로 도는것!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> noListenSee = new HashMap<>();

		for (int i = 0; i < N; i++) {
			noListenSee.put(br.readLine(), 1);
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			noListenSee.put(name, noListenSee.getOrDefault(name, 0) + 1);
		}
		
		List<String> nonono = new LinkedList<>();
		for (Map.Entry<String, Integer> entry : noListenSee.entrySet()) {
			if(entry.getValue() >=2) {
				nonono.add(entry.getKey());
			}
			
		}
		Collections.sort(nonono);
		
		bw.write(nonono.size()+"\n");
	
		
		for (String no : nonono) {
			bw.write(no);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();

	}


}
