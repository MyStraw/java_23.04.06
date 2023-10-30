package _FreeCourse_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class _2_자동차경주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분");
		String carNames = br.readLine();

		// String[] carName = carNames.split(",");
		List<String> carNameList = Arrays.asList(carNames.split(","));
		// int n = carName.length;
		System.out.println("시도할 회수는 몇회인가요?");
		int movement = Integer.parseInt(br.readLine());

		List<ownCar> cars = new ArrayList<>();

		for (String name : carNameList) {
			cars.add(new ownCar(name));
		}
		
		System.out.println("실행 결과" + "\n");
		for (int i = 0; i < movement ; i++) {
			for (ownCar car : cars) {
				car.move();
				System.out.println(car.getName() + " : " + car.getMoveHyphen());
			}
			System.out.println();
		}
		int max = 0;
		for (ownCar car : cars) {
			if(car.getMove() > max) {
				max = car.getMove();
			}
		}
		
		List<String> winners = new ArrayList<String>();
		for (ownCar car : cars) { //for문 익히기
			if (car.getMove() == max) {
				winners.add(car.getName());
			}
		}
		
		System.out.println("최종 우승자 : " + String.join(", ", winners)); //String.join 익히기
	}
}

class ownCar {
	private String name;
	private int move;
	private Random random;

	public ownCar(String name) {
		this.name = name;
		this.move = 0;
		this.random = new Random();
	}

	public void move() {
		if (random.nextInt(10) >= 4) {
			move++;
		}
	}

	public String getName() {
		return name;
	}

	public int getMove() {
		return move;
	}
	
	public String getMoveHyphen() {
		StringBuilder sb = new StringBuilder(); //스트링빌더 익히기
		for (int i = 0; i< move ; i++) {
			sb.append("-");
		}
		return sb.toString();
		
	}

}
