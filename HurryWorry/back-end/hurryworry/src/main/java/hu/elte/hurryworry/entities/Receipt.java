package hu.elte.hurryworry.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * The Receipt class implements a receipt of a user (group).
 *
 * @author eksztazidzsi
 */
@Data
@Entity
@Table(
    name = "Receipt",
    schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Receipt {

    /**
     * The unique id of the receipt.
     */
    @Id
    @Column(
        name = "id",
        updatable = false,
        unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The time the record was created.
     */
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * The time the record was last updated.
     */
    @Column(
        name = "updated_at",
        nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * The name of the receipt.
     */
    @Column(
        name = "name",
        nullable = false,
        length = 50)
    private String name;

    /**
     * The set of users attached to the receipt.
     */
    @ManyToMany(mappedBy = "receipts")
    @JsonIgnore
    private Set<User> users;

    /**
     * The set of users attached to the receipt.
     */
    @ManyToMany(mappedBy = "receipts")
    @JsonIgnore
    private Set<Item> items;

    /**
     * Evaluates if two receipts are equal.
     */
    @Override
    public boolean equals(Object other) {
        Receipt receipt = (Receipt) other;

        if (receipt.id == this.id) {
            return true;
        }
        return false;
    }

    /**
     * Returns the hash of the entity.
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Returns the id of the receipt.
     * @return The id of the receipt.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Returns the name of the receipt.
     * @return The name of the receipt.
     */
    public String getName() {
        return this.name;
    }

    /**
     * The setter for name field.
     * @param newName The new name of the receipt.
     */
    public void setName(String newName) {
        this.name = newName;
    }
}
