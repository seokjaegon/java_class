package ch11_classes.ex01;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentNum;
        // StudentService 클래스 객체 선언
        StudentService studentService = new StudentService();


        while (true) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.method1 호출 | 2.method2 호출 | 3.method3 호출 | 4.methode4 호출 | 5.method 호출 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                System.out.println("메서드 호출 전");
                studentService.method1();
                System.out.println("메서드 호출 후");
            } else if (select == 2) {
                studentService.method2();
            } else if (select == 3) {
                studentService.method3();
            } else if (select == 4) {
                studentService.method4();
            } else if (select == 5) {
                studentService.method5();
            } else if (select == 0) {
                break;
            }
        }
    }
}
