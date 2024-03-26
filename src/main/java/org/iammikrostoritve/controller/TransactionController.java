package org.iammikrostoritve.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.iammikrostoritve.dto.InsertTransaction;
import org.iammikrostoritve.entity.Transaction;
import org.iammikrostoritve.repository.TransactionRepository;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("/transactions")
public class TransactionController {

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    @Channel("logs")
    Emitter<String> logsEmitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Void> insertTransaction(InsertTransaction insertTransaction) {
        Transaction transaction = new Transaction(
                insertTransaction.getUserId(),
                insertTransaction.getRecordIds(),
                LocalDateTime.now(),
                insertTransaction.getTotalPrice()
        );
        System.out.println("Transaction inserted");
        logsEmitter.send("Post transaction called");
        return transactionRepository.insert(transaction);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Transaction>> getAllTransactions() {
        logsEmitter.send("Get all transactions called");
        return transactionRepository.getAll();
    }
}
