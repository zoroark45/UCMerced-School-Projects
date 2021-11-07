import java.util.Scanner;
public class BobCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	    // Econ means Economy, Comp means Compact, and Stan means Standard. 
int Econ = 35;
int Comp = 45;
int Stan = 95;
final double platExec = 0.15;
		int carType, Days, clubMember, Discount;
		int platexecPack = 0;
		double platexecAdd = 0;
		double totalEst = 0;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Available cars: 1 for Economy, 2 for Compact, 3 for Standard");
		System.out.print("Choose a car: ");
		carType = scnr.nextInt();
		
		System.out.print("Enter the number of rental days: ");
		Days = scnr.nextInt();
		
		System.out.print("Are you a club member?: " + "1 for yes, 0 for no: ");
		clubMember = scnr.nextInt();
		
if (clubMember == 1){
    
	    System.out.print("Platinum executive package?: 1 for yes, 0 for no: ");
		platexecPack = scnr.nextInt();
}
		
		
		System.out.println(" ");
		
		if(carType == 1&&clubMember == 1&&platexecPack == 0) {

			    
			Discount = (Days/7);
			Discount = Discount*Econ;
			totalEst = (Days*Econ) - Discount;
			
			System.out.println("Base: " + Days + " days for a Economy @ $" + Econ + " per day:   $" + (Days*Econ));
			System.out.println("Club Member Discount: " + "                     " + " -$" + Discount);
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                " + " $" + (int)totalEst);
			
			
		}
		else if(carType == 2&&clubMember == 1&&platexecPack == 0) {
            
            
            Discount = (Days/7);
			Discount = Discount*Comp;
			totalEst = (Days*Comp) - Discount;
			
			System.out.println("Base: " + Days + " days for a Compact @ $" + Comp + " per day:   $" + (Days*Comp));
			System.out.println("Club Member Discount: " + "                     " + " -$" + Discount);
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                " + " $" + (int)totalEst);
		
            
		}
		else if(carType == 3&&clubMember == 1&&platexecPack == 0) {
            
            
            Discount = (Days/7);
			Discount = Discount*Stan;
			totalEst = (Days*Stan) - Discount;
			
			System.out.println("Base: " + Days + " days for a Standard @ $" + Stan + " per day:   $" + (Days*Stan));
			System.out.println("Club Member Discount: " + "                     " + " -$" + Discount);
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                " + " $" + (int)totalEst);

            
		}
		else if(carType == 1&&clubMember == 1&&platexecPack == 1) {
            
            
            Discount = (Days/7);
			Discount = (Discount*Econ);
            platexecAdd = (double)(Days*Econ)*platExec;
            totalEst = (double)(Days*Econ) - (double)Discount + platexecAdd;
			
			System.out.println("Base: " + Days + " days for a Economy @ $" + Econ + " per day:   $" + (Days*Econ));
			System.out.println("Club Member Discount: " + "                     " + " -$" + Discount);
            System.out.println("Platinum Executive Package:                 +$" + platexecAdd);
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                " + " $" + totalEst);

            
		}
		else if(carType == 2&&clubMember == 1&&platexecPack == 1) {
            
            
            Discount = (Days/7);
			Discount = (Discount*Comp);
            platexecAdd = (double)(Days*Comp)*platExec;
            totalEst = (double)(Days*Comp) - (double)Discount + platexecAdd;
			
			System.out.println("Base: " + Days + " days for a Compact @ $" + Comp + " per day:   $" + (Days*Comp));
			System.out.println("Club Member Discount: " + "                     " + " -$" + Discount);
            System.out.println("Platinum Executive Package:                 +$" + platexecAdd);
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                " + " $" + totalEst);

            
		}
		else if(carType == 3&&clubMember == 1&&platexecPack == 1) {
            
            
            Discount = (Days/7);
			Discount = (Discount*Stan);
            platexecAdd = (double)(Days*Stan)*platExec;
            totalEst = (double)(Days*Stan) - (double)Discount + platexecAdd;
			
			System.out.println("Base: " + Days + " days for a Standard @ $" + Stan + " per day:   $" + (Days*Stan));
			System.out.println("Club Member Discount: " + "                     " + " -$" + Discount);
            System.out.println("Platinum Executive Package:                 +$" + platexecAdd);
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                " + " $" + totalEst);

            
		}
		else if(carType == 1&&clubMember == 0) {

            totalEst = (Days*Econ);
			
			System.out.println("Base: " + Days + " days for a Economy @ $" + Econ + " per day:   $" + (Days*Econ));
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                  " + " $" + (int)totalEst);
			
		}
		else if(carType == 2&&clubMember == 0) {

            totalEst = (Days*Comp);
			
			System.out.println("Base: " + Days + " days for a Compact @ $" + Comp + " per day:   $" + (Days*Comp));
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                  " + " $" + (int)totalEst);
			
		}
		else if(carType == 3&&clubMember == 0) {

            totalEst = (Days*Stan);
			
			System.out.println("Base: " + Days + " days for a Standard @ $" + Stan + " per day:   $" + (Days*Stan));
            System.out.println(" ");
            System.out.print("Total Estimate for Rental: " + "                  " + " $" + (int)totalEst);
			
		}
		
		return;
	}

}
