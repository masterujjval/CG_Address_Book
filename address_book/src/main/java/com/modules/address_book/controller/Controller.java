package com.modules.address_book.controller;

import com.modules.address_book.addressdto.DTO;
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
    public ResponseEntity<List<DTO>> address(){
        return serviceLayer.address();
    }
    @GetMapping("/api/address/{id}")
    public ResponseEntity<?> addressId(@PathVariable int id) {
        return serviceLayer.addressId(id); // ✅ If not found, return 404
    }

    @PostMapping("/api/address")
    public ResponseEntity<String> addEntry(@RequestBody DTO entry) {
        return serviceLayer.addEntry(entry);
    }

    @DeleteMapping("/api/address/delete/{id}")
    public String deleteEntry(@PathVariable int id){
      return serviceLayer.deleteEntry(id);
    }
    @PutMapping("/api/address/update/{id}")
    public ResponseEntity<String> updateEntry(@RequestBody DTO entry, @PathVariable int id) {
      return serviceLayer.updateEntry(entry,id);
    }

}
