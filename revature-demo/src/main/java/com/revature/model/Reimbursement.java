package com.revature.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="ers_reimb")
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reimb_amount", nullable = false)
    private double amount;

    // This is a foreign key
    @Column(name="reimb_author")
    @ManyToOne // Many reimbursement for each other
    @OnDelete(action= OnDeleteAction.CASCADE) // Hibernate annotation. If the user
    // deleted, it will also delete all of their reimbursements.
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(author, that.author) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, author, description);
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
