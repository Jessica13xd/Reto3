package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.model.custom.countClient;
import com.usa.ciclo3.reto3.model.custom.descriptionAmount;
import com.usa.ciclo3.reto3.repository.reservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> rs = reservationRepository.getReservation(r.getIdReservation());
            if (!rs.isEmpty()) {
                if(r.getStartDate()!=null){
                    rs.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    rs.get().setDevolutionDate(r.getDevolutionDate());
                }
                return reservationRepository.save(rs.get());
            }
        }
        return r;
    }

    public boolean deleteReservation(int idReservation){
        boolean dr= getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return dr;
    }

    public List<countClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public descriptionAmount getStatusReservation(){
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");

        descriptionAmount descAmt= new descriptionAmount(completed.size(),cancelled.size());
        return  descAmt;
    }

    public List<Reservation> getReservationPeriod(String d1, String d2){

        ///Formato fecha yyyy-mm-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        }else {
            return new ArrayList<>();
        }
    }
}
