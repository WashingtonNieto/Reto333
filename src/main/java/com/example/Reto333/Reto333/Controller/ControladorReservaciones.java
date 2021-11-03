package com.example.Reto333.Reto333.Controller;

import com.example.Reto333.Reto333.Entity.Reservaciones;
import com.example.Reto333.Reto333.Entity.custom.countClient;
import com.example.Reto333.Reto333.Entity.custom.descriptionAmount;
import com.example.Reto333.Reto333.Services.ServiciosReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorReservaciones {

    @Autowired
    private ServiciosReservaciones serviciosReservaciones;

    @GetMapping("/all")
    public List<Reservaciones> getReservations(){
        return serviciosReservaciones.getAll();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones> getReservationReportDates(
            @PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo ){
        return serviciosReservaciones.getReservationsPeriod(dateOne,dateTwo);
    }

    @GetMapping("/report-status")
    public descriptionAmount getReservacionesByStatus(){
        return serviciosReservaciones.getStatusReservation();
    }

    //@GetMapping("/report-clients")
    //public List<countClient> getCountClient(){
    //    return serviciosReservaciones.getTopClients();
    //}
    // otra modificacion, para actualizar

    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return serviciosReservaciones.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return serviciosReservaciones.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return serviciosReservaciones.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return serviciosReservaciones.deleteReservation(reservationId);
    }
}
