package com.TheElegance.TheElegance.exceptions;

public class RentNotFoundException extends RuntimeException{
    public RentNotFoundException(String message){
        super(message);
    }
}
