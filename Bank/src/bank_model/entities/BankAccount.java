package bank_model.entities;

import bank_model.commands.TransactionHistory;
import bank_model.subject_observer.IObserver;

public abstract class BankAccount implements IObserver {

    protected double accountBalance;
    protected Integer accountNumber;
    protected String clientFullName;
    TransactionHistory history = new TransactionHistory();


    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public abstract boolean withdraw(double money);
    public abstract void fund(double money);


    public boolean transfer(BankAccount otherAccount, double money){
        if(this.withdraw(money)){
            otherAccount.fund(money);
            return true;
        }
        return false;
    }

    @Override
    public void update() {

    }
}
