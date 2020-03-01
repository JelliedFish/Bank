package bank_model.commands;

import java.util.Stack;

public class TransactionHistory {
    private Stack<Transaction> history = new Stack<>();

    public void push(Transaction t) {
        history.push(t);
    }

    public Transaction pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
