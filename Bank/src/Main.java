
import bank_model.builders.BankBuilder;
import bank_model.builders.BankDirector;
import bank_model.builders.ClientBuilder;
import bank_model.builders.ClientDirector;
import bank_model.creators.AccountCreator;
import bank_model.creators.DebitCreator;
import bank_model.creators.DepositCreator;
import bank_model.entities.Bank;
import bank_model.entities.DebitAccount;

public class Main {

    public static void main(String[] args) {
        BankBuilder bankBuilder = new BankBuilder();
        BankDirector bankDirector = new BankDirector();

        ClientBuilder clientBuilder = new ClientBuilder();
        ClientDirector clientDirector = new ClientDirector();

        AccountCreator accountCreator = new DebitCreator();

        bankDirector.buildSberbank(bankBuilder);
        Bank sberbank = bankBuilder.getResult();
        bankBuilder.reset();

        bankDirector.buildAlfaBank(bankBuilder);
        Bank alfabank = bankBuilder.getResult();
        bankBuilder.reset();

        clientDirector.createFullClient(clientBuilder, "Иван", "Иванов", "Ивановская 7", "4012 453534");
        clientBuilder.getResult(sberbank);
        clientBuilder.getResult(alfabank);
        clientBuilder.reset();

        accountCreator.linkNewAccountToClient(sberbank, "Иванов Иван", 10000);
        accountCreator = new DepositCreator();
        accountCreator.linkNewAccountToClient(sberbank, "Иванов Иван", 50000);

        sberbank.Notify();

        DebitAccount debitAccount = (DebitAccount) sberbank.findAccount(sberbank.findClient("Иванов", "Иван").getAccounts().get(0));
        System.out.println(debitAccount.getAddingAmount());
        sberbank.withdraw(0, 3000);
        System.out.println(debitAccount.getAccountBalance());
        sberbank.undo(0);
        System.out.println(debitAccount.getAccountBalance());
        System.out.println(sberbank.findClient("Иванов", "Иван").getAccounts().toString());

    }
}
