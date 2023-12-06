package ch07_while;

public class Ex02_whileEx {
    public static void main(String[] args) {
        /**
         * while 문으로 1부터 10까지의 합계 출력
         * 출력
         * 1+2+3+4+5+6+7+8+9+10=55
         */

        int i = 1;
        int sum = 0;
        while (i <= 10) {
            // System.out.print(i);
            sum += i;
            if (i < 10) {
                System.out.print(i+"+"); //System.out.print("+");
            } else {
                System.out.println(i+"="+sum); //System.out.print("=");
            }
            i++;

        }
        //System.out.println(sum);

//        while (i <= 10) {
//            System.out.print(i+"+");
//            sum += i;
//            i++;
//            if (i == 10) {
//                sum += i;
//                System.out.println(i+"="+sum);
//                break;
//            }
//        }
    }
}
