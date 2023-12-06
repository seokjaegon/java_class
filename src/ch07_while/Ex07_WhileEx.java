package ch07_while;

public class Ex07_WhileEx {
    public static void main(String[] args) {
        /**
         * 1 + (-2) + 3 + (-4) + 5 + (-6) ~~~~
         * 처럼 계산을 했을 때 합계가 100이 됐을 때의 숫자를 출력
         * 정답 : 199
         */
        // 합계용 변수
        int sum = 0;
        // 1, -2, 3, -4, 5, -6~~
        int i = 0;
        while (true) {
            i++;
            if(i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
            if (sum == 100) {
                System.out.println("정답 : " + i);
                break;
            }
        }
//        int sum = 0;
//        int cnt = 1;
//        int s = 1;
//        int num = 0;
//
//        while (true) {
//            sum += num;
//            if(sum >= 100) {
//                System.out.println(num);
//                break;
//            } else {
//                num = s * cnt;
//                s = -s;
//                cnt++;
//            }
//        }
    }
}
