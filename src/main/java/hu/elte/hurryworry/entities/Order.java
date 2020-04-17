/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.hurryworry.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Gergő
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    
    @Column
    private Integer product_id;
        
    @Column
    private Integer product_price;
    
    @Column
    private Integer bill_id_hova_rendel;

    
    @Column
    private String comment;
    
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at_rendeles_ideje;

    
}
