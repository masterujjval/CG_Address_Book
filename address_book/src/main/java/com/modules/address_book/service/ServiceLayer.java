package com.modules.address_book.service;
import com.modules.address_book.addressdto.DTO;
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

    private final List<DTO> addressBook=new ArrayList<>();;


    // method to perform operation
    public ResponseEntity<List<DTO>> address(){
        if (addressBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(addressBook);
        }
        return ResponseEntity.ok(addressBook);
    }

    public ResponseEntity<?> addressId(int id) {
        for (DTO dto : addressBook) {
            if (dto.getId() == id) {
                return ResponseEntity.ok(dto); // ✅ If found, return DTO
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found"); // ✅ If not found, return 404
    }

    public ResponseEntity<String> addEntry( @RequestBody DTO entry) {
        addressBook.add(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entry added successfully");
    }

    public String deleteEntry(int id){
        addressBook.remove(id);
        return "record deleted";
    }

    public ResponseEntity<String> updateEntry(@RequestBody DTO entry, int id) {
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
