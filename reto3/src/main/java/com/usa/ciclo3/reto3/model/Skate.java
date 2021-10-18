package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Creation Date: 2021-10-13
 * @author Jessica Alexandra Millan
 */

@Entity
@Table(name="skate")
public class Skate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate","client"})
    private List<Message> message;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate","client"})
    private List<Reservation> reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}

