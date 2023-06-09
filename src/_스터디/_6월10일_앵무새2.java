package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _6월10일_앵무새2 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //앵무새 마리수
		List<Queue<String>> listOfque = new ArrayList<>(); //앵무새큐들을 담아둘 리스트
		Queue<String> result = new LinkedList<>(); //최종 말 조합을 담을 리스트
		int count = 0;
		int count2 = 0;

		for (int i = 0; i < N; i++) { //앵무새 말 담기
			String S = br.readLine();
			Queue<String> que = new LinkedList<>();
			for (String s : S.split(" ")) {
				que.add(s);
			}
			listOfque.add(que);
		}

		String sum = br.readLine(); //최종 말을 단어로 쪼개서 큐에 담기
		for (String s : sum.split(" ")) {
			result.add(s);
		}

		while (!result.isEmpty()) { //최종 말이 다 비어야 possible 이겠지?
			if (count2 > count) { // while을 한번 돌때 최소 result에서 한글자씩은 빠져 나가야 하는데, 그렇지 않으면 앵무새 첫말에 빠져나갈게 없단거.
								//impossible 이겠지? 이거 없으면 무한루프. count2는 count 보다 절대 클수가없다
				break;
			}
			for (int i = 0; i < N; i++) {
				if (listOfque.get(i).isEmpty()) { //앵무새 마리수(i)를 각 돌면서 empty이면(먼저 말 다 뱉은 앵무새 처리) continue를 한다. 이거 안해주면 에러.
					continue;
				}
				if (listOfque.get(i).peek().equals(result.peek())) { //앵무새의 peek과 result의 peek 값을 비교해서 같으면
					listOfque.get(i).poll(); 
					result.poll(); //둘다 앞머리씩 단어 날리고 count를 1개씩 센다. 단어 날릴때마다 count를 센다.
					count++;
					if (listOfque.get(i).isEmpty()) { //반례. 2 a b a impossible
						listOfque.remove(i); //반례때문에 말 다 한 앵무새는 삭제해주고 마릿수 제외한다. 이거 없으면 i want 이것도 impossible 뜬다.
						N = N - 1; // [[],[],[]] 이거를 empty라고 안하더라.
					}
				}
			}
			count2++;
		}

		if (result.isEmpty() && listOfque.isEmpty()) { 
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
	}
}
