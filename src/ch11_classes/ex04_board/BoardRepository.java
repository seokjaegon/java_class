package ch11_classes.ex04_board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();
    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardDTOList;
    }

    public boolean count (Long Id) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if(Id.equals(boardDTOList.get(i).getId())) {
                // 기존 조회수 값을 가져옴
                int count = boardDTOList.get(i).getCount();
                // 1 증가 시킴
                count = count + 1;
                // 조회수 필드에 저장
                boardDTOList.get(i).setCount(count);
                result = true;
            }
        }
        return result;
    }
    public BoardDTO findById(Long Id) {
        BoardDTO result = null;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (Id.equals(boardDTOList.get(i).getId())) {
                result = boardDTOList.get(i);
            }
        }
        return result;
    }

    public boolean findByPass(Long Id, String boardPass) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if(Id.equals(boardDTOList.get(i).getId()) && boardPass.equals(boardDTOList.get(i).getBoardPass())) {
                result = true;
            }
        }
        return result;
    }

    public BoardDTO update(Long Id, String boardTitle, String boardContents) {
        BoardDTO result = null;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if(Id.equals(boardDTOList.get(i).getId())) {
                boardDTOList.get(i).setBoardTitle(boardTitle);
                boardDTOList.get(i).setBoardContents(boardContents);
                result = boardDTOList.get(i);
            }
        }
        return result;
    }

    public boolean delete(Long Id, String boardPass) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if(Id.equals(boardDTOList.get(i).getId()) && boardPass.equals(boardDTOList.get(i).getBoardPass())) {
                boardDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

    public List<BoardDTO> search(String boardTitle) {
        List<BoardDTO> result = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            if(boardDTOList.get(i).getBoardTitle().contains(boardTitle)){
                result.add(boardDTOList.get(i));
            }
        }
        return result;
    }

}
