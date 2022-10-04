import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		System.out.print("Enter Equation: ");
		Scanner input = new Scanner(System.in);
		String equation = input.nextLine();
		int length = equation.length();
		ArrayList numbers = new ArrayList<>();
		ArrayList operators = new ArrayList<>();
		equation = equation + " ";

		for (int i = 0; i < length; i++) {
			if ((i <= length - 1)) {
				if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1)) && isDigit(equation.charAt(i + 2))
						&& isDigit(equation.charAt(i + 3)) && isDigit(equation.charAt(i + 4))
						&& isDigit(equation.charAt(i + 5)) && isDigit(equation.charAt(i + 6))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3) + "" + equation.charAt(i + 4) + "" + equation.charAt(i + 5) + ""
							+ equation.charAt(i + 6);
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 6;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2))
						&& isDigit(equation.charAt(i + 3)) && isDigit(equation.charAt(i + 4))
						&& isDigit(equation.charAt(i + 5))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3) + "" + equation.charAt(i + 4) + "" + equation.charAt(i + 4);
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 5;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2))
						&& isDigit(equation.charAt(i + 3)) && isDigit(equation.charAt(i + 4))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3) + "" + equation.charAt(i + 4);
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 4;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2)) && isDigit(equation.charAt(i + 3))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2) + ""
							+ equation.charAt(i + 3);
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 3;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))
						&& isDigit(equation.charAt(i + 2))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1) + "" + equation.charAt(i + 2);
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 2;
				} else if (isDigit(equation.charAt(i)) && isDigit(equation.charAt(i + 1))) {
					String temp = equation.charAt(i) + "" + equation.charAt(i + 1);
					int toInt = Integer.parseInt(temp);
					numbers.add(toInt);
					i = i + 1;
				} else if (isDigit(equation.charAt(i))) {
					numbers.add(equation.charAt(i) - '0');
				} else {
					operators.add(equation.charAt(i));
				}

			}
		}

		int result = 0;
		int num = 0;
		ArrayList patternNUM = new ArrayList<>();
		ArrayList patternOP = new ArrayList<>();
		for (int t = 0; t < operators.size(); t++) {
			char oper = (char) operators.get(t);
			if (oper == '*') {
				int ans = (int) numbers.get(num) * (int) numbers.get(num + 1);
				patternNUM.add(ans);
				num++;
			} else {
				patternNUM.add(numbers.get(num));
				patternOP.add(operators.get(t));
			}
			num++;
		}
		result = result + (int) numbers.get(0);

		for (int t = 0; t < patternOP.size(); t++) {
			char oper = (char) patternOP.get(t);
			if (oper == '-') {
				result = result - (int) patternNUM.get(t + 1);
			} else if (oper == '+') {
				result = result + (int) patternNUM.get(t + 1);
			}
		}

		System.out.println(result);

	}

	static boolean isDigit(char check) {
		if (Character.isDigit(check)) {
			return true;
		}
		return false;
	}

}
