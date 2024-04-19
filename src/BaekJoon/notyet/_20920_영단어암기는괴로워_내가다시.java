package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//map으로 getOrDefault를 써서 키에 word, 값에 빈도수를 넣어서 같은 word가 오면 put 하지않고 빈도수만 올린다.
//그런데 map은 index가 없으니, 내부를 하나하나 돌며 확인을 못하니 객체를 만들어서 그 안에 index를 부여해서 리스트 처럼 써보자!
// 그래서 하는김에 index, word, 길이 이렇게 조건을 걸고 Comparable로 아예 정렬을 해놓자!! 했는데

//문제는 이렇게 하면 키로 word가 아닌 객체가 들어와야 하는데, 객체가 들어오게 되면 같은게 들어갈수가 없다.
//매번 new를 하여 객체를 생성할텐데, 또한 index가 달라지는데 이걸 같은 키로 인식시킬수가 없어졌다.

//그렇다고 키를 word로만 하고 값을 객체로 해서 값의 count와 index만 넣으면 되지않나? 싶지만
//map에서는 get으로 키를 얻을순 있지만, 값을 찾을순 없다. 키로 값을 접근하는게 맵이기 때문

//여기서 막혀서 2번과 3번으로 갔다.

//야야!! index 필요없다!! 요소 하나하나 돌수있는 Map.Entry가 있다! for each와 같은거다!
//근데 정렬을 할라니까 Map은 정렬이 안되잖아. 어차피 이러면 또 class를 만들어서 객체타입으로 해야하는건데
//그럴바엔 List이지만 방금만든 Map을 타입으로 만들어보자.
//근데 이렇게 요소를 다 넣을거면, stream()이 있지 않나? stream을 쓰면 되겠네!!


public class _20920_영단어암기는괴로워_내가다시 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<Map.Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
		// 리스트에 맵의 모든걸 Entry로 for ecch 구문으로 돌면서 map.entrySet으로 키와 밸류를 다 넣는다

		Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o2.getValue() - o1.getValue() == 0) {
					if (o2.getKey().length() - o1.getKey().length() == 0) {
						return o1.getKey().compareTo(o2.getKey());
					}
					return o2.getKey().length() - o1.getKey().length();
				}
				return o2.getValue() - o1.getValue();

			}
		});

		for (int i = 0; i < mapList.size(); i++) {
			if (mapList.get(i).getKey().length() >= M) {
				bw.write(mapList.get(i).getKey());
				bw.newLine();

			}
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
