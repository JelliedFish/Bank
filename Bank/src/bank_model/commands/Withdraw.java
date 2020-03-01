package bank_model.commands;

import bank_model.entities.BankAccount;

public class Withdraw extends Transaction {

    public Withdraw(BankAccount bankAccount, Double money) {
        super(bankAccount, money);
    }

    @Override
    public boolean execute() {
        backup();
        return bankAccount.withdraw(money);
    }
}
