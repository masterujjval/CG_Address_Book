package com.modules.address_book.controller;

import com.modules.address_book.addressdto.DTO;
import com.modules.address_book.entity.AddressEntity;
import com.modules.address_book.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

@Autowired
public ServiceLayer serviceLayer;
// list to store address

    @GetMapping("/api/address")
    public List<AddressEntity> address(){
        return serviceLayer.address();
    }
    @GetMapping("/api/address/{id}")
    public AddressEntity addressId(@PathVariable Long id) {
        return serviceLayer.addressId(id); 
    }

    @PostMapping("/api/address")
    public AddressEntity addEntry(@RequestBody AddressEntity entry) {
        return serviceLayer.addEntry(entry);
    }

    @DeleteMapping("/api/address/delete/{id}")
    public String deleteEntry(@PathVariable Long id){
      return serviceLayer.deleteEntry(id);
    }
    @PutMapping("/api/address/update/{id}")
    public AddressEntity updateEntry(@RequestBody AddressEntity entry, @PathVariable Long id) {
      return serviceLayer.updateEntry(entry,id);
    }

}
