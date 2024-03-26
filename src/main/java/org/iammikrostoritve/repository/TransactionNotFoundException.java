package org.iammikrostoritve.repository;

public class TransactionNotFoundException extends Exception {
    public TransactionNotFoundException(String id) {
        super("Transaction with id " + id + " not found");
    }
}
