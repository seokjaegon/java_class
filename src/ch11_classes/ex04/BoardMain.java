package ch11_classes.ex04;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1.글작성 | 2.글목록 | 3.글조회 | 4.글수정 | 5.글삭제 | 6.검색 | 0.종료");
            System.out.println("------------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if(select == 1) {
                boardService.save();
            } else if (select == 2) {
                boardService.findAll();
            } else if (select == 3) {
                boardService.findById();
            } else if (select == 4) {
                boardService.update();
            } else if (select == 5) {
                boardService.delete();
            } else if (select == 6) {
                boardService.search();
            } else if (select == 0) {
                break;
            }
        }
    }
}
