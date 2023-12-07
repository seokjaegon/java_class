package ch07_while;

import java.util.Scanner;

public class Ex08_WhileEx {
    public static void main(String[] args) {
        /**
         * 은행(예금, 출금, 잔고, 종료) 예제
         *
         * 1.예금 2.출금 3.잔고 4.종료 에서 선택
         *
         * 예금 입력 예제)
         * 선택> 1
         * 예금액> 10000
         * 출력 예제)
         * 현재잔액은 10000입니다.
         */

        Scanner scanner = new Scanner(System.in);
        int total_money = 0;
        while(true) {
            System.out.println("--------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("--------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                // 예금
                System.out.print("예금액>");
                int deposit = scanner.nextInt();
                total_money += deposit;
                System.out.println("현재잔액은 "+total_money+"입니다.");
            } else if(select == 2) {
                // 출금
                System.out.print("출금액>");
                int withdraw = scanner.nextInt();
                if(withdraw > total_money) {
                    System.out.println("잔고가 부족합니다.");
                    System.out.println("현재잔액은 "+total_money+"입니다.");
                } else {
                    // withdraw <= total_money
                    total_money -= withdraw;
                    System.out.println("현재잔액은 "+total_money+"입니다.");
                }
            } else if (select == 3) {
                // 잔고
                System.out.println("현재잔액은 "+total_money+"입니다.");
            } else if (select == 4) {
                // 종료
                System.out.println("종료합니다.");
                break;
            } else {
                // 잘못 선택했을 때
                System.out.println("잘못 선택하셨습니다. 다시 선택해주세요.");
            }
        }
    }
}
