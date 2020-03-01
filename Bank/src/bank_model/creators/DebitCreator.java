package bank_model.creators;

import bank_model.entities.Bank;
import bank_model.entities.BankAccount;
import bank_model.entities.DebitAccount;

public class DebitCreator extends AccountCreator {
    @Override
    public BankAccount createAccount(Bank bank, double startBalance) {
        if(bank.getInterestOnBalance() != null) {
            return new DebitAccount(startBalance, bank.getAccounts().size(), bank.getInterestOnBalance());
        }else{
            System.out.println("This bank hasn't got Debit services");
            return null;
        }
    }
}
