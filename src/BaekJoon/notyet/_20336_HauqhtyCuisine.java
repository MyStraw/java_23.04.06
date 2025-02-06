package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class _20336_HauqhtyCuisine {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<List<String>> menus = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {			
			String[] input = br.readLine().split(" ");			
			List<String> dishes = new ArrayList<>(Arrays.asList(input).subList(1, input.length));		
			menus.add(dishes);
		}
		
		Random random = new Random();
		List<String> recommendedMenu = menus.get(random.nextInt(n));
		
		System.out.println(recommendedMenu.size());
	
		for (String dish : recommendedMenu) {
			System.out.println(dish);
		}
	}

}
