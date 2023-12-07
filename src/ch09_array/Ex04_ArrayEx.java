package ch09_array;

import java.util.Scanner;

public class Ex04_ArrayEx {
    public static void main(String[] args) {
        int num[] = {5, 2, 1, 3, 4, 7, 6, 9, 10, 8};
        /**
         * 위와 같은 배열이 있을 때 1~10 사이의 숫자 중에서 하나를
         * 입력했을 때 그 숫자가 몇 번 인덱스에 있는지 출력
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자: ");
        int check = scanner.nextInt();

        for (int i=0; i< num.length; i++) {
            if(check == num[i]) {
                System.out.println(check+"는 "+i+" 번 인덱스에 있습니다.");
            }
        }
//        while (true) {
//            System.out.print("숫자: ");
//            int check = scanner.nextInt();
//            if (check < 0 || check > 10) {
//                System.out.println("숫자를 다시 입력하시오.");
//            } else {
//                for (int i = 0; i < num.length; i++) {
//                    if (check == num[i]) {
//                        System.out.println(check + "는 " + i + " 번 인덱스에 있습니다.");
//                    }
//                }
//                break;
//            }
//        }
    }
}
