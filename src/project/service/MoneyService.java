package project.service;

import project.common.commonVariables;
import project.dto.MoneyDTO;
import project.repository.MoneyRepository;

import java.util.List;
import java.util.Scanner;

public class MoneyService {
    MoneyRepository moneyRepository = new MoneyRepository();
    Scanner scanner = new Scanner(System.in);
    public void deposit() {
        System.out.print("입금할 돈: ");
        long depositMoney = scanner.nextLong();
        MoneyDTO moneyDTO = new MoneyDTO(commonVariables.loginEmail, depositMoney, 0);
        boolean result = moneyRepository.save(moneyDTO);
        if (result) {
            System.out.println("입금에 성공하셨습니다.");
            moneyDTO = moneyRepository.deposit(commonVariables.loginEmail);
            System.out.println("잔고: "+moneyDTO.getBalance());
        } else {
            System.out.println("입금에 실패하셨습니다.");
        }
    }


    public void findByDeposit() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            List<MoneyDTO> moneyDTOList = moneyRepository.findByDeposit(memberEmail);
            if (moneyDTOList.size() > 0) {
                for (MoneyDTO moneyDTO: moneyDTOList) {
                    System.out.println(moneyDTO);
                }
            } else {
                System.out.println("입금 내역이 없습니다.");
            }
        } else {
            System.out.println("없는 이메일 입니다.");
        }
    }

    public void findByWithdraw() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            List<MoneyDTO> moneyDTOList = moneyRepository.findByWithdraw(memberEmail);
            if (moneyDTOList.size() > 0) {
                for (MoneyDTO moneyDTO: moneyDTOList) {
                    System.out.println(moneyDTO);
                }
            } else {
                System.out.println("출금 내역이 없습니다.");
            }
        } else {
            System.out.println("없는 이메일 입니다.");
        }
    }

    public void findAll() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            List<MoneyDTO> moneyDTOList = moneyRepository.findAll(memberEmail);
            if (moneyDTOList.size() > 0) {
                for (MoneyDTO moneyDTO: moneyDTOList) {
                    System.out.println(moneyDTO);
                }
            } else {
                System.out.println("내역이 없습니다.");
            }
        } else {
            System.out.println("없는 이메일 입니다.");
        }
    }
}
