package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.ComputerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/computers")
@CrossOrigin(origins = "*")
public interface ComputerAPI {

    @PostMapping
    ComputerDTO createComputer(@RequestBody ComputerDTO computerDTO);

    @GetMapping
    List<ComputerDTO> getComputers();

}
