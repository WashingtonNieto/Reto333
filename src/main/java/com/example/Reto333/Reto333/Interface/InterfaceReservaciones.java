package com.example.Reto333.Reto333.Interface;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface InterfaceReservaciones extends CrudRepository <Reservaciones,Integer> {


    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

//    @Query(value = "SELECT c.client, COUNT(c.client) FROM Reservaciones AS c GROUP BY c.client ORDER BY COUNT(c.client) desc", nativeQuery = true)
    @Query("SELECT c.client, COUNT(c.client) FROM Reservaciones AS c GROUP BY c.client ORDER BY COUNT(c.client)DESC")
    public List<Object[]> countTotalClientByReservation();

    public List<Reservaciones> findAllByStatus(String status);


}
