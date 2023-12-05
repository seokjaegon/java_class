package ch06_for;

public class Ex09_ForEx {
    public static void main(String[] args) {
        /**
         * 4x + 5y = 60 을 만족하는 x, y 값을 출력
         * x, y는 1이상 10이하인 정수
         *
         * 출력(정답)
         * 5, 8 10, 4
         */

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if ((4*i) + (5*j) == 60) {
                    System.out.print(i + ", " + j + " ");
                }
            }
        }
    }
}
