package ch11_classes.ex01;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentNum;


        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("1.method1 호출 | 2.method2 호출 | 3.method3 호출 | 4.종료");
            System.out.println("---------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {

            } else if (select == 2) {

            } else if (select == 3) {

            } else if (select == 4) {
                break;
            }
        }
    }
}
