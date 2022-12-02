package com.icesi.edu.Shop.controller;


import com.icesi.edu.Shop.api.ComputerAPI;
import com.icesi.edu.Shop.dto.ComputerDTO;
import com.icesi.edu.Shop.mapper.ComputerMapper;
import com.icesi.edu.Shop.service.ComputerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class ComputerController implements ComputerAPI {

    public final ComputerService computerService;

    public final ComputerMapper computerMapper;

    @Override
    public ComputerDTO createComputer(ComputerDTO computerDTO) {
        return computerMapper.fromComputer(computerService.createComputer(computerMapper.fromComputerDTO(computerDTO)));
    }

    @Override
    public List<ComputerDTO> getComputers() {
        return computerService.getComputers().stream().map(computerMapper::fromComputer).collect(Collectors.toList());
    }
}
