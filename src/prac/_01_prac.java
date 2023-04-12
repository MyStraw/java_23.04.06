package prac;

public class _01_prac {

	private String brand;
	private String size;

	public _01_prac() {

	}
	
	public _01_prac(String brand, String size) {
		this.brand=brand;
		this.size=size;
		
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand=brand;
		
	}
	
	public String getSize() {
		return size;		
	}
	
	public void setSize(String size) {
		this.size=size;
	}
	
	
	
	@Override
	public String toString() {
		return "brand= " + brand + ", size=" + size  ;
	}

	public static void main(String[] args) {
		_01_prac audi = new _01_prac("audi", "중형");
		_01_prac benz = new _01_prac("benz", "소형");		
		_01_prac bmw = new _01_prac();
		bmw.setSize("대형");
		bmw.setBrand("BMW");
		
		System.out.println(audi.toString());
		System.out.println(benz.toString());
		System.out.println(bmw.toString());
		
		System.out.println(bmw.getSize());
		System.out.println(audi.getBrand());
		
		
		
	
		
	}
}
