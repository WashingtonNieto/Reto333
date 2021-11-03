package com.example.Reto333.Reto333.Services;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import com.example.Reto333.Reto333.Entity.custom.countClient;
import com.example.Reto333.Reto333.Entity.custom.descriptionAmount;
import com.example.Reto333.Reto333.Repository.RepositorioReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ServiciosReservaciones {

    @Autowired
    private RepositorioReservaciones RepositorioReservaciones;

    public List<Reservaciones> getAll(){
        return RepositorioReservaciones.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return RepositorioReservaciones.getReservation(reservationId);
    }


    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return RepositorioReservaciones.save(reservation);
        }else{
            Optional<Reservaciones> e= RepositorioReservaciones.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                return RepositorioReservaciones.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= RepositorioReservaciones.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                RepositorioReservaciones.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            RepositorioReservaciones.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }


//    public List<countClient> getTopClients(){
//        return RepositorioReservaciones.getTopClients();
//    }

    public descriptionAmount getStatusReservation(){
        List<Reservaciones> completed=RepositorioReservaciones.getReservationByStatus("completed");
        List<Reservaciones> cancelled=RepositorioReservaciones.getReservationByStatus("cancelled");

        descriptionAmount descAmt= new descriptionAmount(completed.size(), cancelled.size());
        return descAmt;
    }


    public List<Reservaciones> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a=new Date();
        Date b=new Date();
        try{
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return RepositorioReservaciones.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }


}
