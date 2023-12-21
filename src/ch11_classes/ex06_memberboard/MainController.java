package ch11_classes.ex06_memberboard;

import ch11_classes.ex06_memberboard.service.MemberService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== 회원관리 ======");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 | 4.회원수정 | 5.회원탈퇴 | 6.로그아웃 | 7.게시판메뉴 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                memberService.save();
            } else if (select == 2) {
                memberService.login();
            } else if (select == 3) {
                memberService.findAll();
            } else if (select == 4) {
                memberService.update();
            } else if (select == 5) {
                memberService.delete();
            } else if (select == 6) {
                memberService.logout();
            } else if (select == 7) {
                memberService.board();
            } else if (select == 0) {
                break;
            }
        }
    }
}
