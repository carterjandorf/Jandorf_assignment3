package jandorf_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {

		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(.04);
		
		System.out.println("Saver 1:");
		for(int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			System.out.printf("\nMonth " + (i+1) + ": %.2f",saver1.getSavingsBalance());
		}
		
		System.out.println("\n\nSaver 2:");
		for(int i = 0; i < 12; i++) {
			saver2.calculateMonthlyInterest();
			System.out.printf("\nMonth " + (i+1) + ": %.2f",saver2.getSavingsBalance());
		}
		SavingsAccount.modifyInterestRate(.05);
		
		System.out.println("\n");
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.printf("Saver1\nMonth 13: %.2f \nSaver2\nMonth 13: %.2f", saver1.getSavingsBalance(), saver2.getSavingsBalance());
		
	}

}
