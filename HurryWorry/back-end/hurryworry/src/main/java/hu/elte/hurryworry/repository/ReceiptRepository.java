package hu.elte.hurryworry.repository;

import hu.elte.hurryworry.entities.Receipt;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * The ReceiptRepository interface extends the CrudRepository interface and creates
 * a container for the receipts.
 *
 * @author eksztazidzsi
 */
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

    /**
     * The findByName method is searching for the receipt by the given name.
     *
     * @param name The name of the receipt being searched.
     * @return Receipt The receipt with the given name.
     */
    Optional<Receipt> findByName(String name);
}
