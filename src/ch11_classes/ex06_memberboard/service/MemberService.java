package ch11_classes.ex06_memberboard.service;

import ch11_classes.ex04_board.BoardDTO;
import ch11_classes.ex06_memberboard.common.commonVariables;
import ch11_classes.ex06_memberboard.dto.MemberDTO;
import ch11_classes.ex06_memberboard.repository.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        String memberEmail = null;
        MemberDTO memberDTO = null;
        System.out.println("회원가입 메뉴");
        do {
            System.out.print("이메일: ");
            memberEmail = scanner.next();
            memberDTO = memberRepository.emailCheck(memberEmail);
            if(memberDTO == null) {
                System.out.println("사용 가능한 이메일 입니다.");
            } else {
                System.out.println("이미 사용 중인 이메일 입니다. 다른 이메일을 입력해주세요.");
            }
        } while(memberDTO != null);
        System.out.print("비밀번호: ");
        String memberPassword = scanner.next();
        System.out.print("이름: ");
        String memberName = scanner.next();
        System.out.print("전화번호: ");
        String memberMobile = scanner.next();
        memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
        boolean result = memberRepository.save(memberDTO);
        if (result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }
    }


    public void login() {
        String memberEmail = null;
        MemberDTO memberDTO = null;
        System.out.print("이메일: ");
        memberEmail = scanner.next();
        memberDTO = memberRepository.emailCheck(memberEmail);
        System.out.print("비밀번호: ");
        String memberPassword = scanner.next();
        if(memberDTO != null && memberPassword.equals(memberDTO.getMemberPassword())){
            commonVariables.loginEmail = memberEmail;
            System.out.println(memberDTO.getMemberName()+"님 환영합니다!");
        } else {
            System.out.println("이메일 또는 비밀번호가 틀립니다!");
        }
    }

    public void findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        listPrint(memberDTOList);
    }

    public void update() {
        MemberDTO memberDTO = null;
        if(commonVariables.loginEmail != null){
            System.out.print("수정할 이름: ");
            String memberName = scanner.next();
            System.out.print("수정할 전화번호: ");
            String memberMobile = scanner.next();
            memberDTO = memberRepository.update(commonVariables.loginEmail, memberName, memberMobile);
            if (memberDTO != null) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
        } else {
            System.out.println("로그인을 해주세요.");
        }
    }

    public void delete() {
        if(commonVariables.loginEmail != null){
            System.out.print("확인용 비밀번호: ");
            String memberPassword = scanner.next();
            boolean result= memberRepository.delete(commonVariables.loginEmail, memberPassword);
            if (result) {
                System.out.println("탈퇴 성공");
            } else {
                System.out.println("탈퇴 실패");
            }
        } else {
            System.out.println("로그인을 해주세요.");
        }
    }

    public void logout() {
        if (commonVariables.loginEmail != null) {
            commonVariables.loginEmail =null;
            System.out.println("로그아웃 성공");
        } else {
            System.out.println("로그인을 해주세요.");
        }
    }

    public void board() {
        if (commonVariables.loginEmail != null) {
            BoardService boardService = new BoardService();
            while (true) {
                System.out.println("====== 게시판 ======");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("1.글작성 | 2.글목록 | 3.글조회 | 4.글수정 | 5.글삭제 | 6.검색 | 0.메인메뉴");
                System.out.println("--------------------------------------------------------------------");
                System.out.print("선택> ");
                int select = scanner.nextInt();
                if (select == 1) {
                    boardService.write();
                } else if (select == 2) {
                    boardService.findAll();
                } else if (select == 3) {
                    boardService.find();
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
        } else {
            System.out.println("회원전용 메뉴입니다.");
        }
    }

    private void listPrint(List<MemberDTO> memberDTOList) {
        System.out.println("id\t" + "email\t" + "name\t" + "mobile\t" + "date\t");
        for (MemberDTO memberDTO: memberDTOList) {
            System.out.println(memberDTO.getId() + "\t" + memberDTO.getMemberEmail() +
                    "\t" + memberDTO.getMemberName() + "\t" + memberDTO.getMemberMobile() + "\t"
                    + memberDTO.getCreatedAt() + "\t");
        }
    }
}
