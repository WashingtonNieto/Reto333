package com.example.Reto333.Reto333.Repository;

import com.example.Reto333.Reto333.Entity.Skate;
import com.example.Reto333.Reto333.Interface.InterfaceSkate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioSkate {

    @Autowired
    private InterfaceSkate crud;

    public List<Skate> getAll(){
        return (List<Skate>) crud.findAll();
    }

    public Optional<Skate> getSkate(int id){
        return crud.findById(id);
    }

    public Skate save(Skate skate){
        return crud.save(skate);
    }

    public void delete(Skate skate){
        crud.delete(skate);
    }

}
