package ch06_for;

public class Ex11_ForEx {
    public static void main(String[] args) {
        /**
         * 별찍기
         * 출력
         * *
         * **
         * ***
         * ****
         * *****
         *     * 1-1 i, 2i-1 1-4 i, i+3
         *    *** 2-3 i,      2-3 i, i+1
         *   ***** 3-5 i, i+2  3-2 i, i-1
         *  ******* 4-7 i, i+3  4-1
         * *********             5-0
         */
//        for (int i = 1; i <= 5; i++) { // 줄수, 별을 출력할 횟수
//            for (int j = 1 ; j <= i; j++) { // 별을 줄수만큼 출력
//                System.out.print("*");
//            }
//            System.out.println(); // 줄을 바꾸기 위한 용도
//        }

        for (int i =1; i <= 5; i++) {
            for (int j = 1; j < -i+5; j++) {
                System.out.print(" ");
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
