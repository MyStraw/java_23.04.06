package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _20920_영단어암기는괴로워1 {
	static class Word implements Comparable<Word> {
		String word;
		int count;
		int length;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
			this.length = word.length();
		}

		@Override
		public int compareTo(Word o) {
			if (this.count != o.count)
				return o.count - this.count;
			if (this.length != o.length)
				return o.length - this.length;
			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Word> wordMap = new HashMap<>();
		List<Word> words = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.length() >= M) {
				Word word = wordMap.getOrDefault(input, new Word(input, 0));
				word.count++;
				wordMap.put(input, word);
			}
		}

		words.addAll(wordMap.values());
		Collections.sort(words);

		for (Word word : words) {
			System.out.println(word.word);
		}
	}
}
