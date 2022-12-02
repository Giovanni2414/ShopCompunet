package com.icesi.edu.Shop.service;

import com.icesi.edu.Shop.dto.ComputerDTO;
import com.icesi.edu.Shop.model.Computer;

import java.util.List;

public interface ComputerService {
    Computer createComputer(Computer computerDTO);
    List<Computer> getComputers();
}
