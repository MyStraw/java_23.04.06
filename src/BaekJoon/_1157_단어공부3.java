package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1157_단어공부3 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();

		Map<String, Integer> moonjang = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			String dan = s.substring(i, i + 1); // 문장에서 글자1개씩 뽑아오기
			moonjang.put(dan, moonjang.getOrDefault(dan, 0) + 1);
			// 키가 존재하지 않으면 디폴트(0)을 반환
			// dan이 키. 문자에 해당. 키에 해당하는 값은 숫자.
			// dan 문자에 해당하는 숫자(카운트)를 가져온다. dan문자가 없으면 0을 반환한다
			// dan 문자에 대응하는 값에 1을 더한다. dan 문자가 없으면 문자를 추가해 넣고 0 +1 = 1이 되겠지
		}

		int max = 0;
		String maxDan ="";
		boolean joongbok = false;

		//Map.Entry는 Map 인터페이스의 내부 인터페이스. Map의 각 요소(키, 값)을 나타낸다.
		//getKey():엔트리의 키를 반환한다. getValue(): Entry의 값을 반환
		//setValue(V value) : Entry의 값을 설정한다.
		
		//Map 만으로는 get(key)만 가능하다. 이건 특정 키를 알고있을대 그 값을 가져오는것.
		//즉 moonjang.get(entry.getKey()) = entry.getValue();
		for (Map.Entry<String, Integer> entry : moonjang.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				maxDan = entry.getKey();
				joongbok = false;
			}
			else if(entry.getValue() == max) {
				joongbok = true;
			}
		}		

		if (joongbok) {
			System.out.println("?");
		} else {
			System.out.println(maxDan);
		}

	}
}
