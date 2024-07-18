package com.TradeTracker.entity;


import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length =25,nullable = false, unique = true)
    @NotBlank(message = "fill the user name")
    private String userName;

    @Column(length =25,  nullable = false, unique = true)
    @NotBlank(message = "fill the email")
    @Email(message = "fill valid email ")
    private String email;
    
    @Column( length =10, nullable = false)
    @NotBlank(message = "fill the phone number")
    private String phoneNo;
    
    @Column(length =25,  nullable = true)
    @NotBlank(message = "fill the address")
    private String address;

    @Column(length =15, nullable = false)
    @NotBlank(message = "fill the password")
    private String passwordHash;

    @CreationTimestamp
    @Column(nullable = false, updatable=false)
    private Date createdAt;
     
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JsonManagedReference("user-transactions")
    private Set<Transaction> transactions;

   @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("user-portfolios")
   private Set<Portfolio> portfolios;

   @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JsonManagedReference("user-watchlists")
   private Set<Watchlist> watchlists;
   
   @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("user-orders")
    private Set<Order> orders;
}
