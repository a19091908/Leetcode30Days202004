package leetCode30Day;

public class BestTimeToBuyAndSellStockII5 {

	public static void main(String[] args) {
		int[] priceArr = {7,1,5,3,6,4};
		int profits = run(priceArr);
		System.out.println(profits);
	}

	private static int run(int[] prices) {
		int profits = 0;
		for (int i = 0; i < prices.length-1 ; i++) {
			if(prices[i] < prices[i+1])
				profits += prices[i+1]-prices[i];
		}
		
		return profits;
	}

}
