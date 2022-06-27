package org.jjoselon.jaxws.models;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    public Invoice() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @XmlTransient
    private Date date;

    @Column
    private String description;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number=" + number +
                ", date=" + date +
                '}';
    }

}
