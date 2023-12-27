package ch15_Interface.ex02;


import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryMap implements MemberRepository {
    private static Map<Long,MemberDTO> memberDTOMap = new HashMap<>();
    @Override
    public boolean register(MemberDTO memberDTO) {
        MemberDTO dto = memberDTOMap.put(memberDTO.getId(), memberDTO);
        if (dto == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean check(String memberEmail) {
        for (Long i: memberDTOMap.keySet()) {
            if (memberEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean login(String loginEmail, String loginPassword) {
        for (Long i: memberDTOMap.keySet()) {
            if (loginEmail.equals(memberDTOMap.get(i).getMemberEmail()) && loginPassword.equals(memberDTOMap.get(i).getMemberPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<Long, MemberDTO> search() {
        return memberDTOMap;
    }

    @Override
    public boolean update(String loginEmail, String mobile) {
        for (Long i: memberDTOMap.keySet()) {
            if (loginEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                memberDTOMap.get(i).setMemberMobile(mobile);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean out(String loginEmail) {
        for (Long i: memberDTOMap.keySet()) {
            if (loginEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                memberDTOMap.remove(i);
                return true;
            }
        }
        return false;
    }
}
