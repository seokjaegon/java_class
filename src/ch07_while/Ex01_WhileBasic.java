package ch07_while;

public class Ex01_WhileBasic {
    public static void main(String[] args) {
        // 1 ~ 3까지 출력
        // int i = 1 -> X (for문에서 중복으로 선언되었으므로 에러발생)
        for (int i = 1; i <=3 ; i++) { // int i -> 지역변수
            System.out.println("i = " + i);
        }
        System.out.println();

        int i = 1; // int i -> 전역변수
        while(i <= 3) {
            System.out.println("i = " + i);
            i++;
        }
        System.out.println("while 종료 후 i = " + i);
        System.out.println();

        int j = 10;
        do {
            System.out.println("j = " + j);
            j++;
        } while (j <= 3);
        System.out.println("do while 종료 후 j = " + j);

        // 무한반복
        int k =1;
        while(true) {
            System.out.println("무한반복~~"+k);
            k++;
            if (k==3){
                break; // 코드 중단용(즉시 중단)
            }
            System.out.println("break 다음 문장");
        }

        int l = 1;
        boolean run = true;
        while(run) {
            System.out.println("l = " + l);
            l++;
            if (l == 3) {
                run = false; // = break; (마지막까지 다 돌고 중단)
            }
            System.out.println("run=false 다음 문장");
        }
    }
}
