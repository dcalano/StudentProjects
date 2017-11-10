import java.util.Scanner;

public class Calculator {

	public static Scanner numInput;
	public static Scanner doubleInput;
	public static Scanner stringInput;

	public static void main(String[] args) {
		
		// Initialize scanners
		numInput = new Scanner(System.in);
		doubleInput = new Scanner(System.in);
		stringInput = new Scanner(System.in);



		String doMoreMath = "no";
		do {
			System.out.println("What kind of math would you like to do; basic math, trigonometry, or exponentials");
			String mathType = stringInput.nextLine();

			if (mathType.toLowerCase().equals("basic math")) {
				doBasicMath();
			} else if (mathType.toLowerCase().equals("trigonometry")) {
				doTrigonometry();
			} else if (mathType.toLowerCase().equals("exponentials")) {
				doExponentialMath();
			} else {
				System.out.println("You entered an invalid option.");
			}

			// Ask user if they want to do more math or quit
			System.out.println("Would you like to do another problem?");
			doMoreMath = stringInput.nextLine();
		} while (doMoreMath.toLowerCase().equals("yes"));


		numInput.close();
		doubleInput.close();
		stringInput.close();
	}

	public static void doBasicMath() {
		// ask user for operation
		System.out.println("what do you want to do; addition, subtraction, division, or multiplication");
		String type = stringInput.nextLine();

		// ask user for amount of numbers
		System.out.println("how many numbers would you like to have");
		int num = numInput.nextInt();
		double numberarray[] = new double[num];

		// ++ ( add 1), -- (subtract 1)
		for(int g = 0; g < num; g++) {
			System.out.print("Give me the number for position " + g + ": ");
			numberarray[g] = doubleInput.nextDouble();
			if (numberarray[g] == 0) {
				g--;
			}
		}
		

		double finalAnswer = 0;
		if (type.equals("addition")) {
			for(int g = 0; g < num; g++) {
				finalAnswer += numberarray[g];
			}
		} else if (type.equals("subtraction")) {
			for(int g = 0; g < num; g++) {
				finalAnswer -= numberarray[g];
			}
		} else if (type.equals("multiplication")) {
			finalAnswer = 1;
			for(int g = 0; g < num; g++) {
				finalAnswer *= numberarray[g];
			}
		} else if (type.equals("division")) {
			finalAnswer = numberarray[0];
			for(int g = 1; g < num; g++)
				finalAnswer /= numberarray[g];
		} else {
			System.out.println("Not valid");
		}

		System.out.println("Your answer is: " + finalAnswer);
	}

	public static void doTrigonometry() {
		boolean reAsk = false;
		
		do {
			System.out.println("Would you like to find a cosine, sine, or tangent?");
			String type = stringInput.nextLine();

			if (type.toLowerCase().equals("cosine")) {
				System.out.println("What angle would you like to find the cosine of?");
				double angle = doubleInput.nextDouble();

				double cosine = Math.cos(angle);
				System.out.println("The angle " + angle + " has a cosine of " + cosine);
			} else if (type.toLowerCase().equals("sine")) {
				System.out.println("What angle would you like to find the sine of?");
				double angle = doubleInput.nextDouble();
				
				double sine = Math.sin(angle);
				System.out.println("The angle " + angle + " has a sine of " + sine);
			} else if (type.toLowerCase().equals("tangent")) {
				System.out.println("What angle would you like to find the tangent of?");
				double angle = doubleInput.nextDouble();

				double tangent = Math.tan(angle);
				System.out.println("The angle " + angle + " has a tangent of " + tangent);
			} else {
				System.out.println("Invalid option, choose again");
				reAsk = true;
			}
		} while (reAsk == true);
	}

	public static void doExponentialMath() {
		System.out.println("Would you like to find a square root, a logarithm, or an exponent?");
		String type = stringInput.nextLine();

		boolean reAsk = false;
		do {
			if (type.toLowerCase().equals("square root")) {
				System.out.println("What number would you like to get the square root of?");
				double number = doubleInput.nextDouble();

				double ans = Math.sqrt(number);
				// Display answer
				System.out.println("The square root of " + number + " is " + ans);
			} else if (type.toLowerCase().equals("logarithm")) {
				System.out.println("What base would you like to find the natural log of?");
				double number = doubleInput.nextDouble();

				double ans = Math.log(number);
				System.out.println("The natural logarithm of " + number + "is " + ans);
			} else if (type.toLowerCase().equals("exponent")) {
				System.out.println("What base would you like to use?");
				double base = doubleInput.nextDouble();

				System.out.println("What power would you like to raise it to?");
				double exponent = doubleInput.nextDouble();

				double ans = Math.pow(base, exponent);
				System.out.println("Display answer");
				System.out.println(ans);

				// Print answer
				System.out.println("The base " + base + " raised to the " + exponent + " power is " + ans);
			} else {
				System.out.println("Invalid option, choose again");
				reAsk = true;
			}
		} while (reAsk == true);
	}
}
