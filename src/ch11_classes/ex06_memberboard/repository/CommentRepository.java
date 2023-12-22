package ch11_classes.ex06_memberboard.repository;

import ch11_classes.ex06_memberboard.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    // 댓글을 저장할 리스트 선언
    private static List<CommentDTO> commentDTOList = new ArrayList<>();

    /**
     * 댓글조회 메서드
     * name: findId
     * parameter: id
     * return: List<CommentDTO>
     * 실행내용
     *      BoardService로 부터 전달받은 id를 리스트에 있는 id와 비교하고
     *      id에 대한 DTO객체를 리스트에 저장하고 결과를 리턴
     */
    public List<CommentDTO> findId(Long id) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (int i = 0; i < commentDTOList.size(); i++) {
            if (id.equals(commentDTOList.get(i).getBoardId())) {
                commentDTOS.add(commentDTOList.get(i));
            }
        }
        return commentDTOS;
    }

    /**
     * 댓글 저장 메서드
     * name: save
     * parameter: CommentDTO
     * return: boolean
     * 실행내용
     *      BoardService로 부터 전달받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    public boolean save(CommentDTO commentDTO) {
        return commentDTOList.add(commentDTO);
    }
}
