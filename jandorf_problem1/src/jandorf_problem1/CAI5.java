package jandorf_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {

	Scanner input = new Scanner(System.in);

	// Create SecureRandom Object
	SecureRandom r = new SecureRandom();

	public static void main(String[] args) {


		CAI5 test = new CAI5();
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

		System.out.println("Enter 1-5 for problem type: ");
		int type = readProblemType();

		do {

			int typ = type;

			if (type == 5) {
				typ = 1 + r.nextInt(4);
			}

			num1 = generateQuestionArgument(dif);
			num2 = generateQuestionArgument(dif);

			// Ask the Question
			askQuestion(num1,num2,typ);

			// Read the Response
			int val = readResponse();

			// Generate response picker
			int res = 1 + r.nextInt(4);

			// Check if the answer is correct
			if(isAnswerCorrect(num1,num2,val,typ) == 0) {
				displayIncorrectResponse(res);
			} else if(isAnswerCorrect(num1,num2,val,typ) == 1) {
				displayCorrectResponse(res);
				tally++;
			}

			x++;

			if(x == 10) {

				score = (tally/10) * 100;

				System.out.println();
				displayCompletionMessage(score);

				System.out.println("Do you want to create a new problem set? Enter 1 (yes) or 0 (no): ");
				int yesorno = input.nextInt();

				if(yesorno == 1) {
					System.out.println("\nEnter a difficulty level 1-4: ");
					dif = readDifficulty();

					System.out.println("\nEnter 1-5 for problem type: ");
					type = readProblemType();

					x = 0;
					tally = 0;
				} else {
					System.exit(0);
				}
			}

		} while(x < 10);




	}

	public void askQuestion(int n1, int n2, int type) {

		if(type == 1) {
			System.out.println("How much is " + n1 + " plus " + n2 + "?");
		} else if(type == 2) {
			System.out.println("How much is " + n1 + " times " + n2 + "?");
		} else if(type == 3) {
			System.out.println("How much is " + n1 + " minus " + n2 + "?");
		} else if(type == 4) {
			System.out.println("How much is " + n1 + " divided by " + n2 + "?");
		}


	}

	public int readDifficulty() {
		int difficulty = input.nextInt();
		return difficulty;
	}

	public int readProblemType() {
		int type = input.nextInt();
		return type;
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

	public int isAnswerCorrect(int n1, int n2, int answer, int type) {

		int flag = 0;

		if(type == 1) {
			if(answer == (n1 + n2)) {
				flag = 1;
			}
		} else if(type == 2) {
			if(answer == (n1 * n2)) {
				flag = 1;
			}
		} else if(type == 3) {
			if(answer == (n1 - n2)) {
				flag = 1;
			}
		} else if(type == 4) {
			if(answer == (n1 / n2)) {
				flag = 1;
			}
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

	public void displayCompletionMessage(float score) {

		System.out.println("Your score is " + score + "%.");

		if(score < 75) {
			System.out.println("Please ask your teacher for extra help.");
		} else {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}

	}

}
