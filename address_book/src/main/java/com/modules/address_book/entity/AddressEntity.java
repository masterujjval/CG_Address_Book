package com.modules.address_book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")// Auto-increment ID
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
