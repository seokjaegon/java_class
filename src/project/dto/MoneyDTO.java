package project.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MoneyDTO {
    private Long id;
    private String memberEmail;
    private long balance = 0;
    private long deposit;
    private long withdraw;
    private String createdAt;

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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public MoneyDTO() {

    }

    private static Long idValue = 1L;

    public MoneyDTO(String memberEmail, long deposit, long withdraw) {
        this.id = idValue++;
        this.memberEmail = memberEmail;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "MoneyDTO{" +
                "id=" + id +
                ", memberEmail='" + memberEmail + '\'' +
                ", balance=" + balance +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
