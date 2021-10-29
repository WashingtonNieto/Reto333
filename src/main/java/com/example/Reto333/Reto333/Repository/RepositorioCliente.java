package com.example.Reto333.Reto333.Repository;

import com.example.Reto333.Reto333.Entity.Cliente;
import com.example.Reto333.Reto333.Interface.InterfaceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCliente {

    @Autowired
    private InterfaceCliente crud1;

    public List<Cliente> findByAge(Integer age){
        return crud1.findByAge(age);
    }

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        return crud1.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
    public void delete(Cliente cliente){
        crud1.delete(cliente);
    }



}
