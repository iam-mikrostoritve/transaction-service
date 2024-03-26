package org.iammikrostoritve.repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.iammikrostoritve.entity.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class TransactionRepositoryTest {

    @Inject
    TransactionRepository transactionRepository;

    @Test
    public void testGetAllTransactions() {
        transactionRepository.insert(new Transaction(
                "user1",
                new ArrayList<>(),
                LocalDateTime.now(),
                100.0)).await().indefinitely();

        List<Transaction> transactions = transactionRepository.getAll().await().indefinitely();

        assert transactions.get(transactions.size() - 1).getUserId().equals("user1");
    }
}