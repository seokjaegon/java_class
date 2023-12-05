package ch06_for;

import java.util.Scanner;

public class Ex05_ForEx {
    public static void main(String[] args) {
        /**
         * 두개의 정수를 입력받아서 시작값부터 끝값까지의 합계 출력
         * 입력 예
         * 시작값 : 110
         * 끝값 : 555
         * 출력 예
         * 110 부터 555 까지의 합은 000입니다.
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("시작값:");
        int num1 = scanner.nextInt();
        System.out.print("끝값:");
        int num2 = scanner.nextInt();

        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += i;
        }
        System.out.println(num1 + " 부터 " + num2 + " 까지의 합은 " + sum + " 입니다.");
    }
}
