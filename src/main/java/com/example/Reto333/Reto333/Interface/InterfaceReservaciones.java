package com.example.Reto333.Reto333.Interface;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface InterfaceReservaciones extends CrudRepository <Reservaciones,Integer> {




    //JPQL
    @Query ("select c.status, COUNT(c.client) from Reservaciones as c group by c.client order by c.client) desc")
    public List<Object[]> countTotalReservaciones();

    List<Reservaciones> findAllByStartDateAndDevolutionDate(Date startDate, Date devolutionDate);



}
