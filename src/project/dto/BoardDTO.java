package project.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDTO {
    private Long id;
    private String memberEmail;
    private String boardEmail;
    private int objectPrice;
    private String boardContents;
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

    public String getBoardEmail() {
        return boardEmail;
    }

    public void setBoardEmail(String boardEmail) {
        this.boardEmail = boardEmail;
    }

    public int getObjectPrice() {
        return objectPrice;
    }

    public void setObjectPrice(int objectPrice) {
        this.objectPrice = objectPrice;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public BoardDTO() {

    }

    private static Long idValue = 1L;

    public BoardDTO(String memberEmail, String boardEmail, int objectPrice, String boardContents) {
        this.id = idValue++;
        this.memberEmail = memberEmail;
        this.boardEmail = boardEmail;
        this.objectPrice = objectPrice;
        this.boardContents = boardContents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", memberEmail='" + memberEmail + '\'' +
                ", boardEmail='" + boardEmail + '\'' +
                ", objectPrice=" + objectPrice +
                ", boardContents='" + boardContents + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
