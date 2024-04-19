package 코테;

public class A_happy_ {
	public static int[] countHappyPlants(int[] plants, int[] watered) {
		int n = plants.length;
		int m = watered.length;
		int[] lastDayWatered = new int[n]; // 각 식물에 마지막으로 물을 준 날
		boolean[] moodSpoiled = new boolean[n]; // 기분이 상한 식물 추적
		int[] result = new int[m]; // 각 날짜별 기분이 좋은 식물의 수

		// 모든 식물에게 0일째에 물을 줬다고 초기화
		for (int i = 0; i < n; i++) {
			lastDayWatered[i] = 0;
		}

		for (int day = 1; day <= m; day++) {
			int happyPlants = 0;
			// 해당 일자에 물을 준 식물
			int wateredPlant = watered[day - 1] - 1;
			lastDayWatered[wateredPlant] = day;

			for (int i = 0; i < n; i++) {
				// 기분이 이미 상했거나, 물을 준 후 충분한 시간이 지나 기분이 상하는 경우
				if (!moodSpoiled[i] && day - lastDayWatered[i] >= plants[i]) { // 이거 등호때문이었다. 등호해주니 해결.
					moodSpoiled[i] = true;
				}
				// 기분이 좋은 식물 카운트
				if (!moodSpoiled[i]) {
					happyPlants++;
				}
			}
			result[day - 1] = happyPlants;
		}

		return result;
	}

	public static void main(String[] args) {
//		int[] plants = { 2, 3, 1, 2 };
//		int[] watered = { 3, 1, 2, 1, 4, 1 };
//
//        int[] plants = {5,5,5};
//        int[] watered = {1,2,1,2,3}; //답 3 3 3 3 3
        
        int[] plants = {2,1,3,4,3};
        int[] watered = {2,2,2,2,5,5,5}; //답 5 4 2 1 0 0 0

		int[] result = countHappyPlants(plants, watered);

		// 결과 출력
		System.out.print("결과: ");
		for (int r : result) {
			System.out.print(r + " ");
		}
	}
}

/*
 * 1~n개의 식물이 있고 1일~m일간 물을줄거야
 * 
 * i번째 식물에게 [i-1]일 연속으로 물을 안주면 이 식물은 삐져서 기분이 상해.
 * 
 * 그리고 이 기분은 돌아오지 않아 (제일중요)
 * 
 * 이게 제일 중요해! 한번 기분이 나빠진 애는 물을 줘도 기분이 더이상 좋아지지가 않아.
 * 
 * 아침에 1개의 식물에게만 물을 줄수있고, 저녁에 기분이 좋은 식물이 돼
 * 
 * 0일째에 모든 식물에게 물을 줬다면
 * 
 * 1일~m일간 날짜별로 기분이 좋은 식물은 몇개인지 카운트 하는 코드문제.
 * 
 * 예를 들어서
 * 
 * 입력값으로 int plants[] = {2,3,1,2} - 인덱스 순서대로 식물, 각 식물의 물안줄때 삐지는 날짜(1번 식물은 이틀 안주면
 * 삐짐) int wartered[] = {3,1,2,1,4,1} - 매일 물 준 일차
 * 
 * 제일 중요한거. 식물은 한번 기분 나빠지면 그다음 물 줘도 다시 기분이 돌아오지 않는다.! 이렇게 주어지면
 * 
 * 결과는 int result[] = {4,2,2,2,2,1} 이 나오겠지?
 * 
 * 1<= i<=plants[]의 길이<=300000 이야 plants[i] -> i+1번 식물한테.
 * 
 * 풀렸다!! 
 * 
 */