package bank_model.builders;

import bank_model.entities.Bank;
import bank_model.entities.Client;

public class ClientBuilder implements IClientBuilder {

    private String name;
    private String surname;
    private String address;
    private String passportNumber;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public void reset() {
        this.name = null;
        this.surname = null;
        this.address = null;
        this.passportNumber = null;
    }

    public Client getResult(Bank bank){
        if(name != null && surname != null) {
            Client client = new Client(name, surname, address, passportNumber);
            bank.addClient(client);
            return client;
        }
        else {
            System.out.println("Client information is not sufficient");
            return null;
        }
    }

}
