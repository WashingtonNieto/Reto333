package com.example.Reto333.Reto333.Entity.custom;


import com.example.Reto333.Reto333.Entity.Cliente;

public class countClient {
    private Long total;
    private Cliente client;

    public countClient(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
