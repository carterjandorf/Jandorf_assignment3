package jandorf_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	
	Scanner input = new Scanner(System.in);
	
	// Create SecureRandom Object
	SecureRandom r = new SecureRandom();

	public static void main(String[] args) {
		

			CAI4 test = new CAI4();
			test.quiz();

	}
	
	public void quiz() {
		
		// Create variable to keep looping
		int x = 0;
		
		// Declare temp hold locations
		int num1;
		int num2;
		
		// Create a score variable
		float tally = 0;
		float score;
		
		System.out.println("Enter a difficulty level 1-4: ");
		int dif = readDifficulty();
		
		do {
			
	    num1 = generateQuestionArgument(dif);
	    num2 = generateQuestionArgument(dif);
		
	    // Ask the Question
		askQuestion(num1,num2);
		
		// Read the Response
		int val = readResponse();
		
		// Generate response picker
		int res = 1 + r.nextInt(4);
		
		// Check if the answer is correct
		if(isAnswerCorrect(num1,num2,val) == 0) {
			displayIncorrectResponse(res);
		} else if(isAnswerCorrect(num1,num2,val) == 1) {
			displayCorrectResponse(res);
			tally++;
		}
		
		x++;
		
		if(x == 10) {
			
			score = (tally/10) * 100;
			
			if(score < 75) {
				System.out.println("Please ask your teacher for extra help.");
				
				System.out.println("\nEnter a difficulty level 1-4: ");
				dif = readDifficulty();
				
			} else {
				System.out.println("Congratulations, you are ready to go to the next level!");
				
				System.out.println("\nEnter a difficulty level 1-4: ");
				dif = readDifficulty();
			}
			
			x = 0;
		}
		
		} while(x < 10);
		
		
		
		
	}
	
	public void askQuestion(int n1, int n2) {
		
		System.out.println("How much is " + n1 + " times " + n2 + "?");
		
	}
	
	public int readDifficulty() {
		int difficulty = input.nextInt();
		return difficulty;
	}
	
	public int generateQuestionArgument(int level) {
		int num;
		if(level == 1) {
			num = 0 + r.nextInt(10); 
		} else if (level == 2) {
			num = 0 + r.nextInt(100);
		} else if (level == 3) {
			num = 0 + r.nextInt(1000);
		} else {
			num = 0 + r.nextInt(10000);
		}
		
		return num;
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
	
	public void displayCorrectResponse(int response) {
		
		switch(response) {
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice Work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
			
		}
		
		
	}
	
	public void displayIncorrectResponse(int response) {
		
		switch(response) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
		
	}

}
