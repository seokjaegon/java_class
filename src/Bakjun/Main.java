package Bakjun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int M = scanner.nextInt();
        int time = 0;
        int min = 0;

        if (M < 45) {
            if (H == 0) {
                time = 23;
            } else {
                time = H-1;
            }
            min = M-H;
        } else {
            min = M-45;
        }
        System.out.print(time+" ");
        System.out.println(min);

    }

}
