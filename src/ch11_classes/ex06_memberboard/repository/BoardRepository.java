package ch11_classes.ex06_memberboard.repository;

import ch11_classes.ex06_memberboard.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();
    public boolean write(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }


    public List<BoardDTO> findAll() {
        return boardDTOList;
    }

    public boolean find(Long id) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                int hits = boardDTOList.get(i).getBoardHits();
                hits = hits + 1;
                boardDTOList.get(i).setBoardHits(hits);
                result = true;
            }
        }
        return result;
    }


    public BoardDTO findId(Long id) {
        BoardDTO boardDTO = null;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                boardDTO = boardDTOList.get(i);
            }
        }
        return boardDTO;
    }

    public boolean update(Long id, String boardTitle, String boardContents) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                boardDTOList.get(i).setBoardTitle(boardTitle);
                boardDTOList.get(i).setBoardContents(boardContents);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(Long id) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
               boardDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
}
