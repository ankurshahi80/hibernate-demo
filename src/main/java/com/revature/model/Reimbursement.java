package com.revature.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity // Tells Hibernate that this is a table
@Table(name = "ers_reimb") // Optional, but allows us to define our table.
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increments
    private int id;

    @Column(name = "reimb_amount", nullable = false)
    private double amount;

    @JoinColumn(name="reimb_author")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE) // If user is deleted then it will also delete all of their relations
    private User author;

    @Column(name="reimb_description")
    private String description;

    public Reimbursement() {
    }

    public Reimbursement(double amount, User author, String description) {
        this.amount = amount;
        this.author = author;
        this.description = description;
    }

    public Reimbursement(int id, double amount, User author, String description) {
        this.id = id;
        this.amount = amount;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", author=" + author +
                ", description='" + description + '\'' +
                '}';
    }
}
