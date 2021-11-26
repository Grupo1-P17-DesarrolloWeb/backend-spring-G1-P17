package com.TheElegance.TheElegance.models;

import org.springframework.data.annotation.Id;
public class rentSuit {
    @Id
    private String  username;
    private String  idtraje;
    private Integer totaladeudado;
    private String  address ;

    public rentSuit(String username, String idtraje, Integer totaladeudado, String address){
        this.username      = username;
        this.idtraje       = idtraje;
        this.totaladeudado = totaladeudado;
        this.address       = address;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdtraje() {
        return idtraje;
    }

    public void setIdtraje(String idtraje) {
        this.idtraje = idtraje;
    }

    public Integer getTotaladeudado() {
        return totaladeudado;
    }

    public void setTotaladeudado(Integer totaladeudado) {
        this.totaladeudado = totaladeudado;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
