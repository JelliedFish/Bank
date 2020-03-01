package bank_model.entities;

import bank_model.utils.Pair;
import bank_model.utils.Utils;

import java.util.ArrayList;
import java.util.Date;

public class DepositAccount extends BankAccount {

    private Double interestOnBalance;
    private Date expirationDate;
    private Date checkDate;
    private Double addingAmount;


    public Double getInterestOnBalance() {
        return interestOnBalance;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public Double getAddingAmount() {
        return addingAmount;
    }

    public DepositAccount(Double accountBalance, Integer accountNumber,
                          ArrayList<Pair<Pair<Double, Double>,Double>> depositChoices, Date expirationDate) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.interestOnBalance = Utils.getInterestOnBalance(depositChoices, accountBalance);
        this.expirationDate = expirationDate;
        this.checkDate = new Date();
        this.addingAmount = 0.0;
    }

    @Override
    public boolean withdraw(double money) {
        if((new Date()).before(expirationDate)) {
            System.out.println("You can't withdraw money, because it is deposit account. You should wait the last day of deposit");
            return false;
        }else if(accountBalance - money > 0){
            accountBalance -= money;
            return true;
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
            return false;
        }
    }

    @Override
    public void fund(double money) {
        accountBalance += money;
    }

    @Override
    public void update(){
        if (checkDate.equals(expirationDate){
            accountBalance += addingAmount;
            addingAmount = 0.0;
        }
        if((new Date()).before(expirationDate)){
            addingAmount += accountBalance * (interestOnBalance/365);
        }
        checkDate = new Date();
    }
}
