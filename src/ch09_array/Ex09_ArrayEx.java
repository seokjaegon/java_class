package ch09_array;

import java.util.Scanner;

public class Ex09_ArrayEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentNum;
        int[] score = null;

        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("1.학생수입력 | 2.점수입력 | 3.점수목록 | 4.분석 | 5.종료");
            System.out.println("---------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if(select == 1) {
                System.out.print("학생수>");
                studentNum = scanner.nextInt();
                score = new int[studentNum];
            } else if (select == 2) {
                for (int i = 0; i < score.length; i++) {
                    System.out.print((i+1)+"번 학생 점수: ");
                    score[i] = scanner.nextInt();
                }
            } else if (select == 3) {
                for (int i = 0; i < score.length; i++) {
                    System.out.println((i + 1) + "번 학생 점수: " + score[i]);
                }
            } else if (select == 4) {
                int min = 0;
                int sum = 0;
                for(int i =0; i< score.length; i++) {
                    sum+=score[i];
                    for(int j = i+1; j < score.length; j++){
                        if (score[i] < score[j]) {
                            min = score[i];
                            score[i] = score[j];
                            score[j] = min;
                        }
                    }
                }
                System.out.println("최고점수: "+ score[0]);
                System.out.println("평균점수: "+ (double)(sum/score.length));
                for (int i = 0; i < score.length; i++){
                    System.out.println((i+1)+"등: "+score[i]);
                }
            } else if (select == 5) {
                System.out.println("종료");
                break;
            }
        }
    }
}
