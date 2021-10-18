package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.crud.reservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class reservationRepository {
    @Autowired
    private reservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }
}