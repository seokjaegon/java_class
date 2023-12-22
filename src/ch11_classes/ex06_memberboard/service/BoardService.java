package ch11_classes.ex06_memberboard.service;

import ch11_classes.ex06_memberboard.common.commonVariables;
import ch11_classes.ex06_memberboard.dto.BoardDTO;
import ch11_classes.ex06_memberboard.dto.CommentDTO;
import ch11_classes.ex06_memberboard.dto.MemberDTO;
import ch11_classes.ex06_memberboard.repository.BoardRepository;
import ch11_classes.ex06_memberboard.repository.CommentRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    BoardRepository boardRepository = new BoardRepository();
    CommentRepository commentRepository = new CommentRepository();
    Scanner scanner = new Scanner(System.in);
    public void write() { // 게시글 작성 메서드
        // 게시글 제목 작성
        System.out.print("제목: ");
        String broadTitle = scanner.next();
        // 게시글 내용 작성
        System.out.print("내용: ");
        String broadContents = scanner.next();
        // 매개변수가 있는 BoardDTO 생성자에 매개변수를 선언
        BoardDTO boardDTO = new BoardDTO(broadTitle, commonVariables.loginEmail, broadContents);
        boolean result = boardRepository.write(boardDTO);
        if (result) {
            System.out.println("글작성 완료");
        } else {
            System.out.println("글작성 실패");
        }
    }

    public void findAll() { // 게시글 목록 출력 메서드
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        listPrint(boardDTOList);
    }

    public void find() { // 게시글 댓글 작성 메서드
        // 조회할 id를 받아준다.
        System.out.print("조회할 id: ");
        Long id = scanner.nextLong();
        // id와 같은 것을 리스트에서 찾는다.
        BoardDTO boardDTO = boardRepository.findId(id);
        // 리스트에서 찾은 값이 null이 아니면 댓글을 보여준다.
        if (boardDTO != null) {
            // 조회수를 하나씩 올려준다.
            int hits = boardDTO.getBoardHits();
            hits = hits + 1;
            boardDTO.setBoardHits(hits);
            System.out.println(boardDTO);
            System.out.println("===== 댓글 ======");
            // 댓글 리스트에서 받은 id와 같은 댓글들을 찾는다.
            List<CommentDTO> commentDTOS = commentRepository.findId(id);
            // 리스트에서 댓글들이 있으면 댓글을 출력해준다.
            if(commentDTOS.size() > 0) {
                for (CommentDTO commentDTO: commentDTOS) {
                    System.out.println(commentDTO);
                }
            } else { // 리스트에 댓글이 없으면 "작성된 댓글이 없습니다."를 출력한다.
                System.out.println("작성된 댓글이 없습니다.");
            }
            // 댓글작성 여부를 확인한다.
            System.out.println("댓글을 작성하시려면 1번을 입력해주세요.");
            System.out.println("메인메뉴로 돌아가려면 2번을 입력해주세요.");
            System.out.print("입력> ");
            int select = scanner.nextInt();
            // 1을 선택하면 댓글 내용을 적을 수 있도록 한다.
            if (select == 1) {
                // 댓글 내용 작성
                System.out.print("댓글 내용: ");
                String commentContents = scanner.next();
                // 게시글 id, 댓글 작성자, 댓글 내용을 CommentDTO 생성자에 매개변수로 선언
                // 댓글 리스트에 저장
                CommentDTO commentDTO = new CommentDTO(boardDTO.getId(), commonVariables.loginEmail, commentContents);
                boolean result = commentRepository.save(commentDTO);
                if (result) {
                    System.out.println("댓글작성 성공");
                } else {
                    System.out.println("댓글작성 실패");
                }
            }
        } else { // 조회한 id가 없으면 "조회한 id가 없습니다." 출력
            System.out.println("조회한 id가 없습니다.");
        }
    }

    public void update() { // 게시글 수정 메서드
        // 수정할 id를 받는다.
        // 받은 id로 게시글에 있는지 찾아본다.
        System.out.print("수정할 id: ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findId(id);
        if (boardDTO != null) {
            // 로그인한 회원의 이메일과 게시글 작성자가 같은지 비교
            if (commonVariables.loginEmail.equals(boardDTO.getBoardWriter())) {
                System.out.print("수정 제목: ");
                String boardTitle = scanner.next();
                System.out.print("수정 내용: ");
                String boardContents = scanner.next();
                // 수정 제목, 수정 내용으로 수정
                boolean result = boardRepository.update(id, boardTitle, boardContents);
                if (result) {
                    System.out.println("수정 성공");
                } else {
                    System.out.println("수정 실패");
                }
            } else {
                System.out.println("작성자만 수정 가능합니다.");
            }
        } else {
            System.out.println("수정할 id가 없습니다.");
        }
    }

    public void delete() { // 게시글 삭제 메서드
        // 삭제할 id 작성
        System.out.print("삭제할 id: ");
        Long id = scanner.nextLong();
        // 삭제할 id에 대한 내용이 있는지 확인
        BoardDTO boardDTO = boardRepository.findId(id);
        if (boardDTO != null) {
            // 로그인한 회원의 이메일과 게시글 작성자가 같은지 확인
            if (commonVariables.loginEmail.equals(boardDTO.getBoardWriter())) {
                // 같으면 삭제
                boolean result = boardRepository.delete(id);
                if (result) {
                    System.out.println("삭제 성공");
                } else {
                    System.out.println("삭제 실패");
                }
            } else {
                System.out.println("작성자만 삭제 가능합니다.");
            }
        } else {
            System.out.println("삭제할 id가 없습니다.");
        }
    }

    public void search() { // 게시글 제목 검색 메서드
        // 검색할 제목 작성
        System.out.print("검색할 제목: ");
        String boardTitle = scanner.next();
        // 검색한 제목을 포함하고 있는 내용들을 리스트로 받아온다.
        List<BoardDTO> boardDTOList = boardRepository.search(boardTitle);
        // 리스트가 있으면 내용 출력
        if (boardDTOList.size() > 0) {
            listPrint((boardDTOList));
        } else {
            System.out.println("검색한 제목이 없습니다.");
        }
    }
    private void listPrint(List<BoardDTO> boardDTOList) { // 내용 출력 메서드
        System.out.println("id\t" + "title\t" + "writer\t" + "hits\t" + "date\t");
        for (BoardDTO boardDTO: boardDTOList) {
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() +
                    "\t" + boardDTO.getBoardWriter() + "\t" + boardDTO.getBoardHits() + "\t"
                    + boardDTO.getCreatedAt() + "\t");
        }
    }

}

