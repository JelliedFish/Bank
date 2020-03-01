package bank_model.builders;

import bank_model.entities.Bank;
import bank_model.utils.Pair;

import java.util.ArrayList;

public class BankBuilder implements IBankBuilder {
    private String title;
    private Double interestOnBalance;
    private ArrayList<Pair<Pair<Double, Double>,Double>> depositChoices;
    private Integer depositPeriod;
    private Double commission;
    private Pair<Double, Double> creditLimit;
    private Pair<Double, Double> safeLimit;


    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setInterestOnBalance(Double interestOnBalance) {
        this.interestOnBalance = interestOnBalance;
    }

    @Override
    public void setDepositChoices(ArrayList<Pair<Pair<Double, Double>, Double>> depositChoices) {
        this.depositChoices = depositChoices;
    }

    @Override
    public void setDepositPeriod(Integer depositPeriod) {
        this.depositPeriod = depositPeriod;
    }

    @Override
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    @Override
    public void setCreditLimit(Pair<Double, Double> creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void setSafeLimit(Pair<Double, Double> safeLimit) {
        this.safeLimit = safeLimit;
    }

    @Override
    public void reset() {
        this.interestOnBalance = null;
        this.depositChoices = null;
        this.depositPeriod = null;
        this.commission = null;
        this.creditLimit = null;
        this.safeLimit = null;
    }

    public Bank getResult(){
        if(interestOnBalance == null && depositChoices == null && depositPeriod == null && commission == null
                && creditLimit == null) {
            System.out.println("Bank can't be built");
            return null;
        }else {
            return new Bank(title, interestOnBalance, depositChoices, depositPeriod, commission, creditLimit, safeLimit);
        }
    }


}
