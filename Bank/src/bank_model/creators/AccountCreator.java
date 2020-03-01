package bank_model.creators;

import bank_model.entities.Bank;
import bank_model.entities.BankAccount;

public abstract class AccountCreator {

    public void linkNewAccountToClient(Bank bank, String fullName, double money){
        BankAccount bankAccount = createAccount(bank, money);
        if(bankAccount != null) {
            String[]  name = fullName.split(" ");
            bankAccount.setClientFullName(fullName);
            bank.findClient(name[0], name[1]).addAccount(bankAccount.getAccountNumber());
            bank.addAccount(bankAccount);
        }
    }

    public abstract BankAccount createAccount(Bank bank, double startBalance);
}
