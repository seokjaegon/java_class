package ch11_classes.ex06_memberboard.repository;

import ch11_classes.ex06_memberboard.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    // 게시글을 저장할 리스트 선언
    private static List<BoardDTO> boardDTOList = new ArrayList<>();

    /**
     * 게시글 등록 메서드
     * name: write
     * parameter: BoardDTO
     * return: boolean
     * 실행내용
     *      BoardService로 부터 전달받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    public boolean write(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    /**
     * 게시글 출력 메서드
     * name: findAll
     * parameter: x
     * return: List<BoardDTO>
     * 실행내용
     *      BoardService로 부터 호출되면 리스트를 리턴
     */
    public List<BoardDTO> findAll() {
        return boardDTOList;
    }

    /**
     * 게시글 조회 메서드
     * name: findId
     * parameter: id
     * return: BoardDTO
     * 실행내용
     *      BoardService로 부터 전달받은 id를 리스트에 있는 id와 비교한 결과를 리턴
     */
    public BoardDTO findId(Long id) {
        BoardDTO boardDTO = null;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                boardDTO = boardDTOList.get(i);
            }
        }
        return boardDTO;
    }

    /**
     * 게시글 수정 메서드
     * name: update
     * parameter: id, boardTitle, boardContents
     * return: boolean
     * 실행내용
     *      BoardService로 부터 전달받은 매개변수를 이용해 리스트의 값을 수정하고 결과를 리턴
     */
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

    /**
     * 게시글 삭제 메서드
     * name: delete
     * parameter: id
     * return: boolean
     * 실행내용
     *      BoardService로 부터 전달받은 id를 리스트에 있는 id와 비교해서
     *      리스트의 값을 삭제하고 결과를 리턴
     */
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

    /**
     * 게시글 검색 메서드
     * name: search
     * parameter: boardTitle
     * return: List<BoardDTO>
     * 실행내용
     *      BoardService로 부터 전달받은 boardTitle를 리스트에 있는 제목과 비교해서
     *      같은 제목이면 리스트에 저장하고 결과를 리턴
     */
    public List<BoardDTO> search(String boardTitle) {
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (boardDTOList.get(i).getBoardTitle().contains(boardTitle)) {
                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return boardDTOS;
    }
}
