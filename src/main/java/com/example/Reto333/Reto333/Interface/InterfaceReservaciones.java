package com.example.Reto333.Reto333.Interface;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface InterfaceReservaciones extends CrudRepository <Reservaciones,Integer> {

    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
//    SELECT Reservation.status, Count(*) AS Expr1
//    FROM Reservation
//    GROUP BY Reservation.status;

    @Query(value = "select r.status, count(r.status)  from reservation r GROUP BY r.status", nativeQuery = true)
    List<Reservaciones> buscarCantidadStatus();
}