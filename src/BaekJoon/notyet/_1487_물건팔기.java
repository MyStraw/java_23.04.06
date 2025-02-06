package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1487_물건팔기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Sell[] stuff = new Sell[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int delivery = Integer.parseInt(st.nextToken());
			stuff[i] = new Sell(money, delivery);
		}

		int maxProfit = 0;
		int bestPrice = 0;

		for (int i = 0; i < N; i++) {
			int price = stuff[i].money;
			int profit = 0;
			for (int j = 0; j < N; j++) {
				if (stuff[j].money >= price) {
					int net = price - stuff[j].delivery;
					if (net > 0) {
						profit += net;
					}
				}

			}
			if (profit > maxProfit) {
				maxProfit = profit;
				bestPrice = price;
			} else if (profit == maxProfit && price < bestPrice) {
				bestPrice = price;
			}
		}
		if (maxProfit > 0) {
			System.out.println(bestPrice);
		} else {
			System.out.println(0);
		}

	}

	static class Sell {
		int money;
		int delivery;

		private Sell(int money, int delivery) {
			this.money = money;
			this.delivery = delivery;
		}
	}

}
