package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _4714_Lunacy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Double> weights = new ArrayList<>();
		
		while (true) {
			double weight = Double.parseDouble(br.readLine().trim());
			if (weight < 0) { 
				break;
			}
			weights.add(weight);
		}

		double moon = 0.167;
	
		for (double weight : weights) {
			double moonWeight = weight * moon; 
			System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", weight, moonWeight);
		}
	}

}
