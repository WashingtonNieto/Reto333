package com.example.Reto333.Reto333.Repository;

import ch.qos.logback.core.net.server.Client;
import com.example.Reto333.Reto333.Entity.Cliente;
import com.example.Reto333.Reto333.Entity.Reservaciones;
import com.example.Reto333.Reto333.Entity.custom.countClient;
import com.example.Reto333.Reto333.Interface.InterfaceReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioReservaciones {

    @Autowired
    private InterfaceReservaciones InterfaceReservaciones;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) InterfaceReservaciones.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return InterfaceReservaciones.findById(id);
    }

    public Reservaciones save(Reservaciones reservation){
        return InterfaceReservaciones.save(reservation);
    }

    public void delete(Reservaciones reservation){
        InterfaceReservaciones.delete(reservation);
    }

    public List<Reservaciones> getReservationPeriod(Date a, Date b){
        return InterfaceReservaciones.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservaciones> getReservationByStatus(String status){
        return InterfaceReservaciones.findAllByStatus(status);
    }

    /*
    public List<countClient> getTopClients(){
        List<countClient> res=new ArrayList<>();

        List<Object[]> report=InterfaceReservaciones.countTotalClientByReservation();
        for(int i=0;i<report.size();i++){
            res.add(new countClient((Integer) report.get(i)[1], (Cliente) report.get(i)[0]));
        }
        return res;
    }
    */
}
