package com.example.Reto333.Reto333.Interface;

import com.example.Reto333.Reto333.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InterfaceCliente extends CrudRepository <Cliente,Integer>{
    List<Cliente> findByAge(Integer age);
}
