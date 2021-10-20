package com.example.Reto333.Reto333.Controller;


import com.example.Reto333.Reto333.Entity.Skate;
import com.example.Reto333.Reto333.Services.ServiciosSkate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorSkate {
    @Autowired
    private ServiciosSkate servicio;
    @GetMapping("/all")
    public List<Skate> getSkate(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Skate> getBike(@PathVariable("id") int skateId) {
        return servicio.getSkate(skateId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate) {
        return servicio.save(skate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate) {
        return servicio.update(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int skateId) {
        return servicio.deleteSkate(skateId);
    }
}
