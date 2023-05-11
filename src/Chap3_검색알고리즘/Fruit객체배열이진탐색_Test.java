package Chap3_검색알고리즘;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	String name;
	int price;
	String expire;

	public Fruit(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;

	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getExpire() {
		return expire;
	}

	// final은 상수. 바뀌지 않음. 이 변수값은 변경하지 못한다!.
	public static final Comparator<Fruit> class_cc = new ComparatorFruit(); //바로 아래에서 expire 이용.

	private static class ComparatorFruit implements Comparator<Fruit> {
		public int compare(Fruit f1, Fruit f2) {
			return (f1.expire.compareTo(f2.expire));
		} // static을 집어넣고, 바깥에서 못건들게 private
	};// 인터페이스 구현한 클래스 만들고, static 변수로 객체 만들어서. 컴페어 메소드 구현.

	// int compare(Ta, Tb); 이게 밑에 람다식(함수명 신경 안쓰겠다) (a,b) 이 부분이 a.getPrice(),
	// b.getPrice()
	// Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice());
}

public class Fruit객체배열이진탐색_Test {

	public static void main(String[] args) {
		Fruit[] arr = { new Fruit("사과", 200, "2023-5-8"), 
				new Fruit("키위", 500, "2023-6-8"),
				new Fruit("오렌지", 200, "2023-7-8"), 
				new Fruit("바나나", 50, "2023-5-18"), 
				new Fruit("수박", 880, "2023-5-28"),
				new Fruit("체리", 10, "2023-9-8") };
//////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("-".repeat(40));
		System.out.println("정렬전 객체 배열: ");
		System.out.println();
		showData(arr);
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Arrays.sort(null, null); //
		// Arrays.sort(T[]a, T key, Comparator <?super T> c) sort에도 이게 있다.
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용.
		// 컴페레이터와 람다식이 뭔상관이야. 이게 어려운겨~
		// int compare(Ta, Tb); 이게 밑에 람다식(함수명 신경 안쓰겠다) (a,b) 이 부분이 a.getPrice(),
		// b.getPrice()
		// 익명클래스 객체를 만들어서 객체를 사용. 컴페어의 {}함수바디를 람다식에서 구현.

		// 컴페레이터<?superT> 이거는 내부 메소드에 컴페어가 있고, 이 컴페어는 2개를 받아서 쓰는데
		// 이걸 람다식으로 객체로서 받아서 이용. 단어는 틀릴수 있다. 흐름을 이해해보자.
		System.out.println("-".repeat(40));
		System.out.println("람다식 정렬(가격)후 객체 배열: ");
		System.out.println();
		showData(arr);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		Arrays.sort(arr, new Comparator<Fruit>() { // 컴페레이터 익명클래스 만들고, 던져, 배열, 컴페레이터<>
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});// 람다식 쓰는거나 이거나 같다.
		System.out.println("-".repeat(40));
		System.out.println("comparator 정렬(이름)후 객체 배열: ");
		System.out.println();
		showData(arr);
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		Comparator<Fruit> cc_name = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return (f1.name.compareTo(f2.name)); // cc네임은 변수고 객체를 갖고있고, 컴페레이터를 구현한 객체.
			}
		};
		Comparator<Fruit> cc_price = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) { // 컴페레이터를 가지고
				return (f1.price - f2.price);// 프라이스는 숫자니까 빼기만 하면 되넹~
			}
		};
//		Comparator<Fruit> cc_expire = new Comparator<Fruit>() {// 익명클래스 사용
//			public int compare(Fruit f1, Fruit f2) { // 컴페레이터를 가지고
//				return (f1.expire.compareTo(f2.expire));//프라이스는 숫자니까 빼기만 하면 되넹~
//			}
//		}; // 메인에 이렇게 만들어서 써도 되지만 맨위 프루츠 클래스 안에 넣어도 돼. 인터페이스랑 클래스로 만들어서. expire를 쓰는걸 위로 뺐다.
		//객체를 만들어서 비교.

		Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
		
		int result3 = Arrays.binarySearch(arr, newFruit, Fruit.class_cc); // 클래스.이름 => 스태틱이라 클래스이름으로 호출.
		System.out.println("-".repeat(40));
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3); //이건 맨위로 올라가보면 expire로 비교중.
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3); //cc_name으로 찾음.
		
		System.out.println();
		sortData(arr, cc_price); // 이거 제일 아래에 void로.
		System.out.println("-".repeat(40));
		System.out.println("comparator 정렬(가격)후 객체 배열: ");
		System.out.println();
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("-".repeat(40));
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3); //이것 또한 위에서 result3로 cc_price
		result3 = binarySearch(arr, newFruit, cc_price); 
		System.out.println("\nbinarySearch() 조회결과::" + result3);// 여기선 newFruit 인수중 바이너리서치 price 위치 찾기 
		System.out.println();
		System.out.println("-".repeat(40));

//		Arrays.binarySearch(data, key, ); //여기선 comparable 썼잖앙~ tator~ 안썼잖양
		// Arrays. 까지만 치면 binary중에 comparator 고르는게 나온다.
		// (T[]a, T key, Comparator <?super T> c)이거 골라봐.

	}

	static void sortData(Fruit[] arr, Comparator<? super Fruit> cc_price) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (cc_price.compare(arr[i], arr[j]) > 0)
					swap(arr, i, j);
	}

	static void swap(Fruit[] arr, int i, int j) {
		Fruit temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<? super Fruit> cc) {
		// 이진탐색 코드 가져와서 Fruit 버전으로 변경
		// if 문에서 비교할 때
		Fruit f1 = arr[0];
		Fruit f2 = arr[1];//
//		if (cc.compare(d1, d2) > 0) {
//			// 바이너리서치 코드 추가해서 비교
//		}
		int left = 0;
		int right = arr.length - 1;

		f1 = arr[left];
		f2 = arr[right];

		while (left <= right) {
			int mid = (left + right) / 2;
			Fruit middle = arr[mid];
			if (cc.compare(middle, newFruit) == 0) {
				return mid;
			} else if (cc.compare(middle, newFruit) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void showData(Fruit[] arr) {
		for (Fruit fruit : arr) {
		//	System.out.println("이름: " + fruit.getName() + ", 가격: " + fruit.getPrice() + ", 유통기한: " + fruit.getExpire());
			System.out.printf("(이름: %3s, 가격: %3d, 유통기한: %9s)",fruit.getName() ,fruit.getPrice(), fruit.getExpire());
			System.out.println();
		}

	}
}