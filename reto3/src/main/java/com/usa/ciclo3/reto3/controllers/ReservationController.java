package com.usa.ciclo3.reto3.controllers;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.model.custom.countClient;
import com.usa.ciclo3.reto3.model.custom.descriptionAmount;
import com.usa.ciclo3.reto3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r){
        return reservationService.update(r);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public descriptionAmount getReservationByStatus(){
        return reservationService.getStatusReservation();
    }

    @GetMapping("/report-clients")
    public List<countClient> getCountClient(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
        return reservationService.getReservationPeriod(d1,d2);
    }
}