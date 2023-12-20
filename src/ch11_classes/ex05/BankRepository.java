package ch11_classes.ex05;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private static List<ClientDTO> clientDTOList = new ArrayList<>();
    private static List<AccountDTO> accountDTOList = new ArrayList<>();
    public boolean clientSave(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public boolean findNumber(String accountNumber) {
        boolean result = true;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                result = false;
            }
        }
        return result;
    }
    public long findByAccountNumber(String accountNumber) {
        long result = 0;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                result = clientDTOList.get(i).getBalance();
            }
        }
        return result;
    }

    public String findName(String accountNumber) {
        String result = "";
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                result = clientDTOList.get(i).getClientName();
            }
        }
        return result;
    }

    public boolean deposit(String accountNumber, long depositMoney) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                long balance = clientDTOList.get(i).getBalance();
                balance = balance + depositMoney;
                clientDTOList.get(i).setBalance(balance);
                result = true;
            }
        }
        return result;
    }

    public boolean findByPass(String accountNumber, String clientPass) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(accountNumber.equals(clientDTOList.get(i).getAccountNumber()) && clientPass.equals(clientDTOList.get(i).getClientPass())) {
                result = true;
            }
        }
        return result;
    }

    public boolean withdraw(String accountNumber, String clientPass, long withdrawMoney) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(accountNumber.equals(clientDTOList.get(i).getAccountNumber()) && clientPass.equals(clientDTOList.get(i).getClientPass())) {
                if(withdrawMoney <= clientDTOList.get(i).getBalance()) {
                    long balance = clientDTOList.get(i).getBalance();
                    balance = balance - withdrawMoney;
                    clientDTOList.get(i).setBalance(balance);
                    result = true;
                }
            }
        }
        return result;
    }

    public void accountSave(AccountDTO accountDTO) {
        accountDTOList.add(accountDTO);
    }

    public List<AccountDTO> findAll(String accountNumber) {
        List<AccountDTO> result = new ArrayList<>();
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (accountNumber.equals(accountDTOList.get(i).getAccountNumber())) {
                result.add(accountDTOList.get(i));
            }
        }
        return result;
    }

    public List<AccountDTO> findDeposit(String accountNumber) {
        List<AccountDTO> result = new ArrayList<>();
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (accountNumber.equals(accountDTOList.get(i).getAccountNumber())) {
                if(accountDTOList.get(i).getWithdraw() == 0 )
                    result.add(accountDTOList.get(i));
            }
        }
        return result;
    }

    public List<AccountDTO> findWithdraw(String accountNumber) {
        List<AccountDTO> result = new ArrayList<>();
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (accountNumber.equals(accountDTOList.get(i).getAccountNumber())) {
                if(accountDTOList.get(i).getDeposit() == 0 )
                    result.add(accountDTOList.get(i));
            }
        }
        return result;
    }

    public void transfer(String sendNumber, String receiveNumber, String clientPass, long money) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(sendNumber.equals(clientDTOList.get(i).getAccountNumber()) && clientPass.equals(clientDTOList.get(i).getClientPass())) {
                long balance = clientDTOList.get(i).getBalance();
                balance = balance - money;
                clientDTOList.get(i).setBalance(balance);
            }
            if(receiveNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                long balance = clientDTOList.get(i).getBalance();
                balance = balance + money;
                clientDTOList.get(i).setBalance(balance);
            }
        }
    }
}
