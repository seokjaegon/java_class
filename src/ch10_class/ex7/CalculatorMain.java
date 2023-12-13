package ch10_class.ex7;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {

        /**
         * 실행하면 반복문으로 메뉴를 출력
         * 1.덧셈  2.뺄셈  3.곱셈  4.나눗셈
         * 각 번호를 선택하면 Calculator 클래스에 있는 해당 메서드를 호출하여 결과를 출력함
         */
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
            System.out.println("-------------------------------------------");
            System.out.print("선택>");
            int select = scanner.nextInt();
            if (select == 1) {
                System.out.print("첫번째 숫자: ");
                int num1 = scanner.nextInt();
                System.out.print("첫번째 숫자: ");
                int num2 = scanner.nextInt();
                calculator.sum(num1, num2);
            } else if (select == 2) {
                System.out.print("첫번째 숫자: ");
                int num1 = scanner.nextInt();
                System.out.print("첫번째 숫자: ");
                int num2 = scanner.nextInt();
                calculator.sub(num1, num2);
            } else if (select == 3) {
                System.out.print("첫번째 숫자: ");
                int num1 = scanner.nextInt();
                System.out.print("첫번째 숫자: ");
                int num2 = scanner.nextInt();
                int result = calculator.mul(num1, num2);
                System.out.println("result= "+result);
            } else if (select == 4) {
                int result = calculator.div();
                System.out.println("result = " + result);
            } else {
                break;
            }
        }
    }

}
