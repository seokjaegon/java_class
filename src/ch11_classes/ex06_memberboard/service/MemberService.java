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
    public void save() { // 회원 가입 메서드
        String memberEmail = null;
        MemberDTO memberDTO = null;
        System.out.println("회원가입 메뉴");
        do { // 이메일이 이미 존재하면 반복
            // 이메일 작성
            System.out.print("이메일: ");
            memberEmail = scanner.next();
            // 작성한 이메일이 이미 있는지 확인
            memberDTO = memberRepository.emailCheck(memberEmail);
            if(memberDTO == null) { // 이메일이 없으면 출력
                System.out.println("사용 가능한 이메일 입니다.");
            } else { // 이메일이 있으면 출력
                System.out.println("이미 사용 중인 이메일 입니다. 다른 이메일을 입력해주세요.");
            }
        } while(memberDTO != null);
        // 비밀번호, 이름, 전화번호 입력
        System.out.print("비밀번호: ");
        String memberPassword = scanner.next();
        System.out.print("이름: ");
        String memberName = scanner.next();
        System.out.print("전화번호: ");
        String memberMobile = scanner.next();
        // 입력한 이메일, 비밀번호, 이름, 전화번호를 MemberDTO 생성자에 매개변수로 선언
        // MemberDTO를 회원 리스트에 저장
        memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
        boolean result = memberRepository.save(memberDTO);
        if (result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }
    }


    public void login() { // 회원 로그인 메서드
        String memberEmail = null;
        MemberDTO memberDTO = null;
        // 이메일 작성
        System.out.print("이메일: ");
        memberEmail = scanner.next();
        // 입력한 이메일이 있는지 확인
        memberDTO = memberRepository.emailCheck(memberEmail);
        // 비밀번호 작성
        System.out.print("비밀번호: ");
        String memberPassword = scanner.next();
        // 입력한 이메일이 있고 비밀번호가 같은지 확인
        if(memberDTO != null && memberPassword.equals(memberDTO.getMemberPassword())){
            // 맞으면 로그인한 회원의 이메일을 loginEmail에 저장
            commonVariables.loginEmail = memberEmail;
            System.out.println(memberDTO.getMemberEmail()+"님 환영합니다!");
        } else { // 아니면 출력
            System.out.println("이메일 또는 비밀번호가 틀립니다!");
        }
    }

    public void findAll() { // 회원 정보 출력 메서드
        // 모든 회원의 정보를 리스트로 받고 출력
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        listPrint(memberDTOList);
    }

    public void update() { // 회원 정보 수정 메서드
        MemberDTO memberDTO = null;
        // 로그인 상태인지 확인
        if(commonVariables.loginEmail != null){
            // 로그인 상태면 수정할 전화번호 입력
            System.out.print("수정할 전화번호: ");
            String memberMobile = scanner.next();
            // 로그인한 회원의 전화번호를 수정 결과를 받는다.
            memberDTO = memberRepository.update(commonVariables.loginEmail, memberMobile);
            if (memberDTO != null) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
        } else {
            System.out.println("로그인을 해주세요.");
        }
    }

    public void delete() { // 회원 정보 삭제 메서드
        // 로그인 상태인지 확인
        if(commonVariables.loginEmail != null){
            // 로그인 상태면 확인용 비밀번호 입력
            System.out.print("확인용 비밀번호: ");
            String memberPassword = scanner.next();
            // 로그인한 회원의 정보를 삭제 결과를 받는다.
            boolean result= memberRepository.delete(commonVariables.loginEmail, memberPassword);
            if (result) {
                // 삭제에 성공하면 로그인한 상태를 지우고 성공 여부 출력
                commonVariables.loginEmail = null;
                System.out.println("탈퇴 성공");
            } else {
                System.out.println("탈퇴 실패");
            }
        } else {
            System.out.println("로그인을 해주세요.");
        }
    }

    public void logout() { // 회원 로그아웃 메서드
        // 로그인한 상태인지 확인
        if (commonVariables.loginEmail != null) {
            // 로그인 상태면 로그인 상태확인 변수값을 지운다.
            // 성공여부 출력
            commonVariables.loginEmail =null;
            System.out.println("로그아웃 성공");
        } else {
            System.out.println("로그인을 해주세요.");
        }
    }

    public void board() { // 회원 게시판 메서드
        // 로그인 상태인지 확인
        if (commonVariables.loginEmail != null) {
            // 로그인 상태면 게시판 사용 가능
            // 아니면 사용 불가 메시지 출력
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

    private void listPrint(List<MemberDTO> memberDTOList) { // 회원 정보 출력 메서드
        System.out.println("id\t" + "email\t" + "name\t" + "mobile\t" + "date\t");
        for (MemberDTO memberDTO: memberDTOList) {
            System.out.println(memberDTO.getId() + "\t" + memberDTO.getMemberEmail() +
                    "\t" + memberDTO.getMemberName() + "\t" + memberDTO.getMemberMobile() + "\t"
                    + memberDTO.getCreatedAt() + "\t");
        }
    }
}
