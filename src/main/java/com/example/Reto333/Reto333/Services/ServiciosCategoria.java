package com.example.Reto333.Reto333.Services;


import com.example.Reto333.Reto333.Entity.Categoria;
import com.example.Reto333.Reto333.Repository.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ServiciosCategoria {

    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria category) {
        if (category.getId()==null) {
            return metodosCrud.save(category);
        } else {
            Optional<Categoria> e = metodosCrud.getCategoria(category.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }

    public Categoria update(Categoria category){
        if(category.getId()!=null){
            Optional<Categoria>g=metodosCrud.getCategoria(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return category;
    }
    /*
    //forma 1

    public boolean deleteCategory(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }*/
    //Forma 2
    public boolean deleteCategory(int categoriaId){
        Optional<Categoria> g=getCategoria(categoriaId);
        if(!g.isEmpty()){
            metodosCrud.delete(g.get());
            return true;
        }
        return false;
    }
}
