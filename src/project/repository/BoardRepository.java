package project.repository;

import project.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();


    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> findBoard(String memberEmail) {
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (memberEmail.equals(boardDTOList.get(i).getMemberEmail())) {
                boardDTOS.add(boardDTOList.get(i));
                return boardDTOS;
            }
        }
        return null;
    }
}
