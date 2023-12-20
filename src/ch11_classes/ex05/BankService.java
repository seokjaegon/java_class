package ch11_classes.ex05;

import java.util.List;
import java.util.Scanner;

public class BankService {
    BankRepository bankRepository = new BankRepository();
    Scanner scanner = new Scanner(System.in);
    ClientDTO clientDTO = new ClientDTO();
    public void save() {
        while(true) {
            System.out.print("계좌번호: ");
            String accountNumber = scanner.next();
            boolean result = bankRepository.findNumber(accountNumber);
            if (result) {
                System.out.println("사용 가능한 계좌번호 입니다.");
                System.out.print("비밀번호: ");
                String clientPass = scanner.next();
                System.out.print("이름: ");
                String clientName = scanner.next();
                ClientDTO clientDTO = new ClientDTO(clientName, accountNumber, clientPass);
                result = bankRepository.clientSave(clientDTO);
                if(result) {
                    System.out.println("고객등록 성공");
                    break;
                } else {
                    System.out.println("고객등록 실패");
                    break;
                }
            } else {
                System.out.println("이미 사용 중인 계좌번호 입니다.");
            }
        }
    }

    public void findByAccountNumber() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.next();
        boolean result = bankRepository.findNumber(accountNumber);
        if (result) {
            System.out.println("없는 계좌번호 입니다.");
        } else {
            long balance = bankRepository.findByAccountNumber(accountNumber);
            String name = bankRepository.findName(accountNumber);
            System.out.println(name+"님의 잔액은 "+balance+"원 입니다.");
        }

    }

    public void deposit() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.next();
        System.out.print("입금액: ");
        long depositMoney = scanner.nextLong();
        boolean result = bankRepository.deposit(accountNumber, depositMoney);
        if (result) {
            AccountDTO accountDTO = new AccountDTO(accountNumber,depositMoney,0);
            bankRepository.accountSave(accountDTO);
            System.out.println("입금 완료");
        } else {
            System.out.println("해당 계좌가 없습니다.");
        }
    }

    public void withdraw() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.next();
        boolean result = bankRepository.findNumber(accountNumber);
        if (result) {
            System.out.println("없는 계좌번호 입니다.");
        } else {
            System.out.print("비밀번호: ");
            String clientPass = scanner.next();
            result = bankRepository.findByPass(accountNumber, clientPass);
            if(result) {
                System.out.print("출금액: ");
                long withdrawMoney = scanner.nextLong();
                result = bankRepository.withdraw(accountNumber, clientPass, withdrawMoney);
                if (result) {
                    AccountDTO accountDTO = new AccountDTO(accountNumber,0,withdrawMoney);
                    bankRepository.accountSave(accountDTO);
                    System.out.println("출금 완료");
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }
    }

    public void findAccountList() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.next();
        boolean result = bankRepository.findNumber(accountNumber);
        if(result) {
            System.out.println("없는 계좌번호 입니다.");
        } else {
            while(true) {
                System.out.println("----------------------------------------------");
                System.out.println("1.모든 내역 | 2.입금 내역 | 3.출금 내역 | 4.종료");
                System.out.println("----------------------------------------------");
                System.out.print("선택> ");
                int select = scanner.nextInt();
                if (select == 1) {
                    List<AccountDTO> accountDTOList = bankRepository.findAll(accountNumber);
                    for (AccountDTO accountDTO: accountDTOList) {
                        System.out.println(accountDTO);
                    }
                } else if (select == 2) {
                    List<AccountDTO> accountDTOList = bankRepository.findDeposit(accountNumber);
                    for (AccountDTO accountDTO: accountDTOList) {
                        System.out.println(accountDTO);
                    }
                } else if (select == 3) {
                    List<AccountDTO> accountDTOList = bankRepository.findWithdraw(accountNumber);
                    for (AccountDTO accountDTO: accountDTOList) {
                        System.out.println(accountDTO);
                    }
                } else if (select == 4) {
                        break;
                }
            }
        }
    }

    public void transfer() {
        System.out.print("보내실 분 계좌번호: ");
        String sendNumber = scanner.next();
        System.out.print("받으실 분 계좌번호: ");
        String receiveNumber = scanner.next();
        System.out.print("보낼 금액: ");
        long money = scanner.nextLong();
        String name = bankRepository.findName(receiveNumber);
        System.out.println("받으실 분이 " + name + "이 맞습니까?");
        System.out.println("맞으면 1번, 틀리면 2번을 입력해주세요.");
        System.out.print("입력> ");
        int select = scanner.nextInt();
        if (select == 1) {
            System.out.print("비밀번호를 입력해 주세요: ");
            String clientPass = scanner.next();
            boolean result = bankRepository.findByPass(sendNumber, clientPass);
            if(result) {
                AccountDTO accountDTO = new AccountDTO(sendNumber,0,money);
                bankRepository.accountSave(accountDTO);
                AccountDTO accountDTO1 = new AccountDTO(receiveNumber,money,0);
                bankRepository.accountSave(accountDTO1);
                bankRepository.transfer(sendNumber, receiveNumber, clientPass, money);
                System.out.println("이체가 완료되었습니다.");
            } else {
                System.out.println("이체가 완료되지 않았습니다.");
            }
        } else if (select == 2) {
            System.out.println("다시 입력해 주세요");
        }
    }

}

