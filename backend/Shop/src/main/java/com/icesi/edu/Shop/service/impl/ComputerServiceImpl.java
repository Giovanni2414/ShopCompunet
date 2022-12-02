package com.icesi.edu.Shop.service.impl;

import com.icesi.edu.Shop.dto.ComputerDTO;
import com.icesi.edu.Shop.model.Computer;
import com.icesi.edu.Shop.repository.ComputerRepository;
import com.icesi.edu.Shop.service.ComputerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ComputerServiceImpl implements ComputerService {

    public final ComputerRepository computerRepository;

    @Override
    public Computer createComputer(Computer computerDTO) {
        return computerRepository.save(computerDTO);
    }

    @Override
    public List<Computer> getComputers() {
        return StreamSupport.stream(computerRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
