package ch15_Interface.ex02;

import java.util.Map;
import java.util.Objects;

public interface MemberRepository {
    boolean register(MemberDTO memberDTO);

    boolean check(String memberEmail);

    boolean login(String loginEmail, String loginPassword);

    Object search();

    boolean update(String loginEmail, String mobile);

    boolean out(String loginEmail);
}
