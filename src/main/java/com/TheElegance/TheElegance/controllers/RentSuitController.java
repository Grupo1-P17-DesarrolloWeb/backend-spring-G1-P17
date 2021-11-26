package com.TheElegance.TheElegance.controllers;

import com.TheElegance.TheElegance.models.rentSuit;
import com.TheElegance.TheElegance.repositories.RentSuitRepository;
import com.TheElegance.TheElegance.exceptions.RentNotFoundException;

import org.springframework.web.bind.annotation.*;

@RestController
public class RentSuitController {
    private final RentSuitRepository rentSuitRepository;

    public RentSuitController(RentSuitRepository rentSuitRepository){
        this.rentSuitRepository = rentSuitRepository;
    }

    @GetMapping("/rents/{username}")
    rentSuit getRents(@PathVariable String username){
        return this.rentSuitRepository.findById(username).
                orElseThrow(() -> new RentNotFoundException("El usuario "+ username +" no tiene trajes en alquiler"));
    }

    @PostMapping("/rents")
    rentSuit makeanorder(@RequestBody rentSuit rent){
        return rentSuitRepository.save(rent);
    }

    @PutMapping("/rents/update")
    rentSuit updaterent(@RequestBody rentSuit myupdate){
        rentSuit rent = this.rentSuitRepository.findById(myupdate.getUsername()).orElse(null);
        if(rent==null){
            throw new RentNotFoundException("No se puede editar la orden, comuniquese con servicio al cliente +57 4010000.");
        }
        rent.setAddress(myupdate.getAddress());
        return rentSuitRepository.save(rent);

    }

    @DeleteMapping("rents/delete/{username}")
    String deleterent(@PathVariable String username){
        rentSuit rent = rentSuitRepository.findById(username).orElse(null);
        if(rent == null){
            throw new RentNotFoundException("El alquiler que quieres eliminar no se pudo encontrar");
        }
        this.rentSuitRepository.deleteById(username);
        return "Eliminacion completa";
    }


}
