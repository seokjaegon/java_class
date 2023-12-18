package ch11_classes.ex03;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static List<MemberDTO> memberDTOList = new ArrayList<>();

    public boolean register (MemberDTO memberDTO) {
        boolean result = memberDTOList.add(memberDTO);
        return result;
    }

    public boolean login(String loginEmail, String loginPassword) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())&& loginPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                result = true;
            }
        }
        return result;
    }

    public List<MemberDTO> search() {
        List<MemberDTO> memberDTOS = memberDTOList;
        return memberDTOS;
    }

    public boolean update(String LoginEmail, String mobile) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if(LoginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                memberDTOList.get(i).setMemberMobile(mobile);
                result = true;
            }
        }
        return result;
    }

    public boolean out(String LoginEmail) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if(LoginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                memberDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

    public boolean check(String memberEmail) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                result = true;
            }
        }
        return result;
    }
}
