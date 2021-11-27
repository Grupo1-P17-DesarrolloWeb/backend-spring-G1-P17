package com.TheElegance.TheElegance.models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import org.springframework.data.annotation.Id;


public class rentSuit {
    @Id
    @NotBlank(message = "El usuario es requerido.")
    @NotNull(message = "El usuario no puede ser nulo")
    private String  username;

    @NotBlank(message = "El codigo del traje es requerido.")
    @NotNull(message = "El codigo del traje es requerido")
    private String  idtraje;

    @Positive
    @NotNull(message = "EL total adeudado no puede ser nulo")
    private Integer totaladeudado;

    @NotBlank(message = "El mensaje es requerido.")
    @NotNull(message = "La dirección no puede ser nula")
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
