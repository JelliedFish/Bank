package bank_model.creators;

import bank_model.entities.Bank;
import bank_model.entities.BankAccount;
import bank_model.entities.DepositAccount;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DepositCreator extends AccountCreator {

    @Override
    public BankAccount createAccount(Bank bank, double startBalance) {
        if(bank.getDepositChoices() != null && bank.getDepositPeriod() != null) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, bank.getDepositPeriod());
            Date expirationDate = calendar.getTime();
            return new DepositAccount(startBalance, bank.getAccounts().size(), bank.getDepositChoices(), expirationDate);
        }else{
            System.out.println("This bank hasn't got Deposit services");
            return null;
        }
    }
}
