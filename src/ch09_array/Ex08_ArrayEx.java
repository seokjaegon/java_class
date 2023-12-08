package ch09_array;

import java.util.Scanner;

public class Ex08_ArrayEx {
    public static void main(String[] args) {
        /**
         * 스캐너로 입력 받은 숫자의 크기를 갖는 배열을 만들어 봅시다.
         * 예를 들어 5를 입력하면
         * 크기가 5인 배열이 만들어져야 함.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열의 크기를 적으세요: ");
        int num = scanner.nextInt();
        int[] array = new int[num];
        System.out.println("num = " + array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
//        if (num > 0) {
//            int[] array = new int[num];
//            System.out.println("array.length = " + array.length);
//        } else {
//            int[] array = null;
//        }
    }
}
