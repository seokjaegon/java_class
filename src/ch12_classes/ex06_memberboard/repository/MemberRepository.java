package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    // 회원정보를 저장할 리스트 선언
    private static List<MemberDTO> memeberDTOList = new ArrayList<>();

    /**
     * 이메일확인 메서드
     * name: emailCheck
     * parameter: memberEmail
     * return: MemberDTO
     * 실행내용
     *      MemberService로 부터 전달받은 memberEmail을 비교하고 결과를 리턴
     */
    public MemberDTO emailCheck(String memberEmail) {
       for (MemberDTO memeberDTO: memeberDTOList) {
           if(memberEmail.equals(memeberDTO.getMemberEmail())) {
               return memeberDTO;
           }
       }
       return null;
    }

    /**
     * 회원정보 저장 메서드
     * name: save
     * parameter: MemberDTO
     * return: boolean
     * 실행내용
     *      MemberService로 부터 전달받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    public boolean save(MemberDTO memberDTO) {
        return memeberDTOList.add(memberDTO);
    }

    /**
     * 회원정보 출력 메서드
     * name: findAll
     * parameter: x
     * return: List<MemberDTO>
     * 실행내용
     *      MemberService로 부터 선언이 되면 리스트를 리턴
     */
    public List<MemberDTO> findAll() {
        return memeberDTOList;
    }

    /**
     * 회원정보 수정 메서드
     * name: update
     * parameter: memberEmail, memberMobile
     * return: MemberDTO
     * 실행내용
     *      MemberService로 부터 전달받은 매개변수를 이용해서 정보를 수정하고 결과를 리턴
     */
    public MemberDTO update(String memberEmail, String memberMobile) {
        for (int i = 0; i < memeberDTOList.size(); i++) {
            if(memberEmail.equals(memeberDTOList.get(i).getMemberEmail())) {
                memeberDTOList.get(i).setMemberMobile(memberMobile);
                return memeberDTOList.get(i);
            }
        }
        return null;
    }

    /**
     * 회원정보 삭제 메서드
     * name: delete
     * parameter: loginEmail, loginPassword
     * return: boolean
     * 실행내용
     *      MemberService로 부터 전달받은 매개변수를 이용해서 정보를 삭제하고 결과를 리턴
     */
    public boolean delete(String loginEmail, String loginPassword) {
        boolean result = false;
        for (int i = 0; i < memeberDTOList.size(); i++) {
            if(loginEmail.equals(memeberDTOList.get(i).getMemberEmail()) && loginPassword.equals(memeberDTOList.get(i).getMemberPassword())) {
                memeberDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
}
