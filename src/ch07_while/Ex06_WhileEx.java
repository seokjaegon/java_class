package ch07_while;

import java.util.Scanner;

public class Ex06_WhileEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 갯수용 변수
        int cnt = 0;
        // 합계용 변수
        int sum = 0;

        System.out.println("정수를 입력하고 마지막에 0을 입력하세요 : ");
        while (true) {
            int num = scanner.nextInt();

            if (num == 0) {
                System.out.println("입력한 숫자는" + cnt + "개 입니다.");
                int avg = sum / cnt;
                System.out.println("평균은 " + avg + "입니다.");
                break;
            } else {
                // 합계 계산
                sum += num;
                // 입력된 숫자 갯수 +1
                cnt++;
            }
        }
    }
}
