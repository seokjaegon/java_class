package ch10_class.ex11;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        /**
         * 메뉴
         * 1. 글작성(매개변수 있는 생성자이용)
         *      글작성 정보는 스캐너로 받음. 글번호도 같이 입력함.
         * 2. 글조회
         *      글번호를 입력 받고 Board 클래스의 findById로 글번호를 넘긴다.
         * 3. 종료
         */
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        int select = 0;
        while (true) {
            System.out.println("----------------------------");
            System.out.println("1.글작성 | 2.글조회 | 3.종료");
            System.out.println("-----------------------------");
            System.out.print("선택>");
            select = scanner.nextInt();

            if (select == 1) {
                System.out.print("글번호: ");
                long id = scanner.nextLong();
                System.out.print("제목: ");
                String boardTitle = scanner.next();
                System.out.print("작성자: ");
                String boardWriter = scanner.next();
                System.out.print("내용: ");
                String boardContents = scanner.next();
                // 생성자에 넘겨준다.
                board = new Board(id, boardTitle, boardWriter, boardContents);
                board.setId(id);
                board.setBoardTitle(boardTitle);
                board.setBoardWriter(boardWriter);
                board.setBoardContents(boardContents);
            } else if (select == 2) {
                System.out.print("찾을 글번호: ");
                Long search_id = scanner.nextLong();
                board.findById(search_id);
            } else if (select == 3) {
                break;
            }
        }
    }
}
