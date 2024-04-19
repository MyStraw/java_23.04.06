package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _20920_영단어암기는괴로워3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstLine = br.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int M = Integer.parseInt(firstLine[1]);

		Map<String, Integer> wordCount = new HashMap<>();
		List<String> words = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() >= M) { // 길이가 M 이상인 단어만 고려
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
				if (!words.contains(word)) {
					words.add(word); // 중복되지 않게 리스트에 추가
				}
			}
		}

		// 정렬 기준: 빈도수(desc), 길이(desc), 알파벳(asc)
		Collections.sort(words, (w1, w2) -> {
			int countCompare = wordCount.get(w2) - wordCount.get(w1);
			if (countCompare == 0) {
				int lengthCompare = w2.length() - w1.length();
				if (lengthCompare == 0) {
					return w1.compareTo(w2);
				}
				return lengthCompare;
			}
			return countCompare;
		});

//		Collections.sort(words, new Comparator<String>() {
//			@Override
//			public int compare(String w1, String w2) {
//				int countCompare = wordCount.get(w2) - wordCount.get(w1);
//				if (countCompare == 0) {
//					int lengthCompare = w2.length() - w1.length();
//					if (lengthCompare == 0) {
//						return w1.compareTo(w2);
//					}
//					return lengthCompare;
//				}
//				return countCompare;
//			}
//		});

		for (String word : words) {
			bw.write(word + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}