package com.example.Reto333.Reto333.Entity.custom;

import com.example.Reto333.Reto333.Entity.Reservaciones;

public class CountReservaciones {

    private Integer total;
    private Reservaciones status;

    public CountReservaciones(Integer total, Reservaciones status) {
        this.total = total;
        this.status = status;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Reservaciones getStatus() {
        return status;
    }

    public void setStatus(Reservaciones status) {
        this.status = status;
    }
}
