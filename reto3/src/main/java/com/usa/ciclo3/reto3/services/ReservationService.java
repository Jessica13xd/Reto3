package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.reservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private reservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    public Reservation save (Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(r.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(r);
            }else {
                return r;
            }
        }
    }
}
