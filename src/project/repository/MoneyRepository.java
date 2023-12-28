package project.repository;

import project.dto.MoneyDTO;

import java.util.ArrayList;
import java.util.List;

public class MoneyRepository {
    private static List<MoneyDTO> moneyDTOList = new ArrayList<>();


    public boolean save(MoneyDTO moneyDTO) {
        return moneyDTOList.add(moneyDTO);
    }


    public MoneyDTO deposit(String loginEmail) {
        for (int i = 0; i < moneyDTOList.size(); i++) {
            if(loginEmail.equals(moneyDTOList.get(i).getMemberEmail()) && moneyDTOList.get(i).getDeposit() > 0) {
                long balance = moneyDTOList.get(i).getBalance();
                balance = balance + moneyDTOList.get(i).getDeposit();
                moneyDTOList.get(i).setBalance(balance);
                return moneyDTOList.get(i);
            }
        }
        return null;
    }

    public List<MoneyDTO> findByDeposit(String memberEmail) {
        List<MoneyDTO> moneyDTOS = new ArrayList<>();
        for (int i = 0; i < moneyDTOList.size(); i++) {
            if(memberEmail.equals(moneyDTOList.get(i).getMemberEmail()) && moneyDTOList.get(i).getDeposit() > 0) {
                moneyDTOS.add(moneyDTOList.get(i));
                return moneyDTOS;
            }
        }
        return null;
    }

    public List<MoneyDTO> findByWithdraw(String memberEmail) {
        List<MoneyDTO> moneyDTOS = new ArrayList<>();
        for (int i = 0; i < moneyDTOList.size(); i++) {
            if(memberEmail.equals(moneyDTOList.get(i).getMemberEmail()) && moneyDTOList.get(i).getWithdraw() > 0) {
                moneyDTOS.add(moneyDTOList.get(i));
                return moneyDTOS;
            }
        }
        return null;
    }

    public List<MoneyDTO> findAll(String memberEmail) {
        List<MoneyDTO> moneyDTOS = new ArrayList<>();
        for (int i = 0; i < moneyDTOList.size(); i++) {
            if(memberEmail.equals(moneyDTOList.get(i).getMemberEmail())) {
                moneyDTOS.add(moneyDTOList.get(i));
                return moneyDTOS;
            }
        }
        return null;
    }
}
