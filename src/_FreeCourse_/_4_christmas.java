package _FreeCourse_;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class _4_christmas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
		System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
		int day = sc.nextInt();
		sc.nextLine();

		System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
		String order = sc.nextLine();

		String[] orderedItems = StringUtil.splitString(order, ",");
		LocalDate visitDate = LocalDate.of(2023, 12, day);

		OrderService orderService = new OrderService();
		DiscountService discountService = new DiscountService();
		BadgeService badgeService = new BadgeService();

		Order orderResult = orderService.processOrder(orderedItems, visitDate, new DayService());

		// 주문 결과 검증
		if (orderResult.totalCost < Constants.MIN_ORDER_AMOUNT) {
			System.out.println("[ERROR] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
		}
		if (orderResult.onlyDrink) {
			System.out.println("[ERROR] 음료만 주문할순 없습니다.");
			return;
		}
		if (orderResult.totalItemsCount > Constants.MAX_ITEM_COUNT) {
			System.out.println("[ERROR] 메뉴는 최대 20개까지만 주문할 수 있습니다.");
			return;
		}

		// 증정이벤트 - 샴페인
		String giftedItem = "";
		int giftedItemValue = 0; //
		if (orderResult.totalCost >= Constants.CHAMPAGNE_GIFT_MIN_AMOUNT) {
			giftedItem = "샴페인 1개";
			giftedItemValue = MenuService.getChampagnePrice();
		}

		int totalDiscount = discountService.calculateTotalDiscount(orderResult, giftedItem, giftedItemValue); // 총 할인 금액
																												// 초기화

		System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
		System.out.println("<주문 메뉴>");
		for (String item : orderedItems) {
			String[] parts = StringUtil.parseMenuItem(item);
			String menuItemName = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			System.out.println(menuItemName + " " + quantity + "개");
		}

		System.out.println("\n<할인 전 총주문 금액>");
		System.out.println(StringUtil.formatCurrency(orderResult.totalCost));

		// 증정 메뉴 출력
		System.out.println("\n<증정 메뉴>");
		
		printGiftedItem(giftedItem);
		System.out.println("\n<혜택 내역>");

		if (orderResult.totalCost >= Constants.MIN_ORDER_AMOUNT) {
			DiscountService discountServicePrint = new DiscountService();
			totalDiscount = discountServicePrint.calculateTotalDiscount(orderResult, giftedItem, giftedItemValue);			

		} else {
			System.out.println("없음");
		}
		System.out.println("\n<총혜택 금액>");
		printTotalDiscount(totalDiscount);

		System.out.println("\n<할인 후 예상 결제 금액>");
		int predictedPayment = orderResult.totalCost - totalDiscount + giftedItemValue;
		System.out.println(StringUtil.formatCurrency(predictedPayment));

		String eventBadge = badgeService.determineEventBadge(totalDiscount);

		System.out.println("\n<12월 이벤트 배지>");
		System.out.println(eventBadge);

	}

	private static void printGiftedItem(String giftedItem) {
		if (giftedItem.isEmpty()) {
			System.out.println("없음");
			return;
		}
		System.out.println(giftedItem);
	}

	private static void printTotalDiscount(int totalDiscount) {
		if (totalDiscount != 0) {
			System.out.println("-" + StringUtil.formatCurrency(totalDiscount));
			return;
		}
		System.out.println("없음");
	}

}

class Order {
	int totalCost;
	int totalItemsCount;
	boolean onlyDrink;
	int weekdayDiscount;
	int weekendDiscount;
	int ddayDiscount;
	int specialDiscount;

	Order(int totalCost, int totalItemsCount, boolean containsNonDrink, int weekdayDiscount, int weekendDiscount,
			int ddayDiscount, int specialDiscount) {
		this.totalCost = totalCost;
		this.totalItemsCount = totalItemsCount;
		this.onlyDrink = containsNonDrink;
		this.weekdayDiscount = weekdayDiscount;
		this.weekendDiscount = weekendDiscount;
		this.ddayDiscount = ddayDiscount;
		this.specialDiscount = specialDiscount;
	}

}

class OrderService {
	public Order processOrder(String[] orderedItems, LocalDate visitDate, DayService discountCalculator) {
		int totalCost = 0;
		int totalItemsCount = 0;
		boolean onlyDrink = true;
		int weekdayDiscount = 0;
		int weekendDiscount = 0;
		int ddayDiscount = discountCalculator.calculateDdayDiscount(visitDate);
		int specialDiscount = 0;

		if (discountCalculator.isSpecialDay(visitDate)) {
			specialDiscount = discountCalculator.calculateSpecialDiscount(visitDate, true);
		}

		boolean isWeekend = discountCalculator.isWeekEnd(visitDate);

		for (String item : orderedItems) {
			String[] parts = item.trim().split("-");
			String menuItemName = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			totalItemsCount += quantity;

			for (List<Menu> menuList : List.of(Menu.getAppetizer(), Menu.getMainDishes(), Menu.getDesserts(),
					Menu.getDrinks())) {
				for (Menu menuItem : menuList) {
					if (menuItem.getName().equals(menuItemName)) {
						totalCost += menuItem.getPrice() * quantity;
						if (!menuList.equals(Menu.getDrinks())) {
							onlyDrink = false;
						}

						if (menuList.equals(Menu.getDesserts()) && !isWeekend) {
							weekdayDiscount += discountCalculator.calculateWeekdayDiscount(quantity);
						} else if (menuList.equals(Menu.getMainDishes()) && isWeekend) {
							weekendDiscount += discountCalculator.calculateWeekendDiscount(quantity);
						}
						break;
					}
				}
			}
		}

		return new Order(totalCost, totalItemsCount, onlyDrink, weekdayDiscount, weekendDiscount, ddayDiscount,
				specialDiscount);
	}
}

class DayService {

	// 월요일부터 금요일까지를 평일로 판단
	public boolean isWeekDay(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return !(day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY);
	}

	// 토요일과 일요일을 주말로 판단
	public boolean isWeekEnd(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
	}

	// 특별한 날을 판단 (일요일 또는 크리스마스)
	public boolean isSpecialDay(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SUNDAY
				|| date.equals(LocalDate.of(date.getYear(), 12, Constants.CHRISTMAS));
	}

	// D-day 할인 계산
	public int calculateDdayDiscount(LocalDate date) {
		int startDayOfMonth = 1;
		int discountPerDay = Constants.DISCOUNT_PER_DAY;
		int initialDiscount = Constants.SPECIAL_INITIAL_DISCOUNT;
		int dayOfMonth = date.getDayOfMonth();

		if (dayOfMonth <= Constants.CHRISTMAS) {
			return initialDiscount + (dayOfMonth - startDayOfMonth) * discountPerDay;
		}
		return 0;
	}

	// 평일 할인 계산 (디저트 메뉴)
	public int calculateWeekdayDiscount(int dessertCount) {
		int weekdayDiscountPerDessert = Constants.WEEKDAY_DISCOUNT_PER_DESSERT;
		return dessertCount * weekdayDiscountPerDessert;
	}

	// 주말 할인 계산 (메인 메뉴)
	public int calculateWeekendDiscount(int mainDishCount) {
		int weekendDiscountPerMainDish = Constants.WEEKEND_DISCOUNT_PER_MAIN_DISH;
		return mainDishCount * weekendDiscountPerMainDish;
	}

	// 특별할인 계산
	public int calculateSpecialDiscount(LocalDate date, boolean hasStar) {
		if (hasStar) {
			return Constants.SPECIAL_INITIAL_DISCOUNT;
		}
		return 0;
	}
}

class Menu {
	private String name;
	private int price;

	private static List<Menu> appetizer = new ArrayList<>();
	private static List<Menu> mainDishes = new ArrayList<>();
	private static List<Menu> desserts = new ArrayList<>();
	private static List<Menu> drinks = new ArrayList<>();

	static { // 처음 한번 실행
		// 에피타이저
		appetizer.add(new Menu("양송이수프", 6_000));
		appetizer.add(new Menu("타파스", 5_500));
		appetizer.add(new Menu("시저샐러드", 8_000));

		// 메인
		mainDishes.add(new Menu("티본스테이크", 55_000));
		mainDishes.add(new Menu("바비큐립", 54_000));
		mainDishes.add(new Menu("해산물파스타", 35_000));
		mainDishes.add(new Menu("크리스마스파스타", 25_000));

		// 디저트
		desserts.add(new Menu("초코케이크", 15_000));
		desserts.add(new Menu("아이스크림", 5_000));

		// 음료
		drinks.add(new Menu("제로콜라", 3_000));
		drinks.add(new Menu("레드와인", 60_000));
		drinks.add(new Menu("샴페인", Constants.CHAMPAGNE_PRICE));
	}

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public static List<Menu> getAppetizer() {
		return appetizer;
	}

	public static List<Menu> getMainDishes() {
		return mainDishes;
	}

	public static List<Menu> getDesserts() {
		return desserts;
	}

	public static List<Menu> getDrinks() {
		return drinks;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}

enum Discount {
	D_DAY_DISCOUNT {
		@Override
		public int applyDiscount(Order orderResult, String giftedItem, int giftedItemValue,
				DecimalFormat decimalFormat) {
			if (orderResult.ddayDiscount > 0) {
				// System.out.println("크리스마스 디데이 할인: -" +
				// decimalFormat.format(orderResult.ddayDiscount) + "원");
				System.out.println("크리스마스 디데이 할인: -" + StringUtil.formatCurrency(orderResult.ddayDiscount));
				return orderResult.ddayDiscount;
			}
			return 0;
		}
	},
	WEEKDAY_DISCOUNT {
		@Override
		public int applyDiscount(Order orderResult, String giftedItem, int giftedItemValue,
				DecimalFormat decimalFormat) {
			if (orderResult.weekdayDiscount > 0) {
				// System.out.println("평일 할인: -" +
				// decimalFormat.format(orderResult.weekdayDiscount) + "원");
				System.out.println("평일 할인: -" + StringUtil.formatCurrency(orderResult.weekdayDiscount));
				return orderResult.weekdayDiscount;
			}
			return 0;
		}
	},

	WEEKEND_DISCOUNT {
		@Override
		public int applyDiscount(Order orderResult, String giftedItem, int giftedItemValue,
				DecimalFormat decimalFormat) {
			if (orderResult.weekendDiscount > 0) {
				// System.out.println("주말 할인: -" +
				// decimalFormat.format(orderResult.weekendDiscount) + "원");
				System.out.println("주말 할인: -" + StringUtil.formatCurrency(orderResult.weekendDiscount));
				return orderResult.weekendDiscount;
			}
			return 0;
		}
	},

	SPECIAL_DISCOUNT {
		@Override
		public int applyDiscount(Order orderResult, String giftedItem, int giftedItemValue,
				DecimalFormat decimalFormat) {
			if (orderResult.specialDiscount > 0) {
				// System.out.println("특별 할인: -" +
				// decimalFormat.format(orderResult.specialDiscount) + "원");
				System.out.println("특별 할인: -" + StringUtil.formatCurrency(orderResult.specialDiscount));
				return orderResult.specialDiscount;
			}
			return 0;
		}
	},

	GIFTED_ITEM {
		@Override
		public int applyDiscount(Order orderResult, String giftedItem, int giftedItemValue,
				DecimalFormat decimalFormat) {
			if (giftedItem.isEmpty()) {
				System.out.println("증정 이벤트: 없음");
				return 0;
			} else {
				// System.out.println("증정 이벤트: -" + decimalFormat.format(giftedItemValue) +
				// "원");
				System.out.println("증정 이벤트: -" + StringUtil.formatCurrency(giftedItemValue));
				return giftedItemValue;
			}
		}

	};

	public abstract int applyDiscount(Order orderResult, String giftedItem, int giftedItemValue,
			DecimalFormat decimalFormat);
}

class Constants {
	public static final int WEEKDAY_DISCOUNT_PER_DESSERT = 2_023;
	public static final int WEEKEND_DISCOUNT_PER_MAIN_DISH = 2_023;
	public static final int DISCOUNT_PER_DAY = 100;
	public static final int CHRISTMAS = 25;
	public static final int SPECIAL_INITIAL_DISCOUNT = 1_000;
	public static final int CHAMPAGNE_PRICE = 25_000;
	public static final int MIN_ORDER_AMOUNT = 10_000;
	public static final int MAX_ITEM_COUNT = 20;
	public static final int CHAMPAGNE_GIFT_MIN_AMOUNT = 120_000;
	public static final int SANTA = 20_000;
	public static final int TREE = 10_000;
	public static final int STAR = 5_000;

	private Constants() { // 인스턴스 생성을 애초에 막아버리기

	}
}

class StringUtil {
	public static String[] splitString(String input, String delimiter) {
		return input.split(delimiter);
	}

	public static String[] parseMenuItem(String orderItem) {
		return orderItem.trim().split("-");
	}

	public static String formatCurrency(int amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		return decimalFormat.format(amount) + "원";
	}

}

class DateUtil {

	public static boolean isWeekDay(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return !(day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY);
	}

	public static boolean isWeekEnd(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
	}

	public static boolean isSpecialDay(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SUNDAY
				|| date.equals(LocalDate.of(date.getYear(), 12, Constants.CHRISTMAS));
	}
}

class DiscountService {
	public int calculateTotalDiscount(Order order, String giftedItem, int giftedItemValue) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		int totalDiscount = 0;
		totalDiscount += Discount.D_DAY_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
		totalDiscount += Discount.WEEKDAY_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
		totalDiscount += Discount.WEEKEND_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
		totalDiscount += Discount.SPECIAL_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
		totalDiscount += Discount.GIFTED_ITEM.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
		return totalDiscount;
	}

	public String totalDiscount(int discountAmount, DecimalFormat decimalFormat) {
		if (discountAmount == 0) {
			return "0원";
		}
		return "-" + StringUtil.formatCurrency(discountAmount);
	}

}

class MenuService {
	// 샴페인 가격 조회
	public static int getChampagnePrice() {
		return Menu.getDrinks().stream().filter(m -> m.getName().equals("샴페인")).findFirst().map(Menu::getPrice)
				.orElse(0);
	}

	// 모든 메뉴 목록 조회
	public static List<Menu> getAllMenus() {
		List<Menu> allMenus = new ArrayList<>();
		allMenus.addAll(Menu.getAppetizer());
		allMenus.addAll(Menu.getMainDishes());
		allMenus.addAll(Menu.getDesserts());
		allMenus.addAll(Menu.getDrinks());
		return allMenus;
	}

	// 특정 메뉴 조회
	public static Optional<Menu> getMenuByName(String name) {
		return getAllMenus().stream().filter(m -> m.getName().equals(name)).findFirst();
	}
}

class BadgeService {

	public String determineEventBadge(int totalDiscount) {
		if (totalDiscount >= Constants.SANTA) {
			return "산타";
		} else if (totalDiscount >= Constants.TREE) {
			return "트리";
		} else if (totalDiscount >= Constants.STAR) {
			return "별";
		} else {
			return "없음";
		}
	}
}