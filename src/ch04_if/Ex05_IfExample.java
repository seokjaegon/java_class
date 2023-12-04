package ch04_if;

import java.util.Scanner;

public class Ex05_IfExample {

	public static void main(String[] args) {
		/**
		 * 정수 하나를 입력 받아서 양수, 음수, 0인지를 출력
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하시오: ");
		int num1 = scanner.nextInt();
		
		if(num1 == 0) {
			System.out.println("0");
		} else if (num1 > 0) {
			System.out.println("양수");
		} else { //else if (num1 <0)
			System.out.println("음수");
		}
	}

}
