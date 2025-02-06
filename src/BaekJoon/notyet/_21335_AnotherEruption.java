package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21335_AnotherEruption {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double area = Double.parseDouble(br.readLine());	
		double radius = Math.sqrt(area / Math.PI);	
		double circumference = 2 * Math.PI * radius;	
		System.out.println(String.format("%.9f", circumference));	
	}
}
