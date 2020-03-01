package bank_model.builders;

import bank_model.utils.Pair;

import java.util.ArrayList;

public interface IBankBuilder {
    void setTitle(String title);
    void setInterestOnBalance(Double interestOnBalance);
    void setDepositChoices(ArrayList<Pair<Pair<Double, Double>, Double>> depositChoices);
    void setDepositPeriod(Integer depositPeriod);
    void setCommission(Double commission);
    void setCreditLimit(Pair<Double, Double> creditLimit);
    void setSafeLimit(Pair<Double, Double> safeLimit);
    void reset();
}
