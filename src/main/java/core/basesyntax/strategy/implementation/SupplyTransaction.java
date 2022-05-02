package core.basesyntax.strategy.implementation;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;
import core.basesyntax.storage.Storage;

public class SupplyTransaction implements TransactionHandler {
    private Storage storage = new Storage();

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit challenger = transaction.getFruit();
        if (storage.get(challenger) != null) {
            Integer newQuantity = storage.get(challenger) + transaction.getQuantity();
            storage.add(challenger, newQuantity);
            return true;
        }
        storage.add(challenger, transaction.getQuantity());
        return true;
    }
}