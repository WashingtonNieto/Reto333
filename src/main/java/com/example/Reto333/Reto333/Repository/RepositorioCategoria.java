package com.example.Reto333.Reto333.Repository;

import com.example.Reto333.Reto333.Entity.Categoria;
import com.example.Reto333.Reto333.Interface.InterfaceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class RepositorioCategoria {

    @Autowired
    private InterfaceCategoria crud;
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return crud.findById(id);
    }
    public Categoria save(Categoria Categoria){
        return crud.save(Categoria);
    }
    public void delete(Categoria Categoria){
        crud.delete(Categoria);
    }
}
