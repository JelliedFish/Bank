package bank_model.commands;

import bank_model.entities.BankAccount;

public abstract class Transaction {
    protected BankAccount bankAccount;
    protected Double money;
    private double backup;

    public Transaction(BankAccount bankAccount, Double money) {
        this.bankAccount = bankAccount;
        this.money = mbboney;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    void backup() {
        backup = bankAccount.getAccountBalance();
    }

    public void undo() {
        bankAccount.setAccountBalance(backup);
    }

    public abstract boolean execute();
}
