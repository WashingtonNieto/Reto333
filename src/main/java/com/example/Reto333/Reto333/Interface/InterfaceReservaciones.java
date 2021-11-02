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


    @Query("SELECT r.status, COUNT(r.status) FROM Reservations AS r GROUP BY r.status ORDER BY count(r.status) desc")
    public List<Object[]> countTotalByStatus();

    public List<Reservaciones> findAllByStatus(String status);



}
