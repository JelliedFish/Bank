package bank_model.entities;

import bank_model.commands.Fund;
import bank_model.commands.Transaction;
import bank_model.commands.Transfer;
import bank_model.commands.Withdraw;
import bank_model.subject_observer.IObserver;
import bank_model.subject_observer.ISubject;
import bank_model.utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements ISubject {

    private final String title;
    private final HashMap<String, Client> clients;
    private final HashMap<String, BankAccount> accounts;
    private final ArrayList<IObserver> observerAccounts;
    private final Double interestOnBalance;
    private final ArrayList<Pair<Pair<Double, Double>,Double>> depositChoices;
    private final Integer depositPeriod;
    private final Double commission;
    private final Pair<Double, Double> creditLimit;
    private final Pair<Double, Double> safeLimit;

    public Bank(String title, Double interestOnBalance, ArrayList<Pair<Pair<Double, Double>, Double>> depositChoices,
                Integer depositPeriod, Double commission, Pair<Double, Double> creditLimit, Pair<Double, Double> safeLimit) {
        this.title = title;
        this.clients = new HashMap<>();
        this.accounts = new HashMap<>();
        this.observerAccounts = new ArrayList<>();
        this.interestOnBalance = interestOnBalance;
        this.depositChoices = depositChoices;
        this.depositPeriod = depositPeriod;
        this.commission = commission;
        this.creditLimit = creditLimit;
        this.safeLimit = safeLimit;
    }

    public void addClient(Client client){
        clients.put(client.getSurname() + client.getName(), client);
    }

    public Client findClient(String surname, String name){
        return clients.get(surname + name);
    }

    public void deleteClient(String surname, String name){
        Client client = findClient(surname, name);
        for (Integer accountNumber: client.getAccounts()) {
            deleteAccount(accountNumber);
        }
        clients.remove(surname + name);
    }

    public void addAccount(BankAccount account){
        accounts.put(account.accountNumber.toString(), account);
        attach(account);
    }

    public BankAccount findAccount(Integer accountNumber){
        return accounts.get(accountNumber.toString());
    }

    public void deleteAccount(Integer accountNumber){
        accounts.remove(accountNumber.toString());
        detach(findAccount(accountNumber));
    }



    public HashMap<String, Client> getClients() {
        return clients;
    }

    public HashMap<String, BankAccount> getAccounts() {
        return accounts;
    }

    public Double getInterestOnBalance() {
        return interestOnBalance;
    }

    public ArrayList<Pair<Pair<Double, Double>, Double>> getDepositChoices() {
        return depositChoices;
    }

    public Double getCommission() {
        return commission;
    }

    public Pair<Double, Double> getCreditLimit() {
        return creditLimit;
    }

    public Pair<Double, Double> getSafeLimit() {
        return safeLimit;
    }

    public Integer getDepositPeriod() {
        return depositPeriod;
    }

    @Override
    public void attach(IObserver observer) {
        observerAccounts.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observerAccounts.remove(observer);
    }

    @Override
    public void Notify() {
        for (IObserver observer:
             observerAccounts) {
            observer.update();
        }
    }

    private void executeTransaction(Transaction transaction, BankAccount bankAccount){
        if(transaction.execute()){
            bankAccount.history.push(transaction);
        }
    }

    public void undo(Integer accountNumber) {
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount.history.isEmpty()) return;

        Transaction transaction = bankAccount.history.pop();
        if (transaction != null) {
            transaction.undo();
        }
    }

    public void withdraw(Integer accountNumber, double money){
        BankAccount account = findAccount(accountNumber);
        Double accountBalance = account.getAccountBalance();
        String[] fullName = account.getClientFullName().split(" ");
        Client client = findClient(fullName[0], fullName[1]);
        if((client.getAddress() != null && client.getPassportNumber() != null) ||
                (accountBalance - money >= safeLimit.first && money <= safeLimit.second)) {
            executeTransaction(new Withdraw(account, money), account);
        }
    }

    public void fund(Integer accountNumber, double money){
        BankAccount account = findAccount(accountNumber);
        executeTransaction(new Fund(account, money), account);
    }

    public void transfer(Integer accountNumber1, Integer accountNumber2, double money){
        BankAccount account1 = findAccount(accountNumber1);
        Double accountBalance = account1.getAccountBalance();
        String[] fullName = account1.getClientFullName().split(" ");
        Client client = findClient(fullName[0], fullName[1]);
        BankAccount account2 = findAccount(accountNumber2);
        if((client.getAddress() != null && client.getPassportNumber() != null) ||
                (accountBalance - money >= safeLimit.first && money <= safeLimit.second)) {
            executeTransaction(new Transfer(account1, money, account2), account1);
        }
    }


}
