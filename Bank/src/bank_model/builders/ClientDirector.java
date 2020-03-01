package bank_model.builders;

public class ClientDirector {

    public void createFullClient(ClientBuilder clientBuilder, String name, String surname, String address, String passportNumber){
        clientBuilder.setName(name);
        clientBuilder.setSurname(surname);
        clientBuilder.setAddress(address);
        clientBuilder.setPassportNumber(passportNumber);
    }

    public void createPartialClient(ClientBuilder clientBuilder, String name, String surname){
        clientBuilder.setName(name);
        clientBuilder.setSurname(surname);
    }
}
