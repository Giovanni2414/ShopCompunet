package com.icesi.edu.Shop.mapper;

import com.icesi.edu.Shop.dto.ComputerDTO;
import com.icesi.edu.Shop.model.Computer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComputerMapper {

    ComputerDTO fromComputer(Computer computer);

    Computer fromComputerDTO(ComputerDTO computerDTO);

}
