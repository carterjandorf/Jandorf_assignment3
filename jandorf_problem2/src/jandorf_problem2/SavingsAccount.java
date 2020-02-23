package jandorf_problem2;

public class SavingsAccount {
	
	
	
	private static double annualInterestRate;
	
	private double savingsBalance;
	
	SavingsAccount() {
		
	}
	
	SavingsAccount(double balance) {
		this.savingsBalance = balance;
	}
	
	public void calculateMonthlyInterest() {
		 savingsBalance += savingsBalance * annualInterestRate / 12;
	}
	
	public static void modifyInterestRate(double interest) {
		annualInterestRate = interest;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	

}
