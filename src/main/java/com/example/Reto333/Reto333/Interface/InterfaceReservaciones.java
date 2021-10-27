package com.example.Reto333.Reto333.Interface;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface InterfaceReservaciones extends CrudRepository <Reservaciones,Integer>{

    public List<Reservaciones> findAllByStarDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservaciones> findAllByD

}
