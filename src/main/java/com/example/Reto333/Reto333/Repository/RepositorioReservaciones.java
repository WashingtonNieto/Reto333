package com.example.Reto333.Reto333.Repository;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import com.example.Reto333.Reto333.Interface.InterfaceReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public class RepositorioReservaciones {

    @Autowired
    private InterfaceReservaciones crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }

    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }

    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }

    public List<Reservaciones> findAllByStartDateAndDevolutionDate(Date startDate, Date devolutionDate){
        return crud4.findAllByStartDateAndDevolutionDate(startDate, devolutionDate);
    }


}
