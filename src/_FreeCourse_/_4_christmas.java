package _FreeCourse_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.DayOfWeek;


public class _4_christmas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
		System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

		int day = sc.nextInt();
		System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

		String order = sc.next();

		System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

		System.out.println("<주문 메뉴>");
	}

}



class DiscountCalculator {
    public boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
    }
    
    public boolean isSpecialDiscountDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.equals(LocalDate.of(date.getYear(), 12, 25));
    }

    // ... 기타 메서드
}





class MenuItem {
	private String name;
	private int price;

	public MenuItem(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// Getter and Setter 생략

	public String toString() {
		return name + " (" + price + ")";
	}

	public static void main(String[] args) {
		
		List<MenuItem> appetizer = new ArrayList<>();
		appetizer.add(new MenuItem("양송이수프", 6_000));
		appetizer.add(new MenuItem("타파스", 5_500));
		appetizer.add(new MenuItem("시저샐러드", 8_000));		
		
		
		// 메인 메뉴 리스트 생성
		List<MenuItem> mainDishes = new ArrayList<>();
		
		mainDishes.add(new MenuItem("티본스테이크", 55_000));
		mainDishes.add(new MenuItem("바비큐립", 54_000));
		mainDishes.add(new MenuItem("해산물파스타", 35_000));
		mainDishes.add(new MenuItem("크리스마스파스타", 25_000));

		// 디저트 메뉴 리스트 생성
		List<MenuItem> desserts = new ArrayList<>();
		desserts.add(new MenuItem("초코케이크", 15_000));
		desserts.add(new MenuItem("아이스크림", 5_000));

		// 음료 메뉴 리스트 생성
		List<MenuItem> drinks = new ArrayList<>();
		drinks.add(new MenuItem("제로콜라", 3_000));
		drinks.add(new MenuItem("레드와인", 60_000));
		drinks.add(new MenuItem("샴페인", 25_000));

		// 메뉴 출력 예시
		
		System.out.println("애피타이저:");
		for (MenuItem item : appetizer) {
			System.out.println(item);
		}		
		
		System.out.println("메인 메뉴:");
		for (MenuItem item : mainDishes) {
			System.out.println(item);
		}

		System.out.println("\n디저트:");
		for (MenuItem item : desserts) {
			System.out.println(item);
		}

		System.out.println("\n음료:");
		for (MenuItem item : drinks) {
			System.out.println(item);
		}
	}
}
