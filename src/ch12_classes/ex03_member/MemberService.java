package ch12_classes.ex03_member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    private static String LoginEmail = null;
    public void register() {
        while (true) {
            System.out.print("이메일: ");
            String memberEmail = scanner.next();
            boolean result = memberRepository.check(memberEmail);
            if (result) {
                System.out.println("사용중인 이메일입니다.");
            } else {
                System.out.println("사용할 수 있는 이메일입니다.");
                System.out.print("비밀번호: ");
                String memberPassword = scanner.next();
                System.out.print("이름: ");
                String memberName = scanner.next();
                System.out.print("전화번호: ");
                String memberMobile = scanner.next();
                MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
                result = memberRepository.register(memberDTO);
                if (result) {
                    System.out.println("등록성공");
                    break;
                } else {
                    System.out.println("등록실패");
                }
            }
        }
        // 중복체크 결과를 담을 변수
//        boolean checkResult = false;
//        String memberEmail = null;
//        do {
//            System.out.println("이메일: ");
//            memberEmail = scanner.next();
//            checkResult = memberRepository.check(memberEmail);
//            if (checkResult) {
//                System.out.println("사용가능한 이메일 입니다.");
//            } else {
//                System.out.println("이미 사용 중인 이메일 입니다. 다른 이메일을 입력해주세요.");
//            }
//        } while (!checkResult); // checkResult 값이 false라면 계속 반복되도록

    }
    public void login() {
        while (true) {
            System.out.print("이메일: ");
            String loginEmail = scanner.next();
            System.out.print("비밀번호: ");
            String loginPassword = scanner.next();
            boolean result = memberRepository.login(loginEmail, loginPassword);
            if (result) {
                System.out.println("로그인 성공");
                LoginEmail = loginEmail;
                break;
            } else {
                System.out.println("로그인 실패");
            }
        }
    }

    public void search() {
        List<MemberDTO> memberDTOS = memberRepository.search();
        for(MemberDTO memberDTO: memberDTOS) {
            System.out.println(memberDTO);
        }
    }

    public void update() {
        if (LoginEmail != null) {
            System.out.print("수정할 전화번호: ");
            String mobile = scanner.next();
            boolean result = memberRepository.update(LoginEmail, mobile);
            if (result) {
                System.out.println("수정 완료");
            } else {
                System.out.println("수정 실패");
            }
        } else if (LoginEmail == null) {
            System.out.println("로그인하세요");
        }
    }

    public void out() {
        while(true) {
            if (LoginEmail != null) {
                System.out.print("비밀번호 확인: ");
                String password = scanner.next();
                boolean result = memberRepository.login(LoginEmail, password);
                if (result) {
                    result = memberRepository.out(LoginEmail);
                    if (result) {
                        System.out.println("탈퇴 완료");
                        break;
                    } else {
                        System.out.println("탈퇴 실패");
                    }
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            } else if (LoginEmail == null) {
                System.out.println("로그인하세요");
                break;
            }
        }
    }

    public void logout() {
        if (LoginEmail != null) {
            LoginEmail = null;
            System.out.println("로그아웃 성공");
        } else if (LoginEmail == null) {
            System.out.println("로그인하세요");
        }
    }
}
