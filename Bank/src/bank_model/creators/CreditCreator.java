package bank_model.creators;

import bank_model.entities.Bank;
import bank_model.entities.BankAccount;
import bank_model.entities.CreditAccount;

public class CreditCreator extends AccountCreator {
    @Override
    public BankAccount createAccount(Bank bank, double startBalance) {
        if(bank.getCreditLimit() != null && bank.getCommission() != null)
            return new CreditAccount(startBalance, bank.getAccounts().size(), bank.getCreditLimit(), bank.getCommission());
        else{
            System.out.println("This bank hasn't got Credit services");
            return null;
        }
    }

}
