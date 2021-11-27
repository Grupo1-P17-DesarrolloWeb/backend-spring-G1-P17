package com.TheElegance.TheElegance.controllers;

import com.TheElegance.TheElegance.models.rentSuit;
import com.TheElegance.TheElegance.repositories.RentSuitRepository;
import com.TheElegance.TheElegance.exceptions.RentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RentSuitController {
    private final RentSuitRepository rentSuitRepository;

    public RentSuitController(RentSuitRepository rentSuitRepository){
        this.rentSuitRepository = rentSuitRepository;
    }

    @GetMapping("/rents/{username}")
    rentSuit getRents(@PathVariable String username){
        return this.rentSuitRepository.findById(username).
                orElseThrow(() -> new RentNotFoundException("El usuario "+ username +" no se encuentra en nuestra base de datos"));
    }

    @PostMapping("/rents")
    rentSuit makeanorder(@RequestBody @Valid rentSuit rent){
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
    @GetMapping("/allrents")
    public ResponseEntity<List<rentSuit>> getAllTutorials(@RequestParam(required = false) String username) {
        try {
            List<rentSuit> allrents = new ArrayList<rentSuit>();

            if (username == null)
                rentSuitRepository.findAll().forEach(allrents::add);

            if (allrents.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(allrents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
