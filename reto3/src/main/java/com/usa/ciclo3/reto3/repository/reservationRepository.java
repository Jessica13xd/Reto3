package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.model.custom.countClient;
import com.usa.ciclo3.reto3.repository.crud.reservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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
    public void delete (Reservation r) {reservationCrudRepository.delete(r);}
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    public List<countClient> getTopClients(){
        List<countClient> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalClientByReservation();
        for(int i=0;i<report.size();i++){
            res.add(new countClient((Integer) report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }
}