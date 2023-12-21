package Bakjun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            for (int j = T; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
