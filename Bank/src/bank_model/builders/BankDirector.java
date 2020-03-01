package bank_model.builders;

import bank_model.utils.Pair;

import java.util.ArrayList;

public class BankDirector {

    public void buildSberbank(IBankBuilder bankBuilder){
        bankBuilder.setTitle("Сбербанк");
        bankBuilder.setInterestOnBalance(5.5);
        ArrayList<Pair<Pair<Double, Double>, Double>> depositChoices = new ArrayList<>();
        depositChoices.add(new Pair<>(new Pair<>(0.0, 50000.0), 5.0));
        depositChoices.add(new Pair<>(new Pair<>(50000.0, 100000.0), 5.5));
        depositChoices.add(new Pair<>(new Pair<>(100000.0, Double.MAX_VALUE), 5.5));
        bankBuilder.setDepositChoices(depositChoices);
        bankBuilder.setDepositPeriod(5*365);
        bankBuilder.setSafeLimit(new Pair<>(0.0, 5000.0));
    }

    public void buildAlfaBank(IBankBuilder bankBuilder){
        bankBuilder.setTitle("Альфабанк");
        bankBuilder.setInterestOnBalance(6.0);
        bankBuilder.setCommission(15.0);
        bankBuilder.setCreditLimit(new Pair<>(-20000.0, 30000.0));
        bankBuilder.setSafeLimit(new Pair<>(0.0, 5000.0));
    }
}
