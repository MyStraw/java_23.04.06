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

public class _20920_영단어암기는괴로워2 {
	static class Word implements Comparable<Word> {
		String word;
		int count;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}

		@Override
		public int compareTo(Word o) {
			// 빈도수 내림차순
			if (this.count != o.count) {
				return o.count - this.count;
			}
			// 길이 내림차순
			if (this.word.length() != o.word.length()) {
				return o.word.length() - this.word.length();
			}
			// 알파벳 오름차순
			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int M = Integer.parseInt(firstLine[1]);

		Map<String, Integer> wordCount = new HashMap<>();
		List<Word> words = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() >= M) {
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			words.add(new Word(entry.getKey(), entry.getValue()));
		}

		Collections.sort(words);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Word word : words) {
			bw.write(word.word + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}