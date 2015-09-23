package mainPackage;

import java.util.Scanner;

public class Tuition {

	public static void main(String[] args) {
		double initialTuitionCost;
		double percentIncrease;
		double apr;
		double yearsPaying;
		double totalTuition;
		double monthlyPayment;
		
		// Creates an new instance of Scanner.
		Scanner sc = new Scanner(System.in);
		// Asks for the starting tuition and sets it to initialTuitionCost.
		System.out.print("What is the Starting tution cost for this year: ");
		initialTuitionCost = sc.nextDouble();
		// Ask for the percent increase of the tuition and sets it to
		// percentIncrease.
		System.out.print("What is the percentage increase for tuition: ");
		percentIncrease = sc.nextDouble();
		// calculates the total tuition using the calcTotalTuition method and
		// sets it to totalTuition.
		totalTuition = calcTotalTuition(initialTuitionCost, (percentIncrease / 100));
		System.out.printf("Your total tuition is: $%.2f \n", totalTuition);
		// Ask for the APR for your student loan and sets it to apr.
		System.out.print("What is the APR% for your student loan: ");
		apr = sc.nextDouble();
		// Ask for how many years you would like to pay on your student loan for
		// and sets it to yearsPaying
		System.out.print("How many years would you like to pay for: ");
		yearsPaying = sc.nextDouble();
		// Calculate the monthly payment by using the method calcPayments and
		// sets it to monthlyPayments
		monthlyPayment = calcPayments(yearsPaying, apr, totalTuition);
		System.out.printf("You will pay $%.2f a month for %.0f years.", monthlyPayment, yearsPaying);
	}

	// Takes in:
	// initialTuitionCost: the initial tuition when you first enter college.
	// percentIncrease: the percent increase of tuition for each year.
	// returns:
	// The total amount of money you will be owing the school after 4 years.
	public static double calcTotalTuition(double initialTuitionCost, double percentIncrease) {
		double base = initialTuitionCost;
		double current;
		double total = 0;
		for (int i = 1; i <= 3; i++) {
			current = (base * percentIncrease) + base;
			base = current;
			total += current;
		}
		return initialTuitionCost + total;
	}

	//Takes in:
	// Years: The number of years you want to pay your loan off in.
	// apr: The APR of your loan.
	// debt: The total amount of money you owe the school.
	// Returns: The amount of money you will pay monthly for the given time.
	public static double calcPayments(double years, double apr, double debt) {
		double monthlyRate = (apr / 100) / 12;
		return debt * (monthlyRate / (1 - (Math.pow((1 + monthlyRate), -1 * (years * 12)))));

	}

}
