package hu.elte.hurryworry.controller;

import hu.elte.hurryworry.entities.Receipt;
import hu.elte.hurryworry.repository.ReceiptRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ReceiptController class implements a REST controller which can handle
 * get, post, put, delete requests.
 *
 * @author eksztazidzsi
 */
@CrossOrigin
@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    /**
     * The repository instance of the controller.
     */
    @Autowired
    private ReceiptRepository receiptRepository;

    /**
     * The getAll method returns all of the data from the table.
     * @return All data from the receipts table.
     */
    @GetMapping("")
    public ResponseEntity<Iterable<Receipt>> getAll() {
        return ResponseEntity.ok(receiptRepository.findAll());
    }

    /**
     * The get method returns the receipt with the given id.
     * @param id The id of the receipt.
     * @return The receipt with the given id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Receipt> get(final @PathVariable Long id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        if (receipt.isPresent()) {
            return ResponseEntity.ok(receipt.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * The post method puts a new record into the table.
     * @param receipt The receipt we want to add to the table.
     * @return The new receipt instance.
     */
    @PostMapping("")
    public ResponseEntity<Receipt> post(final @RequestBody Receipt receipt) {
        Receipt newReceipt = receiptRepository.save(receipt);
        return ResponseEntity.ok(newReceipt);
    }

    /**
     * The put method sets the id of the given receipt to the given id.
     * @param receipt The receipt we want to update.
     * @param id The id of the receipt.
     * @param name The new name of the receipt.
     * @return The updated receipt instance.
     */
    @PutMapping("/{id}/{name}")
    public ResponseEntity<Receipt> put(@RequestBody Receipt receipt, final @PathVariable Long id, final @PathVariable String name) {
        Optional<Receipt> optionalReceipt = receiptRepository.findById(id);
        if (optionalReceipt.isPresent()) {
            receipt.setName(name);
            return ResponseEntity.ok(receiptRepository.save(receipt));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * The delete method deletes a receipt from the table given by id.
     * @param id The id of the receipt.
     * @return The deleted receipt instance.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Receipt> delete(final @PathVariable Long id) {
        Optional<Receipt> optionalReceipt = receiptRepository.findById(id);
        if (optionalReceipt.isPresent()) {
            receiptRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
