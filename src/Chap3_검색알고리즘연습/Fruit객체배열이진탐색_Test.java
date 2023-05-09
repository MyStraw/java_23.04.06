package Chap3_검색알고리즘연습;

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
}

public class Fruit객체배열이진탐색_Test {
    public static void main(String[] args) {
        Fruit[] arr = { new Fruit("사과", 200, "2023-5-8"), new Fruit("키위", 500, "2023-6-8"),
                new Fruit("오렌지", 200, "2023-7-8"), new Fruit("바나나", 50, "2023-5-18"), new Fruit("수박", 880, "2023-5-28"),
                new Fruit("체리", 10, "2023-9-8") };

        System.out.println("정렬전 객체 배열: ");
        showData(arr);

        Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice());
        System.out.println("람다식 정렬(가격)후 객체 배열: ");
        showData(arr);

        Arrays.sort(arr, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit a1, Fruit a2) {
                return a1.getName().compareTo(a2.getName());
            }
        });

        System.out.println("comparator 정렬(이름)후 객체 배열: ");
        showData(arr);

        Comparator<Fruit> cc_name = new Comparator<Fruit>() {
            public int compare(Fruit f1, Fruit f2) {
                return (f1.name.compareTo(f2.name));
            }
        };
        Comparator<Fruit> cc_price = new Comparator<Fruit>() {
            public int compare(Fruit f1, Fruit f2) {
                return (f1.price - f2.price);
            }
        };

        Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
        int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
        System.out.println("\nArrays.binarySearch() 조회결과::" + result3);

        // 추가한 부분: 사용자 정의 이진 탐색 함수
        result3 = binarySearch(arr, newFruit, cc_name);
        System.out.println("\nbinarySearch() 조회결과::" + result3);

        Arrays.sort(arr, cc_price);
        System.out.println("comparator 정렬(가격)후 객체 배열: ");
        showData(arr);
        result3 = Arrays.binarySearch(arr, newFruit, cc_price);
        System.out.println("\nArrays.binarySearch() 조회결과::" + result3);

        // 추가한 부분: 사용자 정의 이진 탐색 함수
        result3 = binarySearch(arr, newFruit, cc_price);
        System.out.println("\nbinarySearch() 조회결과::" + result3);
    }

    private static void showData(Fruit[] arr) {
        for (Fruit f : arr) {
            System.out.printf("(%s, %d, %s) ", f.getName(), f.getPrice(), f.getExpire());
            System.out.println();
        }
        System.out.println();
    }

    // 추가한 부분: 사용자 정의 이진 탐색 함수
    private static int binarySearch(Fruit[] arr, Fruit key, Comparator<Fruit> c) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            Fruit midVal = arr[mid];
            int cmp = c.compare(midVal, key);

            if (cmp < 0) {
                left = mid + 1;
            } else if (cmp > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);
    }
}

