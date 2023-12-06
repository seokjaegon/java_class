package ch07_while;

import java.util.Scanner;

public class Ex05_WhileEx {
    public static void main(String[] args) {
        /**
         * random() 메서드를 이용해서 1~100 사이의 숫자를 하나 만들고
         * 반복문 안에서 해당 숫자를 맞출 때까지 계속 숫자를 입력받도록 하고
         * 숫자를 맞추면 종료하고 몇 번만에 맞췄는지를 출력해줌
         */

        Scanner scanner = new Scanner(System.in);
        int num1 = (int)(Math.random()*100)+1;

        int cnt = 0;
        while (true) {
            System.out.print("1부터 100까지의 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            if(num2 == num1) {
                System.out.println("맞췄습니다.");
                cnt++;
                System.out.println("시도 횟수는 "+cnt+"회 입니다.");
                break;
            } else if (num2 < num1) {
                System.out.println("더 큰 수를 입력하세요.");
                cnt++;
            } else {
                System.out.println("더 작은 수를 입력하세요.");
                cnt++;
            }
        }
    }
}
