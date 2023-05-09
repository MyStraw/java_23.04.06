package Chap3_검색알고리즘연습;

import java.util.Arrays;
import java.util.Comparator;

class Fruits {
    String name;
    int price;
    String expire;

    public Fruits(String name, int price, String expire) {
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
}

public class Fruit객체배열이진탐색_Test2 {
    public static void main(String[] args) {
        Fruits[] arr = { new Fruits("사과", 200, "2023-5-8"), new Fruits("키위", 500, "2023-6-8"),
                new Fruits("오렌지", 200, "2023-7-8"), new Fruits("바나나", 50, "2023-5-18"), new Fruits("수박", 880, "2023-5-28"),
                new Fruits("체리", 10, "2023-9-8") };

        System.out.println("정렬전 객체 배열: ");
        showData(arr);

        // 가격을 기준으로 정렬
        Comparator<Fruits> cc_price = new Comparator<Fruits>() {
            public int compare(Fruits f1, Fruits f2) {
                return (f1.getPrice() - f2.getPrice());
            }
        };
        Arrays.sort(arr, cc_price);
        System.out.println("Comparator 정렬(가격)후 객체 배열: ");
        showData(arr);

        // 이름을 기준으로 정렬
        Comparator<Fruits> cc_name = new Comparator<Fruits>() {
            public int compare(Fruits f1, Fruits f2) {
                return (f1.getName().compareTo(f2.getName()));
            }
        };
        Arrays.sort(arr, cc_name);
        System.out.println("Comparator 정렬(이름)후 객체 배열: ");
        showData(arr);

        Fruits newFruit = new Fruits("체리", 500, "2023-5-18");
        int result = Arrays.binarySearch(arr, newFruit, cc_name);
        System.out.println("\nArrays.binarySearch() 조회결과(이름 기준)::" + result);

        result = Arrays.binarySearch(arr, newFruit, cc_price);
        System.out.println("\nArrays.binarySearch() 조회결과(가격 기준)::" + result);
    }

    private static void showData(Fruits[] arr) {
        for (Fruits fruit : arr) {
            System.out.println("이름: " + fruit.getName() + ", 가격: " + fruit.getPrice() + ", 유통기한: " + fruit.getExpire());
        }
    }
}
