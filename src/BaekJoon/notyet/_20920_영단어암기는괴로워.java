package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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
public class _20920_영단어암기는괴로워 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<World, Integer> map = new HashMap<>();

		World eng [] = new World[N];		
		
		World world = null;

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			world = new World(word, i, map.getOrDefault(word, 0) + 1);
			if (word.length() >= M) {
				map.put(world, map.getOrDefault(word, 0) + 1);
			}
		}
	
		for (int i = 0; i < map.size(); i++) {
			if (world.index == i) {
				
			}
		}

		// 1. map의 값이 제일 큰것. 2.같을경우 word.length()가 긴것, 3.그다음 알파벳순
	}

	static class World implements Comparable<World> {
		int index;
		String word;
		int count;
		int length;

		World(String word, int i, int count) {
			this.index = i;
			this.word = word;
			this.count = count;
			this.length = word.length();
		}

		@Override //이건 제법 잘 짰다. 위의 판단 기준 1,2,3에 부합한다.
		public int compareTo(World o) {
			int countCom = o.count - this.count;
			if (countCom == 0) {
				int lengthCom = o.length - this.length;
				if (lengthCom == 0) {
					return o.word.compareTo(this.word);
				}
				return lengthCom;
			}
			return countCom;
		}
	}
}
