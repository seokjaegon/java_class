package ch11_classes.ex06_memberboard.repository;

import ch11_classes.ex06_memberboard.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static List<MemberDTO> memeberDTOList = new ArrayList<>();

    public MemberDTO emailCheck(String memberEmail) {
       for (MemberDTO memeberDTO: memeberDTOList) {
           if(memberEmail.equals(memeberDTO.getMemberEmail())) {
               return memeberDTO;
           }
       }
       return null;
    }

    public boolean save(MemberDTO memberDTO) {
        return memeberDTOList.add(memberDTO);
    }

    public List<MemberDTO> findAll() {
        return memeberDTOList;
    }

    public MemberDTO update(String memberEmail, String memberMobile) {
        for (int i = 0; i < memeberDTOList.size(); i++) {
            if(memberEmail.equals(memeberDTOList.get(i).getMemberEmail())) {
                memeberDTOList.get(i).setMemberMobile(memberMobile);
                return memeberDTOList.get(i);
            }
        }
        return null;
    }

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
