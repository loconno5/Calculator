import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.print("Enter equation: ");
		Scanner input = new Scanner(System.in);
		String equation = input.next();
		equation.validString(input);


	public void validString(String input)
	{
		for(int i=0; i<input.length();i++) {
			System.out.println(equation.split("+"));
		}
	}
	

}
}
