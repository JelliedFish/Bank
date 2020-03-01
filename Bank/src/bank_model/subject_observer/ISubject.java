package bank_model.subject_observer;

public interface ISubject {

    void attach(IObserver observer);

    void detach(IObserver observer);

    void Notify();
}
