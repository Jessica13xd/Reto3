package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private Integer stars;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
