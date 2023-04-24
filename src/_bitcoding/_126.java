package _bitcoding;

public class _126 {
	public static void main(String[] args) {
		int i = 127;
		 
		String binaryString = Integer.toBinaryString(i); //2진수		
		String octalString = Integer.toOctalString(i);   //8진수
		String hexString = Integer.toHexString(i);       //16진수
		 
		System.out.println(binaryString); //1111111
		System.out.println(octalString);  //177
		System.out.println(hexString);    //7f
		
	}

}
