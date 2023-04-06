package chapter4;
//for loop 한개만 이용해서 해봐라. 어차피 11,22,33 이런애들만 더하는거니 결과값에 주목! i,i 로 하면 되네
//원하는 것만 얻기
public class Test39_1 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) { // 그러니까 행(세로줄)갯수 몇개냐			
					sum +=arr[i][i];  //arr[][] 행렬 이 값안의 수를 더하란겨
			}// 5x5 짜리 행렬이니 가능. 5x4 행렬이면 안됨. 5가 i이니 가로가 한칸씩 부족
		System.out.println("합계 : " + sum);
		}
	}


