package Chap2_기본자료구조;

class PhyscData implements Comparable<PhyscData> { // 다른 클래스.
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) { // 생성자 형성. 아래서 인스턴스(인수있는) 생성했으니까.
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData data) {
		if (this.name.compareTo(data.name) > 0) { // 스트링을 인트비교로.
			return 1;
		}
		if (this.name.compareTo(data.name) < 0) {
			return -1;
		}
		if (this.height > data.height) {
			return 1;
		}
		if (this.height < data.height) {
			return -1;
		}
		return 0;

	}

	@Override
	public String toString() {
		return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}

}

//------------------------------------------------------------------------------------------

public class 과제1_2장기본자료구조 {

	public static void main(String[] args) {
		PhyscData[] data = { 
				new PhyscData("홍길동", 162, 0.3), 
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), 
				new PhyscData("김홍길동", 172, 0.3), 
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2), 
				new PhyscData("최길동", 169, 0.5),
				new PhyscData("이길동", 201,2.0)
				};

		showData(data);
		System.out.println();
		sortData(data);
		showData(data);
	}

	static void showData(PhyscData[] items) {
		// 난수생성하여 배열에 입력
		for (PhyscData p : items)
			System.out.println(p);

	}

	static void sortData(PhyscData[] items) {
		for (int i = 0; i < items.length - 1; i++)
			for (int j = i + 1; j < items.length; j++)
				if (items[i].compareTo(items[j]) > 0)
					swap(items, i, j);
	}

	static void swap(PhyscData[] items, int i, int j) {
		PhyscData temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

}
