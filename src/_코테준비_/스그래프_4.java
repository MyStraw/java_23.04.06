package _코테준비_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 스그래프_4 {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord))
			return 0;
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();
				if (currentWord.equals(endWord))
					return level;
				for (int j = 0; j < currentWord.length(); j++) {
					char[] wordChars = currentWord.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						wordChars[j] = ch;
						String newWord = String.valueOf(wordChars);
						if (wordSet.contains(newWord) && !newWord.equals(currentWord)) {
							queue.offer(newWord);
							wordSet.remove(newWord);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String beginWord = scanner.nextLine();
		String endWord = scanner.nextLine();
		String[] wordListArray = scanner.nextLine().split(" ");
		List<String> wordList = Arrays.asList(wordListArray);
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

}
