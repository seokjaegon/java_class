package ch11_classes.ex05;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("1.고객등록 | 2.잔액조회 | 3.입금 | 4.출금 | 5.거래내역확인 | 6.계좌이체 | 0.종료");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                bankService.save();
            } else if (select == 2) {
                bankService.findByAccountNumber();
            } else if (select == 3) {
                bankService.deposit();
            } else if (select == 4) {
                bankService.withdraw();
            } else if (select == 5) {
                bankService.bankingList();
            } else if (select == 6) {
                bankService.transfer();
            } else if (select == 0) {
                break;
            }
        }
    }
}
