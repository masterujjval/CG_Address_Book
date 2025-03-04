package com.modules.address_book.controller;

import com.modules.address_book.addressdto.DTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final List<DTO> addressBook=new ArrayList<>();
// list to store address

    @GetMapping("/api/address")
    public List<DTO> address(){
        return addressBook;
    }
    @PostMapping("/api/address")
    public String addEntry(@RequestBody DTO entry){
        addressBook.add(entry);
        return "Entry added successfully";
    }
}
