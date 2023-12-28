package project.service;

import project.common.commonVariables;
import project.dto.BoardDTO;
import project.dto.ClientDTO;
import project.dto.MarketDTO;
import project.dto.AccountDTO;
import project.repository.BoardRepository;
import project.repository.MarketRepository;
import project.repository.MoneyRepository;

import java.util.List;
import java.util.Scanner;

public class MarketService {
    MarketRepository marketRepository = new MarketRepository();
    BoardRepository boardRepository = new BoardRepository();
    MoneyRepository moneyRepository = new MoneyRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        System.out.print("등록할 물건: ");
        String objectName = scanner.next();
        System.out.print("가격: ");
        int objectPrice = scanner.nextInt();
        MarketDTO marketDTO = new MarketDTO(commonVariables.loginEmail, objectName, objectPrice, "X");
        boolean result = marketRepository.save(marketDTO);
        if (result) {
            System.out.println("등록에 성공하셨습니다.");
        } else {
            System.out.println("등록에 실패하셨습니다.");
        }
    }

    public void findAll() {
        List<MarketDTO> marketDTOList = marketRepository.findAll();
        for (MarketDTO marketDTO: marketDTOList) {
            System.out.println(marketDTO);
        }
    }

    public void update() {
        System.out.print("확인용 이메일: ");
        String memberEmail = scanner.next();
        List<MarketDTO> marketDTOList = marketRepository.findByEmail(memberEmail);
        if (marketDTOList.size() > 0) {
            for (MarketDTO marketDTO: marketDTOList) {
                System.out.println(marketDTO);
            }
            System.out.print("수정할 물건: ");
            String objectName = scanner.next();
            System.out.print("수정할 가격: ");
            int objectPrice = scanner.nextInt();
            boolean result = marketRepository.update(memberEmail, objectName, objectPrice);
            if (result) {
                System.out.println("수정에 성공하셨습니다.");
            } else {
                System.out.println("수정에 실패하셨습니다.");
            }
        } else {
            System.out.println("등록한 물건이 없습니다.");
        }
    }

    public void delete() {
        System.out.print("확인용 이메일: ");
        String memberEmail = scanner.next();
        List<MarketDTO> marketDTOList = marketRepository.findByEmail(memberEmail);
        if (marketDTOList.size() > 0) {
            System.out.print("삭제할 물건: ");
            String objectName = scanner.next();
            boolean result = marketRepository.delete(memberEmail, objectName);
            if (result) {
                System.out.println("삭제에 성공하셨습니다.");
            } else {
                System.out.println("삭제에 실패하셨습니다.");
            }
        } else {
            System.out.println("없는 이메일 입니다.");
        }
    }

    public void money() {
        MoneyService moneyService = new MoneyService();
        while (true) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1.계좌 등록 | 2.입금 | 3.입금 내역 | 4.출금 내역 | 5.모든 내역 | 0.종료");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                moneyService.save();
            } else if (select == 2) {
                moneyService.deposit();
            } else if (select == 3) {
                moneyService.findByDeposit();
            } else if (select == 4) {
                moneyService.findByWithdraw();
            } else if (select == 5) {
                moneyService.findAll();
            }else if (select == 0) {
                break;
            }
        }
    }

    public void buy() {
        System.out.println("물건 품목");
        System.out.println("---------");
        List<MarketDTO> marketDTOList = marketRepository.findAll();
        for (MarketDTO marketDTO: marketDTOList) {
            System.out.println(marketDTO);
        }
        System.out.println("거래하고 싶은 회원을 고르세요.");
        System.out.print("> ");
        String memberEmail = scanner.next();
        System.out.println("사고 싶은 물건을 고르세요.");
        System.out.print("> ");
        String objectName = scanner.next();
        MarketDTO marketDTO = marketRepository.buy(memberEmail, objectName);
        if (marketDTO != null) {
            List<BoardDTO> boardDTOList = boardRepository.findBoard(memberEmail, objectName);
            if (boardDTOList.size() > 0) {
                for (BoardDTO boardDTO: boardDTOList) {
                    System.out.println(boardDTO);
                }
            } else {
                System.out.println("댓글이 없습니다.");
            }
            System.out.println("가격 제시와 댓글을 써주세요.");
            System.out.println("댓글쓰기를 원하면 1번, 아니면 2번을 선택해주세요.");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                System.out.print("가격 제시: ");
                long objectPrice = scanner.nextLong();
                System.out.print("댓글: ");
                String boardContents = scanner.next();
                ClientDTO clientDTO = moneyRepository.priceCompare(commonVariables.loginEmail, objectPrice);
                if (clientDTO != null) {
                    BoardDTO boardDTO = new BoardDTO(memberEmail, objectName, commonVariables.loginEmail, objectPrice, boardContents);
                    boolean result = boardRepository.save(boardDTO);
                    if (result) {
                        System.out.println("댓글 쓰기에 성공했습니다.");
                    } else {
                        System.out.println("댓글 쓰기에 실패했습니다.");
                    }
                } else {
                    System.out.println("잔고: "+ clientDTO.getBalance());
                    System.out.println("입금하고 다시 가격을 제시하세요.");
                }
            } else if (select == 2) {
                System.out.println("메인 메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("찾는 물건이 없습니다.");
        }
    }

    public void sale() {
    }
}
