package com.example.Reto333.Reto333.Entity.custom;


import com.example.Reto333.Reto333.Entity.Cliente;

public class countClient {
    private Integer total;
    private Cliente client;

    public countClient(Integer total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
