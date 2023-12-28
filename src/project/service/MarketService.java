package project.service;

import project.common.commonVariables;
import project.dto.MarketDTO;
import project.dto.MemberDTO;
import project.repository.MarketRepository;

import java.util.List;
import java.util.Scanner;

public class MarketService {
    MarketRepository marketRepository = new MarketRepository();
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

    }

    public void buy() {

    }

}
