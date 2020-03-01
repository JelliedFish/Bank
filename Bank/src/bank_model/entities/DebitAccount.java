package bank_model.entities;

import java.util.Date;

public class DebitAccount extends BankAccount {

    private Double interestOnBalance;
    private Date checkDate;
    private Double addingAmount;

    public Double getInterestOnBalance() {
        return interestOnBalance;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public Double getAddingAmount() {
        return addingAmount;
    }

    public DebitAccount(Double accountBalance, Integer accountNumber, Double interestOnBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.interestOnBalance = interestOnBalance;
        checkDate = new Date();
        addingAmount = 0.0;
    }

    @Override
    public boolean withdraw(double money) {
        if(accountBalance - money > 0) {
            accountBalance -= money;
            return true;
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
            return false;
        }
    }

    @Override
    public void fund(double money) {
        accountBalance+=money;
    }

    @Override
    public void update(){
       
    }
}
