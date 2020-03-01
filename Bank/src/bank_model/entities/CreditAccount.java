package bank_model.entities;

import bank_model.utils.Pair;

public class CreditAccount extends BankAccount {

    private Double debt;
    private Pair<Double, Double> creditLimit;
    private Double commission;

    public CreditAccount(Double accountBalance, Integer accountNumber, Pair<Double, Double> creditLimit, Double commission) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit;
        this.debt = 0.0;
        this.commission = commission;
    }

    @Override
    public boolean withdraw(double money) {
        if(accountBalance - money > 0){
            accountBalance -= money;
            return true;
        }else if(accountBalance - money >= creditLimit.first){
            accountBalance -= money;
            debt += money*commission;
            return true;
        }else{
            System.out.println("You can't withdraw money, because your limit is reached. Please, repay your loan before next month we'll call to Police");
            return false;
        }
    }

    @Override
    public void fund(double money) {
        accountBalance += money;
        if(debt - money >= 0) {
            debt -= money;
        }
    }

    @Override
    public void update(){
        accountBalance -= debt;
        debt = 0.0;
    }
}
