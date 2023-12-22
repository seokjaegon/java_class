package ch11_classes.ex06_memberboard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemberDTO {
    /**
     * 필드 선언
     *      회원 관리번호(id)
     *      회원 이메일(memberEmail)
     *      회원 비밀번호(memberPassword)
     *      회원 이름(memberName)
     *      회원 전화번호(memberMobile)
     *      회원 등록날짜(createdAt)
     */
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    private String createdAt;
    // 모든 필드의 getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    // MemberDTO의 기본생성자
    public MemberDTO() {

    }

    private static Long idValue = 1L;
    // MemberDTO의 매개변수가 있는 기본생성자
    public MemberDTO(String memberEmail, String memberPassword, String memberName, String memberMobile) {
        this.id = idValue++;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberMobile = memberMobile;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "MemeberDTO{" +
                "id=" + id +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberMobile='" + memberMobile + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
