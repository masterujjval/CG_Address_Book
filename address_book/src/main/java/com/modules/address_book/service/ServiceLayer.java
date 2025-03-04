package com.modules.address_book.service;
import com.modules.address_book.addressdto.DTO;
import com.modules.address_book.entity.AddressEntity;
import com.modules.address_book.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {


    @Autowired
    private  AddressRepository addressRepository;


    // method to perform operation
    public List<AddressEntity> address(){
        return addressRepository.findAll();
    }

    public AddressEntity addressId(Long id) {
        return addressRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
    }

    public AddressEntity addEntry(AddressEntity entry) {
        return addressRepository.save(entry);
    }

    public String deleteEntry(Long id){
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Id not found, cannot delete");
        }
        addressRepository.deleteById(id);
        return "Record deleted";
    }

    public AddressEntity updateEntry(@RequestBody AddressEntity entry, Long id) {

        return addressRepository.findById(id).map(updateEntry->{

            updateEntry.setName(entry.getName());
            updateEntry.setAddress(entry.getAddress());
            return addressRepository.save(updateEntry);


        }).orElseThrow(()->new RuntimeException("Id not found in Address book"));

    }


}
