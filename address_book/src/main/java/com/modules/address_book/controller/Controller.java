package com.modules.address_book.controller;

import com.modules.address_book.addressdto.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final List<DTO> addressBook=new ArrayList<>();
// list to store address

    @GetMapping("/api/address")
    public ResponseEntity<List<DTO>> address(){
        if (addressBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(addressBook);
        }
        return ResponseEntity.ok(addressBook);
    }
    @GetMapping("/api/address/{id}")
    public ResponseEntity<?> addressId(@PathVariable int id) {
        for (DTO dto : addressBook) {
            if (dto.getId() == id) {
                return ResponseEntity.ok(dto); // ✅ If found, return DTO
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found"); // ✅ If not found, return 404
    }

    @PostMapping("/api/address")
    public ResponseEntity<String> addEntry(@RequestBody DTO entry) {
        addressBook.add(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entry added successfully");
    }

    @DeleteMapping("/api/address/delete/{id}")
    public String deleteEntry(@PathVariable int id){
        addressBook.remove(id);
        return "record deleted";
    }
    @PutMapping("/api/address/update/{id}")
    public ResponseEntity<String> updateEntry(@RequestBody DTO entry, @PathVariable int id) {
        for (DTO dto : addressBook) {
            if (dto.getId() == id) {  // ✅ ID match check
                dto.setName(entry.getName());
                dto.setAddress(entry.getAddress());
                return ResponseEntity.status(HttpStatus.OK).body("Address Updated Successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No entry found with ID: " + id);
    }

}
