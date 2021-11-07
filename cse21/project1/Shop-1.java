import java.util.Scanner;
public class Shop {

	static double rate = 0;
	static double disc_rate = 0;

	public static int setUpShop(Scanner input, String[] names, double[] prices) {

		System.out.print("Please enter the number of items: ");
		int max = input.nextInt();





		int[] items = new int[max];

		for(int i = 0;i < max;i++){
			System.out.print("What is the name of item " + i + ":");
			names[i] = input.next();

			System.out.print("What is the price of item " + i + ":");
			System.out.print("$");
			prices[i] = input.nextDouble();


		}
		System.out.print("Please enter the amount to qualify for discount: ");
		rate = input.nextDouble();
		
		System.out.print("Please enter the discount rate(0.1 to 10%): ");
		disc_rate = input.nextDouble();

		return max;

	}
	public static void buyFromShop(Scanner input, String[] names, double[] prices, int[] amounts, int items) {

		for(int i =0; i < items; i++) {
			System.out.print("How much " + names[i] + " would you like to buy? ");
			amounts[i] = input.nextInt();
		}

	}
	public static void listItemShop(String[] names, double[] prices, int[] amounts, int max) {

		for(int i = 0;i < max; i++) {
			if(amounts[i] > 0 ) {

				System.out.println(amounts[i] + " amounts of " + names[i] + " @ " + prices[i] + " = $" + (amounts[i]*prices[i]));

			}
		}

	}
	public static void checkoutShop(double[] prices, int[] amounts) {

		double total = 0;


		for(int i=0;i < amounts.length;i++) {

			total = prices [i]*amounts[i] + total;

		}

		double discount = 0;
		discount = total*disc_rate;

		if(total >= rate) {
			System.out.println("");
			System.out.println("Thanks for coming!");
			System.out.println("subTotal$: " + total);
			System.out.println("-Discount$: "+ discount);
			System.out.println("Total$: " + (total-(discount)));
		}else if(total < rate ) {

			System.out.println("");
			System.out.println("Thanks for coming!");
			System.out.println("subTotal$: " + total);
			System.out.println("-Discount$: "+ "$0.0");
			System.out.println("Total$: " + total);

		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int end = 100;
		int set = 0;
		int buy = 0;
		int items = 0;

		String[] names = new String[end];
		double[] prices = new double[end];
		int[] amounts = new int[end];

		Scanner input = new Scanner(System.in);


		do {

			System.out.println("This Program supports 4 functions: ");
			System.out.println("         1. Setup Shop");
			System.out.println("         2. Buy");
			System.out.println("         3. List Items");
			System.out.println("         4. Checkout");

			System.out.print("Please choose the function you want: ");
			int function = input.nextInt();

			if(1 <= function || function >= 4) {

				if(function == 1) {

					if(set >= 0) {

						items = setUpShop(input, names, prices);
					}

					set = 1;
				}

				if(function == 2) {

					if(set>= 1) {

						System.out.print("");
						buyFromShop(input, names, prices, amounts, items);
						System.out.println("");
					} else {
						System.out.print("");
						System.out.print("Shop is not set up yet!");
						System.out.println("");
					}

					buy = 1;
					
				}

				
				if (function == 3){
					
					if (buy >= 1){
					System.out.print("");
					listItemShop(names, prices, amounts, items);
					System.out.println();
					}	
					
					if (set == 1 && buy == 0){
					System.out.println();
					System.out.println("Try again: You have not bought anything!");
					System.out.println(); 
					
					}	
					if (set == 0){
					System.out.println("");
					System.out.println("Shop is not setup yet!");
					System.out.println("");
						}
					}
					
					
					if (function == 4){
					if (set == 0){
					System.out.print("");
					System.out.println("Shop is not setup yet!");
					System.out.println(""); 
					continue;
						}
					
					if (buy == 0){
					System.out.print("");
					System.out.println("Try again: You have not bought anything!");
					System.out.println(); 
					
					continue;
						}
					if (buy == 1){
					checkoutShop(prices, amounts);
					break;
					
						} 
					}
					
						
					
					}
					if(function<=0||function>=5){
						System.out.println();
						System.out.println("Error: Do not know " + function);	
						System.out.println();
						continue;
					}

			


			} while(true);




	}

}
