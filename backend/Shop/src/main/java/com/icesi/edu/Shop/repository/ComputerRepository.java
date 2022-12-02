package com.icesi.edu.Shop.repository;

import com.icesi.edu.Shop.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, UUID> {
}
