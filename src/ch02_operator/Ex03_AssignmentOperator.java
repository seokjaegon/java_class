package ch02_operator;

public class Ex03_AssignmentOperator {

	public static void main(String[] args) {
		int num1 = 10, num2 = 7;
		// 출력코드 단축키 : 1. sysout 입력 2. ctrl+space
		System.out.println("num1: " + num1 + " num2: " + num2); 
		// 대입연산자 활용
		num1 += num2; // num1 = num1 + num2;
		System.out.println("num1: " + num1 + " num2: " + num2); // num1: 17, num2: 7
		num1 += num2; // num1 = num1 + num2;
		System.out.println("num1: " + num1 + " num2: " + num2); // num1: 24, num2: 7
		num1 -= num2; // num1 = num1 - num2;
		System.out.println("num1: " + num1 + " num2: " + num2); // num1: 17, num2: 7
		num1 *= num2; // num1 = num1 * num2;
		System.out.println("num1: " + num1 + " num2: " + num2); // num1: 119, num2: 7
		num1 /= num2; // num1 = num1 / num2;
		System.out.println("num1: " + num1 + " num2: " + num2); // num1: 17, num2: 7
	}

}
