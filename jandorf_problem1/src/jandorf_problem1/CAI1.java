package jandorf_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		

			CAI1 test = new CAI1();
			test.quiz();

	}
	
	public void quiz() {
		// Create SecureRandom Object
		SecureRandom r = new SecureRandom();
		
		// Create variable to keep looping
		int x;
		int correct;
		
		// Declare temp hold locations
		int num1;
		int num2;
		
		do {
		
		x = 0;
		correct = 0;
			
	    num1 = 0 + r.nextInt(10);
	    num2 = 0 + r.nextInt(10);
		
		do {
	    // Ask the Question
		askQuestion(num1,num2);
		
		// Read the Response
		int val = readResponse();
		
		// Check if the answer is correct
		if(isAnswerCorrect(num1,num2,val) == 0) {
			displayIncorrectResponse();
		} else if(isAnswerCorrect(num1,num2,val) == 1) {
			displayCorrectResponse();
			correct = 1;
		}
		} while(correct == 0);
		
		} while(x == 0);
		
		
		
	}
	
	public void askQuestion(int n1, int n2) {
		
		System.out.println("How much is " + n1 + " times " + n2 + "?");
		
	}
	
	public int readResponse() {
		
		int value = input.nextInt();
		return value;
		
	}
	
	public int isAnswerCorrect(int n1, int n2, int answer) {
		
		int flag = 0;
		
		if(answer == (n1 * n2)) {
			flag = 1;
		}
		
		return flag;
		
	}
	
	public void displayCorrectResponse() {
		
		System.out.println("Very good!");
		
	}
	
	public void displayIncorrectResponse() {
		
		System.out.println("No. Please try again.");
		
	}

}
