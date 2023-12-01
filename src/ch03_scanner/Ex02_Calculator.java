package ch03_scanner;

import java.util.Scanner;

public class Ex02_Calculator {

	public static void main(String[] args) {
		/**
		 * 정수 2개를 각각 스캐너로 num1, num2에 입력받아서 수의 합을 출력하세요.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수: ");
		int num1 = scanner.nextInt();
		System.out.print("두번째 수: ");
		int num2 = scanner.nextInt();
		
		int sum = num1 + num2;
		System.out.println("합: " + sum);
	}

}
