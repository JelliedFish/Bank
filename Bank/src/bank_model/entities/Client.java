package bank_model.entities;

import java.util.ArrayList;

public class Client {
    private final String name;
    private final String surname;
    private final String address;
    private final String passportNumber;
    private final ArrayList<Integer> accounts;

    public Client(String name, String surname, String address, String passportNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passportNumber = passportNumber;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Integer accountNumber){
        accounts.add(accountNumber);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public ArrayList<Integer> getAccounts() {
        return accounts;
    }
}
