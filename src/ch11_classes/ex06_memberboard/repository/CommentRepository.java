package ch11_classes.ex06_memberboard.repository;

import ch11_classes.ex06_memberboard.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    private static List<CommentDTO> commentDTOList = new ArrayList<>();


    public List<CommentDTO> findId(Long id) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (int i = 0; i < commentDTOList.size(); i++) {
            if (id.equals(commentDTOList.get(i).getBoardId())) {
                commentDTOS.add(commentDTOList.get(i));
            }
        }
        return commentDTOS;
    }

    public boolean save(CommentDTO commentDTO) {
        return commentDTOList.add(commentDTO);
    }
}
