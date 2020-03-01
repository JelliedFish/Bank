package bank_model.builders;

public interface IClientBuilder {
    void setName(String name);
    void setSurname(String surname);
    void setAddress(String address);
    void setPassportNumber(String passportNumber);
    void reset();
}
