import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Welcome to the simple java calculator.");
		boolean quit = false;
		Scanner input = new Scanner(System.in);

		while (!quit) {
			System.out.println("Enter Equation: or 'quit' to quit ");
			String equation = input.nextLine();
			int length = equation.length();
			ArrayList numbers = new ArrayList<>(); // arraylist to store numbers
			ArrayList operators = new ArrayList<>(); // arraylist to store operators
			equation = equation + " "; // incase something went wrong

			if (equation.equalsIgnoreCase("quit ")) {
				System.out.println("Goodbye.");
				quit = true;
			} else {

				if (validate(equation, length) == true) {
					int result = compute(equation, length, operators, numbers);
					System.out.println(result);

				} else if (validate(equation, length) != true) {
					System.out.print("Sorry, that is not a valid equation.\nPlease try again:");
				}
			}
		}
	}

	static int compute(String equation, int length, ArrayList operators, ArrayList numbers) {
		for (int i = 0; i < length; i++) { // set the string into arraylist
			if ((i <= length - 1)) { // check are we at the end
				if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1)) && isDigit(equation.charAt(i + 2))
						&& isDigit(equation.charAt(i + 3)) && isDigit(equation.charAt(i + 4))
						&& isDigit(equation.charAt(i + 5)) && isDigit(equation.charAt(i + 6))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3) + "" + equation.charAt(i + 4) + "" + equation.charAt(i + 5) + ""
							+ equation.charAt(i + 6); // check is it a 7 digit number
					int toInt = Integer.parseInt(temp); // make it into a int from string
					numbers.add(toInt); // add to arraylist
					i = i + 6;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2))
						&& isDigit(equation.charAt(i + 3)) && isDigit(equation.charAt(i + 4))
						&& isDigit(equation.charAt(i + 5))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3) + "" + equation.charAt(i + 4) + "" + equation.charAt(i + 4);
					int toInt = Integer.parseInt(temp); // check is it a 6 digit number
					numbers.add(toInt);
					i = i + 5;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2))
						&& isDigit(equation.charAt(i + 3)) && isDigit(equation.charAt(i + 4))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3) + "" + equation.charAt(i + 4);
					int toInt = Integer.parseInt(temp); // check is it a 5 digit number
					numbers.add(toInt);
					i = i + 4;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2)) && isDigit(equation.charAt(i + 3))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3); // check is it a 4 digit number
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 3;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2);
					int toInt = Integer.parseInt(temp); // check is it a 3 digit number
					numbers.add(toInt);
					i = i + 2;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1);
					int toInt = Integer.parseInt(temp); // check is it a 2 digit number
					numbers.add(toInt);
					i = i + 1;
				} else if (isDigit(equation.charAt(i))) {
					numbers.add(equation.charAt(i) - '0'); // check is it a 1 digit number
				} else {
					operators.add(equation.charAt(i)); // else should be an operator
				}
			}

		}

		int result = 0; // set result
		int count = 0; // set count
		while (count < operators.size()) { // while opertor not finish
			char oper = (char) operators.get(count); // get the operator
			if (oper == '*') { // check equal to * or not
				int ans = (int) numbers.get(count) * (int) numbers.get(count + 1); // get the answer
				numbers.set(count + 1, ans); // set back the answer, e.g.3*4 it set back into 4's place
				numbers.remove(count); // remove the last digit in the list, e.g.3*4 will remove 3
				operators.remove(count); // remove * operator
			} else {
				count++; // add 1 to count (only do it in here because in the if when you remove is the
							// same with count--)
			}
		}
		result = result + (int) numbers.get(0); // input first number in the list as result

		for (int t = 0; t < operators.size(); t++) {
			char oper = (char) operators.get(t);
			if (oper == '-') { // check is the operator '-'
				result = result - (int) numbers.get(t + 1);
			} else if (oper == '+') { // check is the operator '+'
				result = result + (int) numbers.get(t + 1);
			}
		}

		return result; // return result back to main
	}

	static boolean validate(String equation, int length) {
		String character = "";
		char curr = '0';
		int opCount = 0;
		boolean valid = true;
		for (int i = 0; i < length; i++) {
			curr = equation.charAt(i);
			if (isDigit(curr)) {
				character = "num";
			} else if (curr == '+' || curr == '-' || curr == '*') {
				character = "op";
			} else {
				return false; // false if non-numeric / operator characters entered
			}

			switch (character) {
				case "num":
					opCount = 0;
					break;
				case "op":
					opCount++;
					if (opCount > 1 || i == 0) { // false if more than 1 operators in a row or starts with operator
						return false;
					}
					break;

			}

		}
		return valid;
	}

	static boolean isDigit(char check) {
		if (Character.isDigit(check)) {
			return true;
		}
		return false;
	}

}
