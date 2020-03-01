package bank_model.commands;

import bank_model.entities.BankAccount;

public class Fund extends Transaction {

    public Fund(BankAccount bankAccount, Double money) {
        super(bankAccount, money);
    }

    @Override
    public boolean execute() {
        backup();
        bankAccount.fund(money);
        return true;
    }
}
