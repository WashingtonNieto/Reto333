package com.example.Reto333.Reto333.Controller;

import com.example.Reto333.Reto333.Entity.Cliente;
import com.example.Reto333.Reto333.Services.ServiciosCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorCliente {
    @Autowired
    private ServiciosCliente ServiciosCliente;

    @GetMapping("/age/{age}")
    public List<Cliente> getByAge(@PathVariable Integer age){
        return ServiciosCliente.findByAge(age);
    }


    @GetMapping("/all")
    public List<Cliente> getClients(){
        return ServiciosCliente.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {
        return ServiciosCliente.getClient(clientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {
        return ServiciosCliente.save(client);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente client) {
        return ServiciosCliente.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return ServiciosCliente.deleteClient(clientId);
    }

}
