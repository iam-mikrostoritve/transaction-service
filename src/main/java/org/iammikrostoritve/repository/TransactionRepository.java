package org.iammikrostoritve.repository;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.iammikrostoritve.entity.Transaction;

import java.util.List;

@ApplicationScoped
public class TransactionRepository {
    public Uni<Void> insert(Transaction transaction) {
        return transaction.persist().replaceWithVoid();
    }

    public Uni<List<Transaction>> getAll() {
        return Transaction.listAll();
    }
}
