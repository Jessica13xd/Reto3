package com.usa.ciclo3.reto3.repository.crud;

import com.usa.ciclo3.reto3.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface reservationCrudRepository extends CrudRepository<Reservation, Integer> {

    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalClientByReservation();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

    public List<Reservation> findAllByStatus(String status);
}
