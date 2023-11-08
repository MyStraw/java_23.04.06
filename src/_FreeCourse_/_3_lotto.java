package _FreeCourse_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	// TODO: 추가 기능 구현
}

public class _3_lotto {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rnd = new Random();

		System.out.println("구입금액을 입력해 주세요.");

		int howMuchPurchase = Integer.parseInt(br.readLine());
		int howManyLotto = howMuchPurchase / 1000;

		List<Lotto> lottoTickets = new ArrayList<>();

		for (int i = 0; i < howManyLotto; i++) {
			Set<Integer> numbers = new HashSet<>();
			while (numbers.size() < 6) {
				int number = rnd.nextInt(45) + 1;
				numbers.add(number);
			}

			List<Integer> lottoList = new ArrayList<>(numbers);
			Lotto lotto = new Lotto(lottoList);
			lottoTickets.add(lotto);

		}
		for (Lotto lotto : lottoTickets) {
			System.out.println(lotto.getNumbers());
		}

	}
}