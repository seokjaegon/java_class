package Bakjun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int time = 0;
        int min = 0;

        if ((B+C) >= 60) {
            time = A+(B+C)/60;
            if (time >= 24) {
                time = time -24;
            }
            min = (B+C)%60;
        } else {
            time = A;
            min = B+C;
        }
        System.out.print(time+" ");
        System.out.println(min);

    }
}
