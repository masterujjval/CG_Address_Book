package com.modules.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.modules.address_book.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
