package bank_model.commands;

import bank_model.entities.BankAccount;

public class Transfer extends Transaction {

    private BankAccount otherAccount;

    public Transfer(BankAccount bankAccount, Double money, BankAccount otherAccount) {
        super(bankAccount, money);
        this.otherAccount = otherAccount;
    }

    @Override
    public boolean execute() {
        backup();
        return bankAccount.transfer(otherAccount, money);
    }
}
